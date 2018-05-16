package samples.lam

import com.raquo.laminar.api.L._

object LNotification {
  def create(): Node = {
    val text = LCommentStore.commentLength.map {
      case x if x > 2 => "Too many Comments. Reduce those"
      case _          => ""
    }
    div(
      h1(child.text <-- text)
    )
  }
}
