package lectures.part2oop

object Exceptions extends App {
  val x: String = null

  // println(x.length)
  // this will crash

  // val aWeirdValue: String = throw new NullPointerException

  // throwable classes extends the Throwable class

  // catching an exception

  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No Int for you")
    else 42
  }

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // use finally only for side effects
    println("finally")
  }

  class MyException extends Exception

  // val exception = new MyException
  // throw exception

  class OverflowException extends Exception
  class UnderflowException extends Exception
  class MathCalculationException extends Exception

  // crash with outOfMemoryError
  // val array = Array.ofDim(Int.MaxValue)

  // stack overflow
  // def infinite: Int = 1 + infinite
  // infinite


  object Calculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (result < 0 && x > 0 && y > 0) throw new OverflowException
      else if (result > 0 && x < 0 && y < 0) throw new UnderflowException
      else result
    }
    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (result < 0 && x > 0 && y > 0) throw new UnderflowException
      else if (result > 0 && x < 0 && y < 0) throw new OverflowException
      else result
    }
    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (result < 0 && x > 0 && y > 0) throw new OverflowException
      else if (result > 0 && x < 0 && y < 0) throw new UnderflowException
      else result
    }
    def divide(x: Int, y: Int): Float = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  // println(Calculator.add(Int.MaxValue, 1))

}
  /*
  // 1. crash out of memory error
  // 2/crash with stack overflow
  // 3 pocket calculator
      - add(x,y)
      - subtract(x,y)
      - multiply(x,y)
      - divide(x,y)

      throw
  */



