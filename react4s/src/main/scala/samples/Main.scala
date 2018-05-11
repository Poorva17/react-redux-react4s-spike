package samples

import com.github.ahnfelt.react4s._

object Main {
  def main(arguments: Array[String]): Unit = {
    val component = Component(MainComponent)
    ReactBridge.renderToDomById(component, "main")
  }
}
