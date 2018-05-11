package samples

import com.github.ahnfelt.react4s._
import samples.theme._

case class CodeComponent(code: P[String], highlight: P[Boolean]) extends Component[NoEmit] {

  val pattern =
    """
        (abstract|case|catch|class|def|do|else|extends|false|final|finally|for|forSome|if|implicit|import|lazy|match|new|null|object|override|package|private|protected|return|sealed|super|this|throw|trait|try|true|type|val|var|while|with|yield)\b|
        ([A-Z][A-Za-z0-9_]*)|
        ([a-z][A-Za-z0-9_]*)|
        (["](?:[^"]|[\\]["])*["])|
        ([0-9]+(?:[.][0-9]+)?(?:[eE][0-9]+)?)
    """.lines.map(_.trim).filter(_.nonEmpty).mkString.r

  def find(text: String): Seq[Tag] = {
    var previous = 0
    val matched = pattern.findAllMatchIn(text).toList.flatMap { m =>
      val plain = if (m.start == previous) List() else List(Text(text.slice(previous, m.start)))
      previous = m.end
      plain ++ List(
        E.span(
          if (m.group(1) != null) KeywordCss
          else if (m.group(2) != null) UpperCss
          else if (m.group(3) != null) LowerCss
          else if (m.group(4) != null) StringCss
          else if (m.group(5) != null) NumberCss
          else DefaultCodeCss,
          Text(m.group(0))
        )
      )
    }
    val plain = if (text.length == previous) List() else List(Text(text.drop(previous)))
    matched ++ plain
  }

  override def render(get: Get): Element = {
    E.pre(CodeCss,
          E.span(
            DefaultCodeCss,
            if (get(highlight)) Tags(find(get(code).trim))
            else Text(get(code).trim)
          ))
  }
}

object DefaultCodeCss
    extends CssClass(
      S.color(Palette.muted)
    )

object KeywordCss
    extends CssClass(
      S.color(Palette.accent),
    )

object UpperCss
    extends CssClass(
      S.color(Palette.accent),
    )

object LowerCss
    extends CssClass(
      S.color.rgb(18, 75, 96),
    )

object StringCss
    extends CssClass(
      S.color(Palette.muted),
    )

object NumberCss
    extends CssClass(
      S.color(Palette.muted),
    )
