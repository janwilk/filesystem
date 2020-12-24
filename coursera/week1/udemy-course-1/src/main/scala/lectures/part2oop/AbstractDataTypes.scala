package lectures.part2oop

object AbstractDataTypes extends App {

    abstract class Animal {
      val creatureType: String
      def eat: String
    }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: String = "crunch crunch"
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }


  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"

    override def eat: String = "nomnomnom"
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile

  croc.eat(dog)

  // trait vs abstract classes
}
