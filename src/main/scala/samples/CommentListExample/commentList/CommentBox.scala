package samples.CommentListExample.commentList

import com.github.ahnfelt.react4s._

case class CommentBox() extends Component[NotificationEvent] {

  val showCommentsS  = State(false)
  var commentModelsS = State(List.empty[CommentModel])

  override def render(get: Get): ElementOrComponent = {
    val showComments                      = get(showCommentsS)
    val commentModels: List[CommentModel] = get(commentModelsS)

    val buttonText = if (showComments) "Hide Comments" else "Show Comments"

    val commentNodes = if (showComments) {
      E.ul(Tags(commentModels.map { comment =>
        E.li(Component(Comment, comment.author, comment.comment))
      }))
    } else {
      E.ul()
    }

    E.div(
      E.h3(Text("Comments")),
      E.button(Text(buttonText), A.onClick { e =>
        e.preventDefault()
        showCommentsS.set(!showComments)
      }),
      commentNodes,
      E.div(
        Component(CommentForm).withHandler { commentEvent =>
          commentModelsS.set(CommentEvent.update(get(commentModelsS), commentEvent))
          emit(UpdateNoOfComments(get(commentModelsS).length))
        }
      )
    )
  }
}

case class CommentModel(author: String, comment: String)
