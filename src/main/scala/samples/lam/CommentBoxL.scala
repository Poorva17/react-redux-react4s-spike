package samples.lam

import com.raquo.laminar.api.L._

object CommentBoxL {
  def create(): Node = {
    val buttonClick  = new EventBus[Unit]
    val showComments = buttonClick.events.fold(false)((acc, elm) => !acc)

    val buttonText = showComments.map {
      case true  => "Hide Comments"
      case false => "Show Comments"
    }

    val items = Store.commentModels.combineWith(showComments).map2 { (commentModels, showComments) =>
      if (showComments) {
        commentModels.map { commentModel =>
          li(CommentL.create(Val(commentModel.author), Val(commentModel.comment)))
        }
      } else {
        List.empty
      }
    }

    div(
      h3("Comments"),
      button(textContent <-- buttonText, onClick.preventDefault.mapTo(()) --> buttonClick.writer),
      ul(children <-- items),
      CommentFormL.create()
    )
  }
}
