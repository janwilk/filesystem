package lectures.part2oop

object Generics extends App {
  class MyList[+A] {
    // use the type A inside the class def
  def add[B >: A](element: B): MyList[B] = ???

  }

  class MyMap[Key, Value]


  val listOfIntegers = new MyList[Int]
  //generic methods

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // list of Cat extends List[Animal]
  class CoveriantList[+A]
  val animal: Animal = new Cat
  val animalList: CoveriantList[Animal] = new CoveriantList[Cat]

  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded type

  class Cage[A <: Animal](animal: A)

  val cage = new Cage[Dog](new Dog)

  class Car

  // val newCage = new Cage(new Car) can't do


}
