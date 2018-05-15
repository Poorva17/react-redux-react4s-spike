package samples.lam

import com.raquo.laminar.api.L._

object NotificationL {
  def create(commentLength: Signal[Int]): Node = {
    val text = commentLength.map {
      case x if x > 2 => "Too many Comments. Reduce those"
      case _          => ""
    }
    div(
      h1(child.text <-- text)
    )
  }
}
