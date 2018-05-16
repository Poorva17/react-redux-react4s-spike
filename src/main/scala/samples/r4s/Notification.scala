package samples.r4s

import com.github.ahnfelt.react4s._

case class Notification() extends Component[NoEmit] {
  val commentStore = CommentStore(this)

  override def render(get: Get): Element = E.div(
    if (get(commentStore).length > 2) {
      E.h1(Text("Too many Comments. Reduce those"))
    } else {
      E.h1()
    }
  )
}
