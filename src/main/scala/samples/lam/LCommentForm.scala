package samples.lam

import com.raquo.laminar.api.L._
import com.raquo.laminar.emitter.EventPropTransformation
import samples.r4s.CommentForm.{AddComment, CommentFormMsg}

class LCommentForm private (val node: Node, val commentEventStream: EventStream[CommentFormMsg])

object LCommentForm {
  def create(): LCommentForm = {
    val author      = Var("")
    val comment     = Var("")
    val buttonClick = new EventBus[String]

    val commentEvents      = author.signal.combineWith(comment.signal).map2(AddComment)
    val commentEventStream = buttonClick.events.sample(commentEvents)

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

    new LCommentForm(node, commentEventStream)
  }

  private def onChangeText(makeModifier: EventPropTransformation[_, String] => Mod[Input]): Mod[Input] =
    inContext(thisNode => makeModifier(onInput.mapTo(thisNode.ref.textContent)))

}
