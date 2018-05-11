package samples

import com.github.ahnfelt.react4s._
import samples.theme._
import org.scalajs.dom

case class MainComponent() extends Component[NoEmit] {

  def href(page: Page) =
    if (dom.window.location.href.contains("?"))
      "#" + Routes.router.path(page)
    else
      Routes.router.path(page)

  def path() =
    if (dom.window.location.href.contains("?"))
      dom.window.location.hash.drop(1)
    else
      dom.window.location.pathname

  val page = State(Routes.router.data(path()))

  if (dom.window.location.href.contains("?")) {
    dom.window.onhashchange = { _ =>
      page.set(Routes.router.data(path()))
    }
  }

  override def render(get: Get): Element = {
    E.div(
      E.div(
        TopBarCss,
        E.a(Text("React4s"), A.href("/"), BrandTitleCss, LinkCss),
        E.span(Text("The uncomplicated React binding for Scala"), BrandTaglineCss),
      ),
      E.div(
        ColumnContainerCss,
        E.div(
          MenuColumnCss,
          E.div(
            E.div(MenuEntryCss, E.a(Text("Overview"), LinkCss, A.href(href(HomePage)))),
          ),
          E.div(
            E.div(Text("Examples"), MenuCategoryCss),
            E.div(MenuEntryCss, E.a(Text("Comment list"), LinkCss, A.href(href(CommentListPage())))),
          ),
        ),
        get(page)
          .map(Component(PageComponent, _))
          .getOrElse(E.div(ContentColumnCss, Text("Not found")))
      ),
      E.a(
        S.fontFamily("Verdana"),
        S.fontSize.px(16),
        LinkCss,
        A.href("https://github.com/ahnfelt/react4s"),
        S.position("absolute"),
        S.top.px(15),
        S.right.px(10),
        Text("Fork me on"),
        E.img(
          S.border.px(0),
          S.height.px(20),
          S.marginLeft.px(10),
          A.src("https://assets-cdn.github.com/images/modules/logos_page/GitHub-Logo.png"),
          A.alt("Fork me on GitHub"),
        )
      ),
    )
  }
}
