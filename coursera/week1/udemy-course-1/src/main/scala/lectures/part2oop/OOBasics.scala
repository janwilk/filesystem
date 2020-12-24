package lectures.part2oop

import java.time._

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person)
  person.greet("Daniel")

  val johnDoe = new Writer("John", "Doe", LocalDate.parse("1980-06-02"))
  val novel = new Novel("Age Of Empire", LocalDate.parse("2020-05-10"), johnDoe)

  println(s"full name of John is: ${johnDoe.fullName}")

  println(s"his age is ${novel.authorAge}")
  println(s"${novel.name} is written by: ${novel.isWrittenBy.fullName}")
  val aNewNovel = novel.copy(LocalDate.now)

}

class Person(val name: String, val age: Int) {
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

/*
 NOver and the Writer
  Writer(first name, surname, year)
  method - fulname

 novel: name, year of release, author
 def authorAge
 def is writtenBy(author)
 def copy(new year of relase) -> new instance of Novel

 Counter class
    - receives Int
    - method returns current count
    - method to increment and decrement the counter by one -> new counter
    - overload inc/dec to receive a parameter amount by which you increment and decrement the counter -> new Counter
 */

class Writer(val firstName: String, val surname: String, val year: LocalDate) {
  def fullName: String = s"$firstName $surname"
}

class Novel(val name: String, val yearOfRelease: LocalDate, val author: Writer) {
  def authorAge: String = {
    val age = Period.between(LocalDate.now(), author.year)
    s"${age.getYears} years ${age.getMonths} months ${age.getDays} days".replace("-", "")
  }

  def isWrittenBy: Writer = author

  def copy(newYearOfRelease: LocalDate): Novel  = {
    new Novel(this.name, newYearOfRelease, this.author)
  }
}

class Counter(val count: Int) {
  def increment: Counter = new Counter(count + 1)
  def decrement: Counter = new Counter(count - 1)
  def increment(inc: Int): Counter = {
    if (inc <= 0) this
    else increment.increment(inc - 1)
  }

  def decrement(dec: Int) = new Counter(count - dec)
}
