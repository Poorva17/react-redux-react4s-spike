package samples.CommentListExample.Notification

import com.github.ahnfelt.react4s._

case class Notification(noOfComments: P[Int]) extends Component[NoEmit] {

  override def render(get: Get): Element = E.div(
    if (get(noOfComments) > 2) {
      E.h1(Text("Too many Comments. Reduce those"))
    } else {
      E.h1()
    }
  )
}
