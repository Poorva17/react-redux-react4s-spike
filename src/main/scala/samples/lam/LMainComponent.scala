package samples.lam

import com.raquo.laminar.api.L._

object LMainComponent {
  def create(): Node = {
    div(
      LCommentBox.create(),
      LNotification.create()
    )
  }
}
