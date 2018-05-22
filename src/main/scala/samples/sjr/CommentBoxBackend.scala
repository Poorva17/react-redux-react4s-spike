package samples.sjr

import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.{BackendScope, Callback, ScalaComponent, ScalaFnComponent}
import org.scalajs.dom.html.Div

class CommentBoxBackend($ : BackendScope[ParentCallBack, CommentList]) {

  private val commentForm = ScalaComponent
    .builder[CommentBoxCallBack]("comment form")
    .initialStateFromProps(p => Comment("", ""))
    .renderBackend[CommentFormBackend]
    .build

  private val listing = ScalaFnComponent[List[Comment]] { props =>
    def createItem(item: Comment) =
      <.div(<.li(<.p(s"Comment Author - ${item.author}"), <.p(s"Comment - ${item.comment}")))
    <.ul(props map createItem: _*)
  }

  def addComment(comment: Comment): Callback = {
    $.modState { (s, callback) =>
      callback.getLength(s).runNow()
      s.copy(s.list :+ comment)
    }
  }

  def render(s: CommentList): VdomTagOf[Div] =
    <.div(
      if (s.show) {
        <.div(
          <.button("Hide", ^.onClick --> $.modState(_.copy(show = false))),
          <.div(s"comments: ", listing(s.list))
        )
      } else {
        <.button("Show", ^.onClick --> $.modState(_.copy(show = true)))
      },
      commentForm(CommentBoxCallBack(comment => addComment(comment)))
    )

}
