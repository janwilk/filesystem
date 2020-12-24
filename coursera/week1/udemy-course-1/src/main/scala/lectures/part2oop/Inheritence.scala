package lectures.part2oop

object Inheritence extends App {
  class Animal {
    val creatureType = "wild creature"
    protected def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overrriding

  class Dog extends Animal {
    override def eat = println("crunch, crunch")

    override val creatureType: String = "domestic"
  }


  val dog = new Dog
  dog.eat

  val unknownAnimal: Animal = new Dog

  // super

  // preventing overrides

  // 1 - final on member
  // 2 - final on class
  // 3 - seal the class - extend classed in this file only

}
