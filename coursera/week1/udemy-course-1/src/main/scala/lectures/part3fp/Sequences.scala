package lectures.part3fp

import scala.util.Random

object Sequences extends App {


    // Seq
    val aSequence = Seq(1,2,3,4)

    println(aSequence)

    aSequence.reverse
    // aSequence(2) => 3

    // methods
  /*
  ++
  sorted
   */

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  println(aRange)
  aRange.foreach(println)

// List

  val aList = List(1,2,3)
  val prepended = 42 :: aList // or +: or prepend :+ - collon always on the side of the list
  println(prepended)

  val apples = List.fill(5)("apple")
  println(aList.mkString("-|-"))

  // Arrays
  val numbers = Array(1,2,3,4)
  val treeElements = Array.ofDim[Int](3)
  treeElements.foreach(println)
  // mutation
  numbers(2) = 0

  println(numbers.mkString(" "))

  // arrays and seq

  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  // vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vector vs list

  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }


  // keeps reference of tail
  val numbersList = (1 to maxCapacity).toList

  // depth o fthe tree is small
  // needs
  val numberVector = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList))
  println(getWriteTime(numberVector))


}
