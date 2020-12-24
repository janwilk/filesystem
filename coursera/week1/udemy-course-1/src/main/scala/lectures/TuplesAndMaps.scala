package lectures

object TuplesAndMaps extends App {
  // tuples

  val aTuple = new Tuple2(2, "hello there") // Tuple2[Int, String] = (Int, String)
  val anotherTuple = (2, "hello there")

  println(aTuple._1)

  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap)

  // Maps

  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), ("Other", 999), "yetAnotherExample" -> 123).withDefaultValue(-1)
  println(phonebook)

  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))
  println(phonebook("Mary"))

  // add a pairing

  val newPairing = "Marry" -> 675
  val newPhonebook = phonebook + newPairing

  // map
  println(phonebook.map(pair => pair._1.toLowerCase() -> pair._2))

  //filters/

  println(phonebook.view.filterKeys(x => x.startsWith("J")))

  println(phonebook.view.mapValues(number => number * 10))

  val names = List("Bob", "James", "Angela", "Daniel", "Jim")
  println(names.groupBy(x => x.charAt(0)))


  /*
  1. error raised as a key has to be uniq in Map
  2. Overly simplified
    Person = String
      - add a person
      - remove a person
      - friend (mutual)
      - unfriend
      - number of friends of a person
      - person with most friends
      - how many people have no friends
      - if there is a social connection between two people (direct or not)
   */



  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if(friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Marry")
  println(network)

  println(friend(network, "Bob", "Marry"))
  println(unfriend(friend(network, "Bob", "Marry"), "Bob", "Marry"))


  // Jim, Bob, Marry

  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Jim", "Bob")
  val testNet = friend(people, "Mary", "Bob")

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else (network(person).size)

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  def leastFriends(network: Map[String, Set[String]]): String =
    network.minBy(pair => pair._2.size)._1

//  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
//    network.view.filterKeys(k => k.isEmpty).size

 //def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
 //  network.view.filter(pair => pair._2.isEmpty).size

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.view.count(_._2.isEmpty)

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if(discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if(consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }
    bfs(b, Set(), network(a) + a)
  }
  println(testNet)
  println(socialConnection(testNet, "Mary", "Bob"))
}
