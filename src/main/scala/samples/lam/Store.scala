package samples.lam

import com.raquo.laminar.api.L._
import samples.CommentListExample.commentList.{CommentEvent, CommentModel}

class Store {
  val commentBus = new EventBus[CommentEvent]

  val commentModels: Signal[List[CommentModel]] = commentBus.events.fold(List.empty[CommentModel])(CommentEvent.update)

  val commentLength: Signal[Int] = commentModels.map(_.length)
}
