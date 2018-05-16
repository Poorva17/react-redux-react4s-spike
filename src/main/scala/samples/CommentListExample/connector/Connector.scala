package samples.CommentListExample.connector

import com.github.ahnfelt.react4s._
import samples.CommentListExample.Notification.Notification
import samples.CommentListExample.commentList.CommentBox
import samples.CommentListExample.commentList.CommentBox.UpdateNoOfComments

case class Connector() extends Component[NoEmit] {

  val noOfCommentsS = State(0)

  override def render(get: Get): ElementOrComponent = {

    def handleCommentBoxEvents(msg: CommentBox.Msg): Unit = msg match {
      case UpdateNoOfComments(noOfComments) => noOfCommentsS.set(noOfComments)
    }

    E.div(
      E.div(
        Component(CommentBox).withHandler(handleCommentBoxEvents)
      ),
      E.div(
        Component(Notification, get(noOfCommentsS))
      )
    )
  }
}
