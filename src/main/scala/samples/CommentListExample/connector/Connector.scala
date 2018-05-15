package samples.CommentListExample.connector

import com.github.ahnfelt.react4s._
import samples.CommentListExample.Notification.Notification
import samples.CommentListExample.commentList.{CommentBox, NotificationEvent}

case class Connector() extends Component[NoEmit] {

  val noOfComments = State(0)

  override def render(get: Get): ElementOrComponent = {
    def increment(): Unit = {
      noOfComments.set(get(noOfComments) + 1)
    }

    E.div(
      E.div(
        Component(CommentBox, increment _)
      ),
      E.div(
        Component(Notification, get(noOfComments))
      )
    )
  }
}
