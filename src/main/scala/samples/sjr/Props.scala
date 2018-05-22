package samples.sjr

import japgolly.scalajs.react.Callback

case class Comment(author: String, comment: String)
case class CommentList(list: List[Comment], show: Boolean = false)
case class CommentBoxCallBack(addComment: Comment => Callback)
case class ParentCallBack(getLength: CommentList => Callback)
