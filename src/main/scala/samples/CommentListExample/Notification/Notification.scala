package samples.CommentListExample.Notification

import com.github.ahnfelt.react4s._
import samples.CommentListExample.CommentsStore

case class Notification() extends Component[NoEmit] {
  val commentStore = CommentsStore(this)

  override def render(get: Get): Element = E.div(
    if (get(commentStore).length > 2) {
      E.h1(Text("Too many Comments. Reduce those"))
    } else {
      E.h1()
    }
  )
}
