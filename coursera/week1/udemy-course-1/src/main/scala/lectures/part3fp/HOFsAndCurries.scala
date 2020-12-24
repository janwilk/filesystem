package lectures.part3fp

object HOFsAndCurries extends App {
  // val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???

  // function that applies a function n times over a vaue x
  // nTimes(f, n, x)

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n -1, f(x))

  val plusOne = (x: Int) => x + 1

  val anotherPlusOne: (Int) => Int = (x: Int) => x + 1

  println(nTimes(plusOne, 10, 1))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }

  val plus10 = nTimesBetter(plusOne, 10)

  println(plus10(1))

  // curries
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))
  println(superAdder(3)(10))
  println(superAdder(2)(2))
  /*
  1 expand MyList
    - foreach method (A => Unit) - apply to every element of MyList§
      [1,2,3].foreach(x => println(x)) - this will print each element

    - sort function ((A, A) => Int) => MyList - negative if the first element is less then the second
      [1, 2, 3].sort((x, y) => y - x) => [3,2,1]

    - zipWith (list, (A, A) => B) => MyList[B]
      [1,2,3].zipWith([4,5,6], x * y) => [1*4, 2*5, 3*6] = [4,10,18]

    - fold method (a curried function)
      fold(start)(function) => a value
      [1,2,3].fold(0)(x+y)=6

  2. toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
     fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int

  3. compose(f,g) => x => f(g(x))  - two functions and composes them - function composition
     andThen(f,g) => x => g(f(x))
   */

    def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
      x => y => f(x, y)

    def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
      (x, y) => f(x)(y)

    // FunctionX
    def compose[A, B, T](f: A => B, g: T => A): T => B =
      x => f(g(x))

    def andThen(f: Int => Int, g: Int => Int): Int => Int =
      x => g(f(x))

    def supperadder2: (Int => Int => Int) = toCurry(_ + _)
    def add4 = supperadder2(4)
    println(add4(17))

    val simpleAdder = fromCurry(supperadder2)
    println(simpleAdder(4,17))

    val add2 = (x: Int) => x + 2
    val times3 = (x: Int) => x * 3



}
