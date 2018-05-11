package samples

import com.github.ahnfelt.react4s._
import samples.CommentListExample.connector.Connector
import samples.theme._

case class PageComponent(page: P[Page]) extends Component[NoEmit] {

  override def render(get: Get): Element = {
    get(page) match {
      case HomePage           => renderMainPage()
      case ExamplesPage(_)    => renderMainPage()
      case CommentListPage(_) => renderCommentListPage()
    }
  }

  def renderMainPage() = {
    E.div(
      ContentColumnCss,
      E.div(
        CodeColumnCss,
        Component(FrontComponent),
      ),
      E.div(
        ResultColumnCss,
      )
    )
  }

  def renderCommentListPage() = {
    E.div(
      ContentColumnCss,
      E.div(
        CodeColumnCss,
        Text("This example shows a simple Comment list."),
        E.div(SpacerCss),
      ),
      E.div(
        ResultColumnCss,
        Component(Connector)
      )
    )
  }
}
