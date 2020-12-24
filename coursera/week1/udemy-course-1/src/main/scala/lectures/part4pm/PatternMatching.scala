package lectures.part4pm

object PatternMatching extends App  {
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def calculate(expr: Expr) : Int = {
    expr match {
      case Number(a) => a
      case Sum(a, b) => calculate(a) + calculate(b)
      case Sum(Sum(a,b), c) => calculate(a) + calculate(b) + calculate(c)
      case Prod(Sum(a,b), c) => (calculate(a) + calculate(b)) * calculate(c)
      case Sum(Prod(a,b), c) =>  calculate(a) * calculate(b) + calculate(c)
    }
  }

  println(calculate(Sum(Number(3), Number(4)))) // 7
  println(calculate(Sum(Sum(Number(7), Number(1)), Number(2)))) // 10
  println(calculate(Prod(Sum(Number(5), Number(5)), Number(2)))) // 20
  println(calculate(Sum(Prod(Number(4), Number(5)), Number(5)))) // 25
}
