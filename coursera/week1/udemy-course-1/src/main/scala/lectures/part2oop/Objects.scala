package lectures.part2oop

object Objects {
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  println(Person.N_EYES)

  class Person(val name: String) {
    def main(args: Array[String]): Unit = {
      val marry = new Person("Marry")
      val john = new Person("John")
      val bobbie = Person(marry, john)
    }
  }
}
