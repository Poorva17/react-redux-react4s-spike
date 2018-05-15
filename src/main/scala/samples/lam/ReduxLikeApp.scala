package samples.lam

import com.raquo.laminar.api.L._

object ReduxLikeApp {
  def create(): Node = div(
    CommentBoxL.create(),
    NotificationL.create()
  )
}
