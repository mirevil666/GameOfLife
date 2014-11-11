package com.game

class GameOfLife {

  val world = Array.ofDim[Celula](3, 3)
  val aliveCells = List()

  def applyRules = {

    var aliveNeighbor: Int = 0;
    if (world(0)(0) != null) {
      aliveNeighbor += 1
    }

    if (world(1)(0) != null) {
      aliveNeighbor += 1
    }

    if (world(2)(0) != null) {
      aliveNeighbor += 1
    }

    if (world(0)(1) != null) {
      aliveNeighbor += 1
    }

    if (world(2)(1) != null) {
      aliveNeighbor += 1
    }

    if (world(0)(2) != null) {
      aliveNeighbor += 1
    }

    if (world(1)(2) != null) {
      aliveNeighbor += 1
    }

    if (world(2)(2) != null) {
      aliveNeighbor += 1
    }

    if (aliveNeighbor < 2) {
      world(1)(1) = null
    }

  }

  def setCelula(celula: Celula) = {
    world(celula.ubucacion.x)(celula.ubucacion.y) = celula
  }

  def getCelula(ubucacion: Ubicacion): Celula = {
    world(ubucacion.x)(ubucacion.y)
  }

}
