package com.game

import org.specs2.mutable._

class GameOfLifeTest extends Specification {

  "Any live cell with fewer than two live neighbors" should {
    "die" in {
      val game = new GameOfLife
      val ubicacion = Ubicacion(0, 0)
      game.setCelula(Celula(ubicacion))
      game.nextStepTime
      game.getCelula(ubicacion) must_== (null)
    }
    "Live cell in (0,0) with two live neighbors (0,1) (1,0)" should {
      " lives" in{
        val game = new GameOfLife
        val neighbor1 = Celula(Ubicacion(0, 1))
        val neighbor2 = Celula(Ubicacion(1, 0))
        val celulaAevaluar = Celula(Ubicacion(0, 0))
        game.setCelula(celulaAevaluar)
        game.setCelula(neighbor1)
        game.setCelula(neighbor2)
        game.nextStepTime
        game.getCelula(Ubicacion(0, 0)) must beEqualTo(celulaAevaluar)
      }
    }


  }

}
