package samples.sjr

import japgolly.scalajs.react.vdom.{HtmlAttrAndStyles, HtmlTags, PackageBase}

object SaneImports extends PackageBase {
  val E: HtmlTags.type          = HtmlTags
  val A: HtmlAttrAndStyles.type = HtmlAttrAndStyles
}
