package lectures.part1Basics

object StringOps extends App {
  val str: String = "Hello dude!!, how's going"
  println(str)
  println("----")
  println(str.charAt(2))
  println(str.toUpperCase())

  println(str.split(" ").toList)
  println(str.replace(",", "-"))
}
