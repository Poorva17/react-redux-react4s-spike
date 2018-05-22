package samples.sjr

import SaneImports._
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.{Children, ScalaComponent}
import japgolly.scalajs.react.component.builder.Builder

object RCommentForm {
  val commentForm: Builder.Step4[CommentBoxCallBack, Children.None, Comment, RCommentFormBackend] = ScalaComponent
    .builder[CommentBoxCallBack]("comment form")
    .initialStateFromProps(p => Comment("", ""))
    .renderBackend[RCommentFormBackend]

  def build(commentBoxCallBack: CommentBoxCallBack): Unmounted[CommentBoxCallBack, Comment, RCommentFormBackend] = {
    commentForm.build.apply(commentBoxCallBack)
  }
}
