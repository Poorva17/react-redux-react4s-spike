package samples.lam

import com.raquo.laminar.api.L._
import samples.CommentListExample.commentList.{CommentEvent, CommentModel, NotificationEvent, UpdateNoOfComments}

class CommentBoxL private (
    val node: Node,
    val notificationEvent: Signal[NotificationEvent]
)

object CommentBoxL {
  def create(): CommentBoxL = {
    val buttonClick  = new EventBus[Unit]
    val showComments = buttonClick.events.fold(false)((acc, elm) => !acc)

    val commentForm   = CommentFormL.create()
    val commentModels = commentForm.commentEvent.fold(List.empty[CommentModel])(CommentEvent.update)

    val buttonText = showComments.map {
      case true  => "Hide Comments"
      case false => "Show Comments"
    }

    val items = commentModels.combineWith(showComments).map2 { (commentModels, showComments) =>
      if (showComments) {
        commentModels.map { commentModel =>
          li(CommentL.create(Val(commentModel.author), Val(commentModel.comment)))
        }
      } else {
        List.empty
      }
    }

    val node = div(
      h3("Comments"),
      button(textContent <-- buttonText, onClick.preventDefault.mapTo(()) --> buttonClick.writer),
      ul(children <-- items),
      commentForm.node
    )

    val commentUpdates = commentModels.map(x => UpdateNoOfComments(x.length))
    new CommentBoxL(node, commentUpdates)
  }
}
