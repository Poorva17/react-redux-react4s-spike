package samples.r4s

import com.github.ahnfelt.react4s._
import samples.r4s.CommentForm.AddComment

case class CommentBox() extends Component[NoEmit] {

  val showCommentsS = State(false)
  val commentStore  = CommentsStore(this)

  override def render(get: Get): ElementOrComponent = {
    val showComments       = get(showCommentsS)
    val shownCommentModels = if (showComments) get(commentStore) else List.empty

    val buttonText = if (showComments) "Hide Comments" else "Show Comments"

    def handleCommentFormEvents(msg: CommentForm.CommentFormMsg): Unit = msg match {
      case AddComment(author, comment) => CommentsStore.emit(CommentsStore.AddCommentToStore(author, comment))
    }

    E.div(
      E.h3(Text("Comments")),
      E.button(
        Text(buttonText),
        A.onClick { e =>
          e.preventDefault()
          showCommentsS.set(!showComments)
        }
      ),
      E.ul(
        Tags(
          shownCommentModels.map { comment =>
            E.li(Component(Comment, comment.author, comment.comment))
          }
        )
      ),
      E.div(Component(CommentForm).withHandler(handleCommentFormEvents))
    )
  }

}

case class CommentModel(author: String, comment: String)
