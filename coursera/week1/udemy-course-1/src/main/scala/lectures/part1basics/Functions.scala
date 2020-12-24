package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 5))

  def aParameterLessFunction(): Int = 6

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 4))
  // use recursion for loops

  def aFunctionWithSideEffect(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }


  // a greeting functions. (name, age) => "Hi, my name is $name and I am $ age year old"
  // factorial functions 1 * 2 * 3 * n
  // fibonacci function 1, 1, 2, 3, 5, 8, 13  f(n) = f(n - 1) + f(n-2)
  // test if a number is prime

  def greeting(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old"
  }

  println(greeting("Jon", 5))

  def factorial(n: Int): Int = {
    @tailrec
    def loop(x: Int, accum: Int): Int = {
      if (x <= 1) accum
      else loop(x - 1, accum * x)
    }

    loop(n, 1)
  }

  println(factorial(20)) // => 24

  // fib(5) =>
  // f(n-1) + f(n-2)
  def fibonacci(n: Int): Int = {
    def loop(n1: Int, n2: Int, iter: Int): Int = {
      if (iter == n) n1
      else loop(n2, n1 + n2, iter + 1)
    }

    loop(1, 1, 1)
  }

  // println(fibonacci(7)) // => 8


}
