package samples

import com.github.ahnfelt.react4s._
import samples.CommentListExample.Notification.Notification
import samples.CommentListExample.commentList.CommentBox

case class MainComponent() extends Component[NoEmit] {
  override def render(get: Get): ElementOrComponent = {
    E.div(
      Component(CommentBox),
      Component(Notification)
    )
  }
}
