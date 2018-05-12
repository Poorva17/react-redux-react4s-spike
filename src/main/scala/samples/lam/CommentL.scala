package samples.lam

import com.raquo.laminar.api.L._

class CommentL private (
    val node: Node
)

object CommentL {
  def apply(author: Signal[String], comment: Signal[String]): CommentL = {
    val node = div(
      p(textContent <-- author.map(a => s"Comment Author - $a")),
      p(textContent <-- comment.map(c => s"Comment Author - $c"))
    )

    new CommentL(node)
  }
}
