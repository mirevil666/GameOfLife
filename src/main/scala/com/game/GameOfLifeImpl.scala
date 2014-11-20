package com.game

trait GameOfLife {
  val world: World

  def playGame(): Unit
}

class GameOfLifeImpl(width: Int, height: Int) extends GameOfLife {
  val world = World(width, height)

  def playGame(): Unit = {
    world.applyRules()
  }

}
