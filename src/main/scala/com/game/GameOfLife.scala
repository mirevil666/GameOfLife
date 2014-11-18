package com.game

class GameOfLife(width: Int, height: Int) {
  val world = World(width, height)

  def playGame(): Unit = {
    world.applyRules
  }

  private def printWorld(): Unit = {
    for (y <- 0 until height) {
      for (x <- 0 until width)
        print(world(x)(y))
      println()
    }
  }
}
