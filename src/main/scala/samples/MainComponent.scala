package samples

import com.github.ahnfelt.react4s._
import samples.r4s.{CommentBox, Notification}

case class MainComponent() extends Component[NoEmit] {
  override def render(get: Get): ElementOrComponent = {
    E.div(
      Component(CommentBox),
      Component(Notification)
    )
  }
}
