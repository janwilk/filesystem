package excersises

import scala.collection.SeqView.Sorted
import scala.collection.View.Zip

abstract class MyList[+A] {
  /*
      head = first element of this list
      tail = reminder
      isEmpty: Boolean
      add(int) -> new list with element added
      toString -> a string implementation of the list
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](elem: B): MyList[B]
  def printElements: String

  override def toString: String = "[" + printElements + "]"
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]
  def ++[B >:  A](filter: MyList[B]): MyList[B]

  // hofs
  def foreach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
/*
  - zipWith (list, (A, A) => B) => MyList[B]
    [1,2,3].zipWith([4,5,6], x * y) => [1*4, 2*5, 3*6] = [4,10,18]
*/
  def zipWith[B, C](list: MyList[B], zipper: (A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](elem: B): MyList[B] = new Cons(elem, Empty)

  override def printElements: String = ""
  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  // hofs
  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
  def zipWith[B, C](list: MyList[B], zipper: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("different length")
    else Empty
  }
  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](elem: B): MyList[B] = new Cons[B](elem, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  def filter(predicate: A => Boolean): MyList[A] =
    if(predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: A => B): MyList[B] =
    Cons(transformer(h), t.map(transformer))

  def ++[B >:  A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  /*
  - zipWith (list, (A, A) => B) => MyList[B]
    [1,2,3].zipWith([4,5,6], x * y) => [1*4, 2*5, 3*6] = [4,10,18]
*/
  def zipWith[B, C](list: MyList[B], zipper: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("different length")
    else new Cons(zipper(h, list.head), t.zipWith(list.tail, zipper))
  }

  /*
  [1,2,3].fold(0)(+) =
  [2,3].fold(1)(+) =
  = [3].fold(3)(+) =
  = [].fold(6)(+) = 6
   */

  def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }

}

// trait MyPredicate[-T] {
//   def test(elem: T): Boolean
// }
//
// trait MyTransformer[-A, B] {
//   def transform(elem: A): B
// }

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] =  new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("hello", new Cons(" ", Empty))
  println(listOfIntegers.toString)
  println(listOfStrings.toString)
  println(listOfIntegers.map(_ * 2))

  println(listOfIntegers.filter(elem => elem % 2 == 0).toString)

  println((listOfStrings ++ anotherListOfIntegers).toString)
  // println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
  //   override def apply(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  // }).toString)

  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))).toString)

  println(cloneListOfIntegers == listOfIntegers)

   listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x,y) => y - x))
  println(anotherListOfIntegers.zipWith[String, String](listOfStrings, _ + "-" + _))


  val result = for {
    i <- listOfIntegers
    l <- listOfStrings
  } yield "" + i +  " " + l

  println(result)

}


