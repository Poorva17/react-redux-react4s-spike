package samples.lam

import com.raquo.laminar.api.L._

object ReduxLikeApp {
  def create(): Node = {
    val store = new Store
    div(
      CommentBoxL.create(store.commentModels, store.commentBus.writer),
      NotificationL.create(store.commentLength)
    )
  }
}
