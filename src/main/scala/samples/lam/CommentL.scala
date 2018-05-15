package samples.lam

import com.raquo.laminar.api.L._

object CommentL {
  def create(author: String, comment: String): Node = {
    div(
      p(s"Comment Author - $author"),
      p(s"Comment - $comment")
    )
  }
}
