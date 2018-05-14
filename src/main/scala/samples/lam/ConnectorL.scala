package samples.lam

import com.raquo.laminar.api.L._
import samples.CommentListExample.commentList.NotificationEvent

object ConnectorL {
  def create(): Node = {
    val commentBox   = CommentBoxL.create()
    val noOfComments = commentBox.notificationEvent.map(NotificationEvent.update)

    val notification = NotificationL.create(noOfComments)

    div(
      commentBox.node,
      notification
    )
  }
}
