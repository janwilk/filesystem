import zio._
import zio.console._

val goShopping = ZIO.effect(println("going to the grocery store"))

val goShoppingEffect = println("going to the shop now!!!")

val test = putStrLn("testing this")

goShopping.exitCode
test.exitCode