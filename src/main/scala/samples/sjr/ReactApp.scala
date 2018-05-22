package samples.sjr

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.document

import scala.scalajs.js.annotation.JSExport

object ReactApp {

  @JSExport
  def main(args: Array[String]): Unit = {

    val parentComponent = ScalaComponent
      .builder[Unit]("parent comp")
      .initialStateFromProps(p => 0)
      .renderBackend[ParentBackend]
      .build

    <.div(
      parentComponent()
    ).renderIntoDOM(document.getElementById("main"))
  }

}
