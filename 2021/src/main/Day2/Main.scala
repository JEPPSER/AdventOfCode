package main.Day2

import scala.io.Source

object Main extends App {
  val filename = "src/main/day2/input.txt"
  val values = Source.fromFile(filename).getLines.toArray
  println(moveSubmarine(0, 0, 0, values))

  def moveSubmarine(x: Int, y: Int, index: Int, values: Array[String]): Int = {
    if (index >= values.length) x * y
    else {
      val parts = values(index).split(" ")
      val steps = parts(1).toInt
      moveSubmarine(
        if (parts(0) == "forward") x + steps else x,
        if (parts(0) == "up") y - steps else if (parts(0) == "down") y + steps else y,
        index + 1,
        values
      )
    }
  }
}
