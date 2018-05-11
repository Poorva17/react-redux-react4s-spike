package samples.CommentListExample.commentList

import com.github.ahnfelt.react4s._

case class Comment(author: P[String], comment: P[String]) extends Component[NoEmit] {

  override def render(get: Get): ElementOrComponent = {
    E.div(
      E.p(Text("Comment Author - " + get(author))),
      E.p(Text("Comment -" + get(comment)))
    )
  }
}
