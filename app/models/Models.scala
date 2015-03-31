package models

import akka.japi.Option.Some
import org.joda.time.DateTime
import play.api.libs.json._
import reactivemongo.bson._
import play.modules.reactivemongo.json.BSONFormats._

case class Post(_id: Option[BSONObjectID]=None, author: String, message: String, date: String)

object Post {
  implicit val postFormat = Json.format[Post]
  def build(author: String, message: String, date: String):Post = Post(None, author, message, new DateTime().toString())
  def unBuild(post: Post):Option[(String, String, String)] = Some(post.author, post.message, post.date)
}