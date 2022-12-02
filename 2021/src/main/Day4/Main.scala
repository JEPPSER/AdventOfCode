package main.Day4

import scala.io.Source

object Main extends App {
  val filename = "src/main/day4/input.txt"
  val lines = Source.fromFile(filename).getLines.toArray
  val values = lines(0).split(",").map((s: String) => s.toInt)

  val board = readBoard(2, lines)

  def readBoard(index: Int, lines: Array[String]): Array[Array[Int]] = {
    val board = Array.ofDim[Int](5, 5)
    for (i <- 0 to 4) {
      board(i) = readRow(index + i, lines)
    }
    board
  }

  def readRow(index: Int, lines: Array[String]): Array[Int] = {
    val row = lines(index).split(" ").filter((s: String) => s != "").map((s: String) => s.toInt)
    row
  }
}
