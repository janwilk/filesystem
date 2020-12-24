package lectures.part3fp


import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

 val aSuccess = Success(3)
 val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  def unsafeMarthod(): String = throw new RuntimeException("nope")

  val potentialFailure = Try(unsafeMarthod())
  println(potentialFailure)

  val anotherPotentialFailure = Try {
    // code that may throw
  }

  // utilities
  println(potentialFailure.isSuccess)

  // orElse

  def backupMethod(): String = "A valid result"
  val fallBackTry = Try(unsafeMarthod()).orElse(Try(backupMethod()))

  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }
  }


  def getUrl(url: String): Option[String] = {
    val result = for {
      connection <- Try(HttpService.getConnection(hostname, port))
      endpoint <- Try(connection.get(url))
    } yield endpoint

    result match {
      case Success(res) => Some(res)
      case Failure(_) => None
    }
  }

  renderHTML(getUrl("hello").getOrElse("NO PAGE FOUND"))
}
