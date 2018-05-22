package samples.sjr

import japgolly.scalajs.react.component.Scala.Unmounted
import SaneImports._
import japgolly.scalajs.react.{BackendScope, Callback}
import org.scalajs.dom.html.Div

class RMainComponentBackend($ : BackendScope[Unit, Int]) {

  def getLength(commentList: CommentList): Callback = $.modState(_ => commentList.list.length)

  val commentBoxComp: Unmounted[ParentCallBack, CommentList, RCommentBoxBackend] =
    RCommentBox.build(ParentCallBack(commentList => getLength(commentList)))

  def render(length: Int): VdomTagOf[Div] =
    E.div(
      commentBoxComp,
      RNotification.build(length)
    )

}
