package samples.lam

import com.raquo.laminar.api.L._

object LComment {
  def create(author: String, comment: String): Node = {
    div(
      p(s"Comment Author - $author"),
      p(s"Comment - $comment")
    )
  }
}
