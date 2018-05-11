package samples

import com.github.werk.router4s.Router

object Routes {

  val path = new Router[Page]

  val router = path(
    HomePage,
    path(
      "examples",
      ExamplesPage,
      path("comment-list", CommentListPage),
    )
  )

}
