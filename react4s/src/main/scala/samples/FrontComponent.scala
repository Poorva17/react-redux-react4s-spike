package samples

import com.github.ahnfelt.react4s._
import samples.theme._

case class FrontComponent() extends Component[NoEmit] {

  override def render(get: Get): Element = {
    E.div(
      E.h1(HeadingCss, Text("React4s: Component based UI"))
    )
  }

}

object HeadingCss
    extends CssClass(
      S.margin.px(0),
      S.fontSize.px(25),
      S.fontWeight("normal"),
      S.color(Palette.accent),
      Css.selector(":not(:first-child)", S.paddingTop.px(20))
    )
