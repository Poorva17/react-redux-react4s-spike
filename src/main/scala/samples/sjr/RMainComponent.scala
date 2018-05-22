package samples.sjr

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.component.builder.Builder
import SaneImports._

object RMainComponent {
  val mainComponent: Builder.Step4[Unit, Children.None, Int, RMainComponentBackend] =
    ScalaComponent
      .builder[Unit]("parent comp")
      .initialStateFromProps(p => 0)
      .renderBackend[RMainComponentBackend]

  def build(): Unmounted[Unit, Int, RMainComponentBackend] = mainComponent.build.apply()

}
