package samples

import com.github.ahnfelt.react4s._
import samples.CommentListExample.connector.Connector

case class MainComponent() extends Component[NoEmit] {
  override def render(get: Get): ElementOrComponent = {
    Component(Connector)
  }
}
