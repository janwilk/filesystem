package lectures.part2oop

import java.time.LocalDate

import playground.{PrinceCharming => Prince}

object PacgagingAndImports extends App {
  val writer = new Writer("Jan", "some", LocalDate.parse("1980-02-06") )

  sayHello
  println(SPEED_OF_LIGHT)

  val prince = new Prince
}
