package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)
  println(2 + 3 * 4)
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 4
  println(aConditionedValue)


  var i = 0

  while (i < 10) {
    println(i)
    i += 1
  }
  // never loop like that (imperative style)
  // everything in scala is an expression




  // sideeffects: println whiles reassigning


  // Code Blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"

  }


  // difference between string and println? - return type String vs Unit()

  // 2 Boolean

  // 3 Int


}
