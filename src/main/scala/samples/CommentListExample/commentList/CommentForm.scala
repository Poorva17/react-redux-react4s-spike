package samples.CommentListExample.commentList

import com.github.ahnfelt.react4s._
import samples.CommentListExample.commentList.CommentForm.AddComment

case class CommentForm() extends Component[CommentForm.Msg] {

  val author  = State("")
  val comment = State("")

  override def render(get: Get): Element = {
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

}

object CommentForm {
  sealed trait Msg
  case class AddComment(author: String, comment: String) extends Msg
}
