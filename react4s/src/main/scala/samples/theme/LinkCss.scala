package samples.theme

import com.github.ahnfelt.react4s._

object LinkCss
    extends CssClass(
      S.color(Palette.accent),
      S.textDecoration.none(),
      S.cursor.pointer(),
      Css.hover(
        S.textDecoration("underline")
      )
    )
