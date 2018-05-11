package samples.theme

import com.github.ahnfelt.react4s._

object ColumnCss
    extends CssClass(
      S.position.absolute(),
      S.boxSizing.borderBox(),
      S.top.px(0),
      S.bottom.px(0)
    )

object MenuColumnCss
    extends CssClass(
      ColumnCss,
      S.left.px(0),
      S.width.px(200)
    )

object ContentColumnCss
    extends CssClass(
      ColumnCss,
      S.left.px(200),
      S.right.px(0)
    )

object CodeColumnCss
    extends CssClass(
      ColumnCss,
      S.left.px(0),
      S.width.percent(60),
      S.padding.px(20),
      S.fontFamily("Verdana"),
      S.fontSize.px(16),
      S.color(Palette.text),
    )

object ResultColumnCss
    extends CssClass(
      ColumnCss,
      S.right.px(0),
      S.width.percent(40),
      S.padding.px(20),
      S.fontFamily("Verdana"),
      S.fontSize.px(16),
      S.color(Palette.text),
    )

object ColumnContainerCss
    extends CssClass(
      S.position.absolute(),
      S.top.px(50),
      S.bottom.px(0),
      S.left.px(0),
      S.right.px(0),
    )

object TopBarCss
    extends CssClass(
      S.borderTop("5px solid " + Palette.accent),
      S.backgroundColor(Palette.background),
      S.boxShadow("0 2px 5px rgba(0, 0, 0, 0.3)"),
      S.boxSizing.borderBox(),
      S.position.absolute(),
      S.left.px(0),
      S.top.px(0),
      S.right.px(0),
      S.height.px(50),
    )

object BrandTextCss
    extends CssClass(
      S.display.inlineBlock(),
      S.paddingTop.px(8),
      S.fontFamily("Verdana")
    )

object BrandTitleCss
    extends CssClass(
      BrandTextCss,
      S.color(Palette.accent),
      S.paddingLeft.px(50),
      S.fontSize.px(20),
    )

object BrandTaglineCss
    extends CssClass(
      BrandTextCss,
      S.paddingLeft.px(50),
    )

object MenuCategoryCss
    extends CssClass(
      S.paddingTop.px(20),
      S.paddingLeft.px(20),
      S.textTransform("uppercase"),
      S.fontFamily("Verdana"),
      S.fontSize.px(14),
      S.color(Palette.text)
    )

object MenuEntryCss
    extends CssClass(
      S.paddingTop.px(10),
      S.paddingLeft.px(20),
      S.fontFamily("Verdana"),
      S.fontSize.px(16),
      S.color(Palette.accent),
    )

object CodeCss
    extends CssClass(
      S.backgroundColor(Palette.background),
      S.color(Palette.text),
      S.boxShadow("0 1px 2px rgba(0, 0, 0, 0.3)"),
      S.margin.px(10),
      S.padding.px(10),
      S.whiteSpace("pre"),
      S.fontFamily("monospace"),
      S.fontSize.px(14),
      S.overflowX("auto"),
    )

object CodeButtonCss
    extends CssClass(
      S.position.absolute(),
      S.top.px(-10),
      S.right.px(20),
      S.padding.px(1).px(4),
      S.color(Palette.accent),
      S.backgroundColor(Palette.background),
      S.boxShadow("0 1px 2px rgba(0, 0, 0, 0.3)"),
      S.fontSize.px(14),
      S.textTransform("uppercase"),
      S.cursor.pointer(),
    )

object SpacerCss
    extends CssClass(
      S.height.px(20)
    )
