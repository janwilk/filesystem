package lectures.part3fp

object AnanymousFunctions extends App {

  // LAMBDA (anonymous function)
  val doubler: Int => Int = x => x * 2

  // multiple params

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params

  val justDoIt: () => Int = () => 3

  println(justDoIt) // function itself
  println(justDoIt()) // call

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _

  /*
    1 MyList - replace all functionX calls with lambdas
    2. rewrite the "special" adder as an anonymous function
   */
  val superAdd = (x: Int) => (y: Int) => x + y


}
