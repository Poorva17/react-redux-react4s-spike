package samples.lam

import com.raquo.laminar.api.L._
import samples.CommentListExample.commentList.NotificationEvent

object ConnectorL {
  def create(): Node = {
    val commentBox   = CommentBoxL.create()
    val noOfComments = commentBox.notificationEvents.map(NotificationEvent.update)

    div(
      commentBox.node,
      NotificationL.create(noOfComments)
    )
  }
}
