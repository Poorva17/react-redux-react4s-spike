package samples.CommentListExample

import samples.CommentListExample.commentList.CommentBox._
import samples.CommentListExample.commentList.CommentModel
import samples.GlobalStore

object CommentsStore extends GlobalStore[Msg, List[CommentModel]](List.empty[CommentModel]) {
  override def onEmit(message: Msg, currentValue: List[CommentModel]): List[CommentModel] = {
    message match {
      case AddComment(author, comment) => currentValue :+ CommentModel(author, comment)
    }
  }

}
