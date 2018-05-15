package samples.CommentListExample.commentList

import com.github.ahnfelt.react4s._

case class CommentForm(increment: P[Get => Unit]) extends Component[CommentEvent] {

  val author  = State("")
  val comment = State("")

  override def render(get: Get): Element = {
    val incrementFun = get(increment)
    E.div(
      E.h3(Text("CommentForm")),
      E.form(
        E.input(A.onChangeText(author.set), A.value(get(author))),
        E.input(A.onChangeText(comment.set), A.value(get(comment))),
        E.button(Text("Post Comment#"))
      ),
      A.onSubmit { e =>
        e.preventDefault()
        incrementFun(get)
        emit(AddComment(get(author), get(comment)))
        author.set("")
        comment.set("")
      }
    )
  }

}
