package com.game

class GameOfLife {

  val world = Array.ofDim[Celula](3, 3)

  def nextStepTime = {
    println(world(1)(0))
    println(world(0)(1))
    if (world(0)(1) == null || world(1)(0) == null) {
      println("entro al if")
      world(0)(0) = null
    }

  }

  def setCelula(celula: Celula) = {
    world(celula.ubucacion.x)(celula.ubucacion.y) = celula
  }

  def getCelula(ubucacion: Ubicacion): Celula = {
    world(ubucacion.x)(ubucacion.y)
  }

}
