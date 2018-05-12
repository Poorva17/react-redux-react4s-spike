package samples.lam

import com.raquo.laminar.api.L._
import org.scalajs.dom

import samples.CommentListExample.commentList.{AddComment, CommentEvent}

class CommentFormL private (
    val node: Node,
    val commentEvent: EventStream[CommentEvent]
)

object CommentFormL {
  def apply(): CommentFormL = {
    val author      = Var("")
    val comment     = Var("")
    val buttonClick = new EventBus[dom.MouseEvent]

    val commentEventSignal = author.signal.combineWith(comment.signal).map2((a, c) => AddComment(a, c))
    val commentEventStream = buttonClick.events.sample(commentEventSignal)

    val node = div(
      h3("CommentForm"),
      form(
        input(
          inContext(thisNode => onInput.map(_ => thisNode.ref.textContent) --> author.writer),
          textContent <-- author.signal
        ),
        input(
          inContext(thisNode => onInput.map(_ => thisNode.ref.textContent) --> comment.writer),
          textContent <-- comment.signal
        ),
        button(
          "Post Comment#",
          onClick.preventDefault
          --> buttonClick
          --> author.writer.map[dom.MouseEvent](_ => "")
          --> comment.writer.map[dom.MouseEvent](_ => "")
        )
      )
    )

    new CommentFormL(node, commentEventStream)
  }
}
