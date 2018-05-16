package samples.lam

import com.raquo.laminar.api.L._
import samples.CommentListExample.commentList.CommentModel

object CommentBoxL {
  def create(commentModels: Signal[List[CommentModel]], commentEventWriter: WriteBus[CommentEvent]): Node = {
    val buttonClick  = new EventBus[Unit]
    val showComments = buttonClick.events.fold(false)((acc, elm) => !acc)

    val buttonText = showComments.map {
      case true  => "Hide Comments"
      case false => "Show Comments"
    }

    val items = commentModels.combineWith(showComments).map2 { (commentModels, showComments) =>
      if (showComments) {
        commentModels.map { commentModel =>
          li(CommentL.create(commentModel.author, commentModel.comment))
        }
      } else {
        List.empty
      }
    }

    div(
      h3("Comments"),
      button(textContent <-- buttonText, onClick.preventDefault.mapTo(()) --> buttonClick.writer),
      ul(children <-- items),
      CommentFormL.create(commentEventWriter)
    )
  }
}
