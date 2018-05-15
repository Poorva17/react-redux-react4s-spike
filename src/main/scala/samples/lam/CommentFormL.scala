package samples.lam

import com.raquo.laminar.api.L._
import com.raquo.laminar.emitter.EventPropTransformation
import samples.CommentListExample.commentList.{AddComment, CommentEvent}

object CommentFormL {
  def create(): Node = {
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

    Store.commentBus.writer.addSource(commentEventStream)(node)

    node
  }

  private def onChangeText(makeModifier: EventPropTransformation[_, String] => Mod[Input]): Mod[Input] =
    inContext(thisNode => makeModifier(onInput.mapTo(thisNode.ref.textContent)))

}
