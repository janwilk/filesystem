package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n < 1) 1
    else {
      println("computing factotial of  " + n + " - first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }
  }

  println(factorial(10))

  def anbotherFactorial(n: Int): Int = {
    def loop(x: Int, acct: Int): Int = {
      if (x <= 1) acct
      else loop(x - 1, x * acct)
    }

    loop(n, 1)
  }

  // Concatenate a String n times
  def nTimes(myString: String, n: Int): String = {
    @tailrec
    def loop(str: String, iter: Int): String = {
      if (iter == n) str
      else loop(myString + str, iter + 1)
    }

    loop(myString, 1)
  }

  println(nTimes("hello", 7))
  // isPrime function tail recursive

  def isPrime(n: Int): Boolean = {
    def loop(x: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (x <= 1) true
      else (loop(x - 1, n % x != 0))
    }

    loop(n / 2, true)
  }

  // Fibonacci function tail recursive
  def fibonacci(n: Int): Int = {
    @tailrec
    def loop(n1: Int, n2: Int, iter: Int): Int = {
      if (iter == n) n1
      else loop(n2, n1 + n2, iter + 1)
    }

    loop(1, 1, 1)
  }


}
