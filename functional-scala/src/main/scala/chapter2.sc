// tail recursive Fibonacci

//0, 1, 1, 2, 3, 5, 8, 13

object Math {
  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  def fib(n: Int): Int = {
    if (n <= 1) return 0
    def go(iter: Int, previousN: Int, currentN: Int): Int = {
      if (iter >= n) currentN
      else go(iter+1, currentN, previousN + currentN)
    }
    go(2, 0, 1)
  }

  def factorial(n: Int): Int = {
    def go(n: Int, acct: Int): Int =
      if (n <= 0) acct
      else go(n-1, n*acct)
    go(n, 1)
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def main(args: Array[String]): Unit =
    println(formatAbs(-42))
}

Math.abs(-6)
Math.factorial(4)