package com.game

case class World(width: Int, height: Int) {

  var world = Array.ofDim[Celula](width, height)
  var worldTmp = Array.ofDim[Celula](width, height)
  val neighborCounter = NeighborCounter(this)

  def applyRules = {
    worldTmp = world.map(_.clone)
    traverseWorld
    world = worldTmp.map(_.clone)
  }

  private def traverseWorld {
    for (y <- 0 until height; x <- 0 until width)
      if (world(x)(y) != null)
        aliveCellHandler(y, x)
  }

  private def aliveCellHandler(y: Int, x: Int) {
    val celula: Celula = world(x)(y)
    neighborCounter.countAliveNeighbors(celula)
    if (celula.numOfNeighbors != 2 && celula.numOfNeighbors != 3)
      worldTmp(x)(y) = null

  }

  def setCelula(celula: Celula) = {
    world(celula.ubucacion.x)(celula.ubucacion.y) = celula
  }

  def getCelula(ubucacion: Ubicacion): Celula = {
    world(ubucacion.x)(ubucacion.y)
  }

  def apply(x: Int)(y: Int): Celula = {
    world(x)(y)
  }

}
