package lectures.part1basics

object StringsOps extends App {
  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace("Hello", "Hi there"))
  println(str.toLowerCase)
  println(str.length)
  println(str.trim)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  val speed = 1.2f
  val name = "Tom"

  println(f"$name%s can eat $speed%2.2f burgers per minute ")
}
