package samples.lam

import com.raquo.laminar.api.L._
import samples.r4s.CommentModel

object CommentBoxL {
  def create(commentModels: Signal[List[CommentModel]], commentEventWriter: WriteBus[CommentEvent]): Node = {
    val buttonClick  = new EventBus[Unit]
    val showComments = buttonClick.events.fold(false)((acc, elm) => !acc)

    val buttonText = showComments.map {
      case true  => "Hide Comments"
      case false => "Show Comments"
    }

    val items = commentModels.combineWith(showComments).map2 { (commentModels, showComments) =>
      val shownCommentModels = if (showComments) commentModels else List.empty
      shownCommentModels.map { commentModel =>
        li(CommentL.create(commentModel.author, commentModel.comment))
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
