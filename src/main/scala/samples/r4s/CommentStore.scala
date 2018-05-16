package samples.r4s

import samples.GlobalStore

object CommentStore extends GlobalStore[List[CommentModel]](List.empty[CommentModel]) {
  override def onEmit(message: Msg, currentValue: List[CommentModel]): List[CommentModel] = {
    message match {
      case AddCommentToStore(author, comment) => currentValue :+ CommentModel(author, comment)
    }
  }

  override type Msg = CommentsStoreMsg

  sealed trait CommentsStoreMsg
  case class AddCommentToStore(author: String, comment: String) extends CommentsStoreMsg
}
