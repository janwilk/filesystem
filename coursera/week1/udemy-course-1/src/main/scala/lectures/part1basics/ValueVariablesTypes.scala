package lectures.part1basics

object ValueVariablesTypes extends App {
  val x: Int = 42
  println(x)

  val aString = "hello"
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val aLong: Long = 1275768765434567890L
  val aFloat: Float = 2.0f
  val aDouble: Double = 2.9

  var aVariable: Int = 1

  aVariable = 5 // side effect
}
