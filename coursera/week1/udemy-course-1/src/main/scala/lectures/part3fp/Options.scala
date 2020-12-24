package lectures.part3fp

import scala.util.Random

object Options extends App {

  val config: Map[String, String] = Map(
    "host" -> "176.45.34.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())
    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  val host = config.get("host")
  val port = config.get("port")
  val connection: Option[Connection] = (host, port) match {
    case (Some(h), Some(p)) => Connection(h, p)
    case _ => None
  }

  val result = connection match {
    case Some(con) => con.connect
    case None => "Not connected"
  }

  println(result)

val conn = for {
  host <- config.get("host")
  port <- config.get("port")
  connection <- Connection(host, port)
} yield connection

  println(conn.map(_.connect))





}
