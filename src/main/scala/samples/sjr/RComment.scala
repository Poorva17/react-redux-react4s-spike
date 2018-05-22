package samples.sjr

import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.component.builder.Builder
import SaneImports._
import japgolly.scalajs.react.{Children, ScalaComponent}

object RComment {
  val commentComponent: Builder.Step4[Comment, Children.None, Unit, Unit] = ScalaComponent
    .builder[Comment]("Comment")
    .render_P { item =>
      E.div(
        E.li(
          E.p(s"Comment Author - ${item.author}"),
          E.p(s"Comment - ${item.comment}")
        )
      )
    }

  def build(comment: Comment): Unmounted[Comment, Unit, Unit] = commentComponent.build.apply(comment)
}
