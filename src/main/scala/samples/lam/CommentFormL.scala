package samples.lam

import com.raquo.laminar.api.L._
import com.raquo.laminar.emitter.EventPropTransformation
import org.scalajs.dom
import org.scalajs.dom.MouseEvent
import samples.CommentListExample.commentList.{AddComment, CommentEvent}

class CommentFormL private (
    val node: Node,
    val commentEvent: EventStream[CommentEvent]
)

object CommentFormL {
  def create(): CommentFormL = {
    val author      = Var("")
    val comment     = Var("")
    val buttonClick = new EventBus[String]

    val commentEventSignal = author.signal.combineWith(comment.signal).map2(AddComment)
    val commentEventStream = buttonClick.events.sample(commentEventSignal)

    val node = div(
      h3("CommentForm"),
      form(
        input(onChangeText(_ --> author.writer), textContent <-- author.signal),
        input(onChangeText(_ --> comment.writer), textContent <-- comment.signal),
        button(
          "Post Comment#",
          onClick.preventDefault.mapTo("")
          --> buttonClick
          --> author.writer
          --> comment.writer
        )
      )
    )

    new CommentFormL(node, commentEventStream)
  }

  private def onChangeText(makeModifier: EventPropTransformation[_, String] => Mod[Input]): Mod[Input] =
    inContext(thisNode => makeModifier(onInput.mapTo(thisNode.ref.textContent)))

}
