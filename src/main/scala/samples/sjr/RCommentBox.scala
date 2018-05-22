package samples.sjr

import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.component.builder.Builder
import SaneImports._
import japgolly.scalajs.react.{Children, ScalaComponent}

object RCommentBox {
  val comment: Builder.Step4[ParentCallBack, Children.None, CommentList, RCommentBoxBackend] = ScalaComponent
    .builder[ParentCallBack]("Comment Box")
    .initialState(CommentList(List.empty[Comment]))
    .renderBackend[RCommentBoxBackend]

  def build(parentCallBack: ParentCallBack): Unmounted[ParentCallBack, CommentList, RCommentBoxBackend] = {
    comment.build.apply(parentCallBack)
  }
}
