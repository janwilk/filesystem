package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  val jim = new Person("Jim", 34)

  println(jim.name)

  println(jim)

  // equals and hashCode

  val jim2= new Person("Jim", 34)
  println(jim == jim2)

  // 4 copy method

  val jim3 = jim.copy(age = 45)
  // 5. case classes have companion object

  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. case classes are serializable
  // Akka

  // 7. case classes have extractor patterns - can be used in pattern matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }



}
