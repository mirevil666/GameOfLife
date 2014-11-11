package com.game

import org.specs2.mutable._

class GameOfLifeTest extends Specification {

  "Alive cell in (1,1)" should {
    "die if there isn't alive neighbors" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      game.setCelula(celulaAevaluar)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beNull
    }

    "die if there is an alive neighbor in (0,0)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 0))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beNull
    }

    "die if there is an alive neighbor in (1,0)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(1, 0))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beNull
    }

    "die if there is an alive neighbor in (2,0)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(2, 0))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beNull
    }

    "die if there is an alive neighbor in (0,1)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 1))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beNull
    }

    "die if there is an alive neighbor in (2,1)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(2, 1))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beNull
    }


    "die if there is an alive neighbor in (0,2)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 2))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beNull
    }


    "die if there is an alive neighbor in (1,2)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(1, 2))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beNull
    }


    "die if there is an alive neighbor in (2,2)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(2, 2))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beNull
    }


    "live if there is an alive neighbor in (0,0) and another in (1,0)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 0))
      val neighbor2 = Celula(Ubicacion(1, 0))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.setCelula(neighbor2)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beEqualTo(celulaAevaluar)
    }

    "live if there is an alive neighbor in (1,0) and another in (2,0)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(1, 0))
      val neighbor2 = Celula(Ubicacion(2, 0))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.setCelula(neighbor2)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beEqualTo(celulaAevaluar)
    }

    "live if there is an alive neighbor in (0,1) and another in (2,1)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 1))
      val neighbor2 = Celula(Ubicacion(2, 1))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.setCelula(neighbor2)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beEqualTo(celulaAevaluar)
    }

    "live if there is an alive neighbor in (0,2) and another in (1,2)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 2))
      val neighbor2 = Celula(Ubicacion(1, 2))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.setCelula(neighbor2)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beEqualTo(celulaAevaluar)
    }

    "live if there is an alive neighbor in (1,2) and another in (2,2)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(1, 2))
      val neighbor2 = Celula(Ubicacion(2, 2))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.setCelula(neighbor2)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beEqualTo(celulaAevaluar)
    }

    "live if there is an alive neighbor in (0,0) and another in (2,2)" in {
      val game = new GameOfLife
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 0))
      val neighbor2 = Celula(Ubicacion(2, 2))
      game.setCelula(celulaAevaluar)
      game.setCelula(neighbor1)
      game.setCelula(neighbor2)
      game.applyRules
      game.getCelula(Ubicacion(1, 1)) must beEqualTo(celulaAevaluar)
    }

  }


}
