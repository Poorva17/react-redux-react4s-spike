package samples.sjr

import japgolly.scalajs.react.component.Scala.Unmounted
import SaneImports._
import org.scalajs.dom.document

import scala.scalajs.js.annotation.JSExport

object RMain {

  @JSExport
  def main(args: Array[String]): Unit = {
    val mainComp: Unmounted[Unit, Int, RMainComponentBackend] = RMainComponent.build()
    E.div(mainComp).renderIntoDOM(document.getElementById("main"))
  }

}
