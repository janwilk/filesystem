package lectures.part3fp

object FlatFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list)

  /*
  list.head                                                                 
  list.tail
  */

 list.filter(_ % 2 == 0)

  // flatmap

  val toPair = (x: Int) => List(x, x + 1)
 // println(list.flatMap(toPair))
 // println(list.map(toPair))

  // print all combination between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a', 'b', 'c', 'd')
  val colours = List("black", "white")
  // List('a1', 'a2', 'a3', ...)

//  def combine(l1: List[Char], l2: List[Int]): List[String] = {
//    l1.map(_.toString + l2.head)
//  }

    //println(combine(chars, numbers))


  val combinations = numbers.flatMap(n => chars.flatMap(c => colours.map(col => "" + c + n + col)))

  println(combinations)

  //foreach
  val forCombinations = for {
  n <- numbers if n % 2 == 0
  c <- chars
  colour <- colours
  } yield "" + c + n + "-" + colour


  println(forCombinations)

  // synatax overload

  list.map { x =>
    x * 2
  }

  /*
  1. MyList supports for comprehensions
  2. a small collection of at most ONE element - Maybe[+T]
    - map, flatMap, filter
   */












}















