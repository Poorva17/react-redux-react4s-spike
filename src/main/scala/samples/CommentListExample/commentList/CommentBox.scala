package samples.CommentListExample.commentList

import com.github.ahnfelt.react4s._

case class CommentBox(increment: P[() => Unit]) extends Component[NoEmit] {

  val showCommentsS  = State(false)
  val commentModelsS = State(List.empty[CommentModel])

  override def render(get: Get): ElementOrComponent = {
    val showComments                      = get(showCommentsS)
    val commentModels: List[CommentModel] = get(commentModelsS)
    val incrementFun                      = get(increment)

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
        Component(CommentForm, incrementFun).withHandler { commentEvent =>
          commentModelsS.set(CommentEvent.update(commentModels, commentEvent))
        }
      )
    )
  }
}

case class CommentModel(author: String, comment: String)
