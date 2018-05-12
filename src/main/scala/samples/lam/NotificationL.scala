package samples.lam

import com.raquo.laminar.api.L._

class NotificationL private (
    val node: Node
)

object NotificationL {
  def apply(noOfComments: Signal[Int]): NotificationL = {
    val text = noOfComments.map {
      case x if x > 2 => h1("Too many Comments. Reduce those")
      case _          => h1()
    }
    val node = div(
      child <-- text
    )
    new NotificationL(node)
  }
}
