package samples.sjr

import japgolly.scalajs.react.{BackendScope, Callback, ReactEventFromInput}
import SaneImports._
import org.scalajs.dom.html.Div

class RCommentFormBackend($ : BackendScope[CommentBoxCallBack, Comment]) {

  def callBack(e: ReactEventFromInput): Callback = {
    e.preventDefaultCB >> $.modState { (comment, callback) =>
      callback.addComment(comment).runNow()
      comment
    } >> $.modState(_.copy("", ""))
  }

  def onChangeAuthor(e: ReactEventFromInput): Callback = {
    val newValue = e.target.value
    $.modState { s =>
      s.copy(author = newValue)
    }
  }

  def onChangeComment(e: ReactEventFromInput): Callback = {
    val newValue = e.target.value
    $.modState { s =>
      s.copy(comment = newValue)
    }
  }

  def render(s: Comment): VdomTagOf[Div] =
    E.div(
      E.h3("Comment Form"),
      E.form(
        A.onSubmit ==> callBack,
        E.input(A.onChange ==> onChangeAuthor, A.value := s.author),
        E.input(A.onChange ==> onChangeComment, A.value := s.comment),
        E.button("Add comment")
      )
    )
}
