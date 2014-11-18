package com.game

import org.specs2.mutable._

class GameOfLifeTest extends Specification {

  "An alive cell in (1,1)" should {
    "die if there isn't alive neighbors" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      game.world.setCelula(celulaAevaluar)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beNull
    }

    "die if there is an alive neighbor in (0,0)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 0))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beNull
    }

    "die if there is an alive neighbor in (1,0)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(1, 0))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beNull
    }

    "die if there is an alive neighbor in (2,0)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(2, 0))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beNull
    }

    "die if there is an alive neighbor in (0,1)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 1))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beNull
    }

    "die if there is an alive neighbor in (2,1)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(2, 1))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beNull
    }


    "die if there is an alive neighbor in (0,2)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 2))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beNull
    }


    "die if there is an alive neighbor in (1,2)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(1, 2))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beNull
    }


    "die if there is an alive neighbor in (2,2)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(2, 2))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beNull
    }


    "live if there is an alive neighbor in (0,0) and another in (1,0)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 0))
      val neighbor2 = Celula(Ubicacion(1, 0))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.world.setCelula(neighbor2)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beEqualTo(celulaAevaluar)
    }

    "live if there is an alive neighbor in (1,0) and another in (2,0)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(1, 0))
      val neighbor2 = Celula(Ubicacion(2, 0))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.world.setCelula(neighbor2)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beEqualTo(celulaAevaluar)
    }

    "live if there is an alive neighbor in (0,1) and another in (2,1)" in {
      println("live if there is an alive neighbor in (0,1) and another in (2,1)")
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 1))
      val neighbor2 = Celula(Ubicacion(2, 1))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.world.setCelula(neighbor2)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beEqualTo(celulaAevaluar)
    }

    "live if there is an alive neighbor in (0,2) and another in (1,2)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 2))
      val neighbor2 = Celula(Ubicacion(1, 2))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.world.setCelula(neighbor2)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beEqualTo(celulaAevaluar)
    }

    "live if there is an alive neighbor in (1,2) and another in (2,2)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(1, 2))
      val neighbor2 = Celula(Ubicacion(2, 2))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.world.setCelula(neighbor2)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beEqualTo(celulaAevaluar)
    }

    "live if there is an alive neighbor in (0,0) and another in (2,2)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 0))
      val neighbor2 = Celula(Ubicacion(2, 2))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.world.setCelula(neighbor2)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beEqualTo(celulaAevaluar)
    }

    "live if there is three alive neighbors: (0,0), (2,2) and (0,2)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 0))
      val neighbor2 = Celula(Ubicacion(2, 2))
      val neighbor3 = Celula(Ubicacion(0, 2))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.world.setCelula(neighbor2)
      game.world.setCelula(neighbor3)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beEqualTo(celulaAevaluar)
    }

    "die if there is more than three alive neighbors: (0,0), (2,2) , (0,2), (0,1)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(1, 1))
      val neighbor1 = Celula(Ubicacion(0, 0))
      val neighbor2 = Celula(Ubicacion(2, 2))
      val neighbor3 = Celula(Ubicacion(0, 2))
      val neighbor4 = Celula(Ubicacion(0, 1))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.world.setCelula(neighbor2)
      game.world.setCelula(neighbor3)
      game.world.setCelula(neighbor4)
      game.playGame
      game.world.getCelula(Ubicacion(1, 1)) must beNull
    }

  }

  "An alive cell in (0,0)" should {
    "live if there are two neighbors: (0,1),(1,0)" in {
      val game = new GameOfLife(3,3)
      val celulaAevaluar = Celula(Ubicacion(0, 0))
      val neighbor1 = Celula(Ubicacion(0, 1))
      val neighbor2 = Celula(Ubicacion(1, 0))
      game.world.setCelula(celulaAevaluar)
      game.world.setCelula(neighbor1)
      game.world.setCelula(neighbor2)
      game.playGame
      game.world.getCelula(Ubicacion(0, 0)) must beEqualTo(celulaAevaluar)
    }
  }


}
