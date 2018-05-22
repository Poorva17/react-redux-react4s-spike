package samples.sjr

import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.component.ScalaFn.Component
import SaneImports._
import japgolly.scalajs.react.{BackendScope, Callback, CtorType, ScalaFnComponent}
import org.scalajs.dom.html.Div

class RCommentBoxBackend($ : BackendScope[ParentCallBack, CommentList]) {

  private val listing: Component[List[Comment], CtorType.Props] = ScalaFnComponent[List[Comment]] { props =>
    E.ul(props.map(item => RComment.build(item).apply()): _*)
  }

  def addComment(comment: Comment): Callback = {
    $.modState { (s, callback) =>
      callback.getLength(s).runNow()
      s.copy(s.list :+ comment)
    }
  }

  val commentFormComp: Unmounted[CommentBoxCallBack, Comment, RCommentFormBackend] =
    RCommentForm.build(CommentBoxCallBack(comment => addComment(comment)))

  def render(s: CommentList): VdomTagOf[Div] =
    E.div(
      if (s.show) {
        E.div(
          E.button("Hide", A.onClick --> $.modState(_.copy(show = false))),
          E.div(s"comments: ", listing(s.list))
        )
      } else {
        E.button("Show", A.onClick --> $.modState(_.copy(show = true)))
      },
      commentFormComp
    )
}
