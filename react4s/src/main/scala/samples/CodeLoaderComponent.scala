package samples

import com.github.ahnfelt.react4s._
import samples.theme._
import org.scalajs.dom.ext.Ajax
import scala.concurrent.ExecutionContext.Implicits.global

case class CodeLoaderComponent(path: P[String], symbol: P[Option[String]], highlight: P[Boolean]) extends Component[NoEmit] {

  var showImports = State(false)

  val prefix =
    "https://raw.githubusercontent.com/Ahnfelt/react4s-samples/master/src/main/scala/com/github/ahnfelt/react4s/samples/"
  def url(get: Get) = prefix + get(path)

  val loader = Loader(this, url) { u =>
    Ajax.get(u).map(_.responseText)
  }

  def filterCode(get: Get, code: String) = {
    val noImports =
      if (get(showImports)) code
      else {
        code.lines
          .dropWhile(
            l =>
              l.trim.isEmpty ||
              l.startsWith("import") ||
              l.startsWith("package")
          )
          .mkString("\n")
      }
    get(symbol)
      .filter(_ => !get(showImports))
      .map(s => noImports.lines.dropWhile(l => !l.contains(s)).takeWhile(!_.startsWith("}")))
      .map(c => c.mkString("\n") + "\n}")
      .getOrElse(noImports)
  }

  override def render(get: Get): Element = {
    E.div(
      S.position.relative(),
      E.div(
        CodeButtonCss,
        Text(if (get(showImports)) "Hide imports" else "Show imports"),
        A.onLeftClick(_ => showImports.modify(!_))
      ),
      if (get(loader.loading)) E.pre(CodeCss, Text("Loading..."))
      else if (get(loader.error).nonEmpty) E.pre(CodeCss, Text("Error loading:\n" + url(get)))
      else Component(CodeComponent, get(loader).map(filterCode(get, _)).getOrElse(""), get(highlight))
    )
  }
}
