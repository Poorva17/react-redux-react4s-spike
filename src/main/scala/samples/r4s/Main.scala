package samples.r4s

import com.github.ahnfelt.react4s._

object Main {
  def main2(arguments: Array[String]): Unit = {
    val component = Component(MainComponent)
    ReactBridge.renderToDomById(component, "main")
  }
}
