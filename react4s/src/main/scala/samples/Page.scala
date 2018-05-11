package samples

sealed trait Page
case object HomePage                                              extends Page
case class ExamplesPage(parent: HomePage.type = HomePage)         extends Page
case class CommentListPage(parent: ExamplesPage = ExamplesPage()) extends Page
