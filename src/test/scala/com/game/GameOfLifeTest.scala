package com.game

import org.specs2.mutable._

class GameOfLifeTest extends Specification {

  "Si la celula no tiene vecino" should {
    "morir" in {
      val game = GameOfLife
      val ubicacion = Ubicacion(0, 0)
      game.setCelulaPosition(ubicacion)
      game.getCelula(ubicacion) must_== (null)
    }
  }

}
