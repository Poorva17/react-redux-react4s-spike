package samples.lam

import com.raquo.laminar.api.L._
import samples.r4s.CommentModel
import samples.r4s.CommentStore.{AddCommentToStore, CommentsStoreMsg}

object LCommentStore {
  val commentBus = new EventBus[CommentsStoreMsg]

  val commentModels: Signal[List[CommentModel]] = commentBus.events.fold(List.empty[CommentModel])(onEmit)

  val commentLength: Signal[Int] = commentModels.map(_.length)

  def onEmit(currentValue: List[CommentModel], message: CommentsStoreMsg): List[CommentModel] = {
    message match {
      case AddCommentToStore(author, comment) => currentValue :+ CommentModel(author, comment)
    }
  }
}
