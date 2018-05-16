package samples.lam

import samples.CommentListExample.commentList.CommentModel

sealed trait CommentEvent
case class AddComment(author: String, comment: String) extends CommentEvent

sealed trait NotificationEvent
case class UpdateNoOfComments(noOfComments: Int) extends NotificationEvent

object CommentEvent {
  def update(commentList: List[CommentModel], event: CommentEvent): List[CommentModel] = event match {
    case AddComment(author, comment) => commentList :+ CommentModel(author, comment)
  }
}

object NotificationEvent {
  def update(event: NotificationEvent): Int = event match {
    case UpdateNoOfComments(noOfComments: Int) => noOfComments
  }
}
