package samples.sjr

import japgolly.scalajs.react.{BackendScope, Callback, ReactEventFromInput}
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.html.Div

class CommentFormBackend($ : BackendScope[CommentBoxCallBack, Comment]) {

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
    <.div(
      <.h3("Comment Form"),
      <.form(
        ^.onSubmit ==> callBack,
        <.input(^.onChange ==> onChangeAuthor, ^.value := s.author),
        <.input(^.onChange ==> onChangeComment, ^.value := s.comment),
        <.button("Add comment")
      )
    )
}
