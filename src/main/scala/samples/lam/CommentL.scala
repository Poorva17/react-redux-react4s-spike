package samples.lam

import com.raquo.laminar.api.L._

object CommentL {
  def create(author: Signal[String], comment: Signal[String]): Node = {
    div(
      p("Comment Author - ", child.text <-- author),
      p("Comment - ", child.text <-- comment)
    )
  }
}
