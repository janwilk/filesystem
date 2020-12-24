package lectures.part3fp

object WhatsAFunction extends App {
  // dream: use functions as first class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(n: Int): Int = n * 2
  }
  println(doubler(2))

  // function types = Function1[A, B]

  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 5)

  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // ALL SCALA FUNCTIONS ARE OBJECTS
  /*
    1. a function that takes two strings and concatenate them
    2. myList transform MyPredicate and MyTransformer into function types
    3. define a function that takes an argument Int and returns another function that takes an Int and returns and Int
       - whats the type of t his functions
       - how to do it


   */
  val concat = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  println(concat("Hello", " this "))

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

//  val fun1 = new Function[Int, Int => Int] {
//    override def apply(v1: Int): Int => Int = v1
//  }

  // Function1[Int, Function1[int, int]]
  val supperAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }



  val adder3 = supperAdder(3)
  println(adder3(4))
  println(supperAdder(3)(4)) // curried function


  def myAdder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(x: Int, y: Int): Int = x + y
  }

  def multiplayer: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(x: Int, y: Int): Int = x * y
  }

}

trait MyFunction[A, B] {
  def apply(n: A): B
}

// class Action {
//   def execute(n: Int): String = ???
// }

//trait Action[A, B] {
//  def execute(n: A): B = ???
//}

trait MyFunctionExample[A, B] {
  def appply(element: A): B
}
object Test {
  val doublerExample = new MyFunctionExample[Int, Int] {
    override def appply(element: Int): Int = element * 2
  }

  val sytringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }
}
