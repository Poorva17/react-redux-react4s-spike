package samples.sjr

import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.component.builder.Builder
import SaneImports._
import japgolly.scalajs.react.{Children, ScalaComponent}

object RNotification {

  val notification: Builder.Step4[Int, Children.None, Unit, Unit] = ScalaComponent
    .builder[Int]("notification")
    .render_P { length =>
      if (length >= 2) {
        E.div("NOTICE : -- > Comments are exceeding the required count")
      } else {
        E.div()
      }
    }

  def build(length: Int): Unmounted[Int, Unit, Unit] = notification.build.apply(length)

}
