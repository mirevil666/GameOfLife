package com.game

class GameOfLife {

  private val xSize: Int = 3
  private val ySize: Int = 3
  var world = Array.ofDim[Celula](xSize, ySize)
  var worldTmp = Array.ofDim[Celula](xSize, ySize)
  val aliveCells = List()

  def applyRules = {
    worldTmp = world.clone()
    var f: Int = 0
    for (y <- 0 until ySize; x <- 0 until xSize) {
      if (world(x)(y) != null) {
        println("Alive cell in :" + world(x)(y))
        var aliveNeighbors = verifyLeftTopCornerNeighbor(y, x, 0)
        aliveNeighbors = verifyTopNeighbor(y, x, aliveNeighbors)
        aliveNeighbors = verifyRightTopCornerNeighbor(y, x, aliveNeighbors)
        aliveNeighbors = verifyRightNeighbor(y, x, aliveNeighbors)
        aliveNeighbors = verifyRightBottomCornerNeighbor(y, x, aliveNeighbors)
        aliveNeighbors = verifyBottomNeighbor(y, x, aliveNeighbors)
        aliveNeighbors = verifyLeftBottomCornerNeighbor(y, x, aliveNeighbors)
        aliveNeighbors = verifyLeftNeighbor(y, x, aliveNeighbors)

        if (aliveNeighbors != 2 && aliveNeighbors != 3) {
          worldTmp(x)(y) = null
        }
        println("End verifiaction: aliveNeighbors=" + aliveNeighbors)
      }
    }

    world = worldTmp.clone()
    println(world)
    println(worldTmp)
    println("**********************")
  }

  private def verifyLeftNeighbor(y: Int, x: Int, aliveNeighbors: Int): Int = {
    println("verifyLeftNeighbor"+aliveNeighbors)
    if (x - 1 > -1 && world(x - 1)(y) != null) {
      aliveNeighbors + 1
    }
    else {
      aliveNeighbors
    }
  }

  private def verifyLeftBottomCornerNeighbor(y: Int, x: Int, aliveNeighbors: Int): Int = {
    if (x - 1 > -1 && y + 1 < ySize && world(x - 1)(y + 1) != null) {
      aliveNeighbors + 1
    } else {
      aliveNeighbors
    }
  }

  private def verifyBottomNeighbor(y: Int, x: Int, aliveNeighbors: Int): Int = {
    if (y + 1 < ySize && world(x)(y + 1) != null) {
      aliveNeighbors + 1
    }
    else {
      aliveNeighbors
    }
  }

  private def verifyRightBottomCornerNeighbor(y: Int, x: Int, aliveNeighbors: Int): Int = {
    if (x + 1 < xSize && y + 1 < ySize && world(x + 1)(y + 1) != null) {
      aliveNeighbors + 1
    } else {
      aliveNeighbors
    }
  }

  private def verifyRightNeighbor(y: Int, x: Int, aliveNeighbors: Int): Int = {
    if (x + 1 < xSize && world(x + 1)(y) != null) {
      aliveNeighbors + 1
    }
    else {
      aliveNeighbors
    }
  }

  private def verifyRightTopCornerNeighbor(y: Int, x: Int, aliveNeighbors: Int): Int = {
    if (y - 1 > -1 && x + 1 < xSize && world(x + 1)(y - 1) != null) {
      aliveNeighbors + 1
    } else {
      aliveNeighbors
    }
  }

  private def verifyTopNeighbor(y: Int, x: Int, aliveNeighbors: Int): Int = {
    if (y - 1 > -1 && world(x)(y - 1) != null) {
      aliveNeighbors + 1
    } else {
      aliveNeighbors
    }
  }

  private def verifyLeftTopCornerNeighbor(y: Int, x: Int, aliveNeighbors: Int): Int = {
    if (x - 1 > -1 && y - 1 > -1 && world(x - 1)(y - 1) != null) {
      aliveNeighbors + 1
    } else {
      aliveNeighbors
    }

  }

  def setCelula(celula: Celula) = {
    world(celula.ubucacion.x)(celula.ubucacion.y) = celula
  }

  def getCelula(ubucacion: Ubicacion): Celula = {
    world(ubucacion.x)(ubucacion.y)
  }

}
