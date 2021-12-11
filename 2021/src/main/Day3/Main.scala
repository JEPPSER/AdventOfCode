package main.Day3

import scala.io.Source

object Main extends App {
  val filename = "src/main/day3/input.txt"
  val values = Source.fromFile(filename).getLines.toArray

  val gamma = gammaRate("", values, 12)
  val epsilon = gamma.map((c: Char) => if (c == '0') '1' else '0')

  val power = Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
  println(power)

  def gammaRate(value: String, values: Array[String], width: Int): String = {
    if (width < 1) value
    else gammaRate(mostCommon(width - 1, values) + value, values, width - 1)
  }

  def mostCommon(position: Int, values: Array[String]): String = {
    val bits = values.map((s: String) => s(position))
    if (bits.count(_ == '1') > bits.count(_ == '0')) "1"
    else "0"
  }
}
