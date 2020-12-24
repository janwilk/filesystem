package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahaha")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi myName is $name, how can I help")
  }

  val jim = new Person("") {
    override def sayHi: Unit = println("Hi myName is Jim, how can I help")
  }

  /*
  1 . generic trait MyPredicate[-T], will have a small method that T is passes the condition for each subclass test[T] => Boolean
  2. generic trade MyTransformer[-A, B], will have a method that converts value A to B (each implementation will have a different method)
  3. MyList:
    - map - takes(transformer) and returns a new list of that type
    - filter - takes predicate -> MyList
    - flatmap - takes transformer from A to MyList[B] and returns MyList[B]

    class EvenPredicate extends MyPredicate[Int] => Boolean (is even or not)
    class StringToIntTransformer extends MyTransformer[String, Int]
         def transform(A) => B

    3
    [1,2,3].map(n * 2) = [2,4,6]
    [1,2,3,4].filter(n % 2) = [2,4]
    [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]


   */



}
