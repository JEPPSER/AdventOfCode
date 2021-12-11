package main.Day1

import scala.io.Source

object Main extends App {
  val filename = "src/main/day1/input.txt"
  val values = Source.fromFile(filename).getLines.toArray.map((s: String) => s.toInt)
  println(checkIncrease(1, 0, values))

  def checkIncrease(index: Int, count: Int, values: Array[Int]): Int = {
    if (index >= values.length) count
    else checkIncrease(index + 1, if (values(index) > values(index - 1)) count + 1 else count, values)
  }
}
