package samples.lam

import com.raquo.laminar.api.L._
import samples.r4s.CommentForm.AddComment
import samples.r4s.{CommentModel, CommentStore}

object LCommentBox {
  def create(): Node = {
    val buttonClick  = new EventBus[Unit]
    val showComments = buttonClick.events.fold(false)((acc, _) => !acc)

    val buttonText = showComments.map {
      case true  => "Hide Comments"
      case false => "Show Comments"
    }

    val items = LCommentStore.commentModels.combineWith(showComments).map2 { (commentModels, showComments) =>
      val shownCommentModels = if (showComments) commentModels else List.empty
      shownCommentModels.map { commentModel =>
        li(LComment.create(commentModel.author, commentModel.comment))
      }
    }

    val commentForm = LCommentForm.create()

    val node = div(
      h3("Comments"),
      button(textContent <-- buttonText, onClick.preventDefault.mapTo(()) --> buttonClick.writer),
      ul(children <-- items),
      commentForm.node
    )

    val storeStream = commentForm.commentEventStream.map {
      case AddComment(author, comment) => CommentStore.AddCommentToStore(author, comment)
    }

    LCommentStore.commentBus.writer.addSource(storeStream)(node)

    node
  }
}
