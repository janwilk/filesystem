package lectures.part2oop

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int = 20) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name} "
    def +(str: String): Person = new Person(s"${this.name} ($str)", this.favoriteMovie)
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)
    def unary_! : String = s"$name what the hack"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int): String = s"${this.name} watched ${this.favoriteMovie} $n times"
    def learns(subject: String): String = s"${this.name} learns $subject"
    def learnsScala: String = this learns "Scala"
  }

  val marry = new Person("Marry", "Inception")
  println(marry.likes("Inception"))

  println(marry likes "Inception") // infix notation (for methods with one parameter) - syntactic sugar example

  // "operators"
  val tom = new Person("Tom", "some movie")

  println(marry + tom)

  // prefix notation
  val x = -1
  val y = 1.unary_-

  println(!marry)
  // unary_ prefix works only with

  //postfix
  println(marry.isAlive)
//  println(marry isAlive)


  // apply

  println(marry.apply())
  println(marry())

  /*
   1. overload the + operator
      marry + "the rockstar" => new person "Marry (the rocklstar)"
   2. Add an age to the Person class
      Add a unary + operator => new Person with the age + 1
      +marry => marry with the age incremented
   3. add a "learns" method in the Person class => "Marry learns Scala"
      add a learnsScala method, calls learns method with "Scala" - use it in a postfix notation
   4. Overload the apply method
   marry.apply(2) => "Marry watched Inception 2 times"
   */

  println((marry + "the rockstar").name)

  val olderMarry = +marry
  println(olderMarry.age)

  println(marry.learns("Maths"))
  println(marry.learnsScala)
  println(marry(2))

}
