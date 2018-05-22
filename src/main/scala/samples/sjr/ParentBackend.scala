package samples.sjr

import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.{BackendScope, Callback, ScalaComponent}
import org.scalajs.dom.html.Div

class ParentBackend($ : BackendScope[Unit, Int]) {

  def getLength(commentList: CommentList): Callback = $.modState(_ => commentList.list.length)

  def render(length: Int): VdomTagOf[Div] =
    <.div(
      commentListing(ParentCallBack(commentList => getLength(commentList))),
      Notification(length)
    )

  private val Notification = ScalaComponent
    .builder[Int]("notification")
    .render_P { length =>
      if (length >= 2) {
        <.div("NOTICE : -- > Comments are exceeding the required count")
      } else {
        <.div()
      }
    }
    .build

  private val commentListing = ScalaComponent
    .builder[ParentCallBack]("Comments")
    .initialState(CommentList(List.empty[Comment]))
    .renderBackend[CommentBoxBackend]
    .build

}
