package samples.CommentListExample.commentList

import com.github.ahnfelt.react4s._

case class CommentForm() extends Component[CommentEvent] {

  val author  = State("")
  val comment = State("")

  override def render(get: Get): Element =
    E.div(
      E.h3(Text("CommentForm")),
      E.form(
        E.input(A.onChangeText(author.set), A.value(get(author))),
        E.input(A.onChangeText(comment.set), A.value(get(comment))),
        E.button(Text("Post Comment#"))
      ),
      A.onSubmit { e =>
        e.preventDefault()
        emit(AddComment(get(author), get(comment)))
        author.set("")
        comment.set("")
      }
    )

}
