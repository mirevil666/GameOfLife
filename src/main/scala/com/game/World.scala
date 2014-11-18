package com.game

case class World(width: Int, height: Int) {

  var world = Array.ofDim[Celula](width, height)
  var worldTmp = Array.ofDim[Celula](width, height)
  val neighborCounter = NeighborCounter(this)

  def applyRules() = {
    worldTmp = world.map(_.clone())
    traverseWorld()
    world = worldTmp.map(_.clone())
  }


  private def traverseWorld() {
    for (y <- 0 until height; x <- 0 until width)
      handleCoordinate(y, x)
  }

  private def handleCoordinate(y: Int, x: Int) {
    if (isThereCelula(y, x))
      aliveCellHandler(getCelula(Ubicacion(x, y)))
    else
      deadCellHandler(Ubicacion(x, y))
  }

  private def aliveCellHandler(celula: Celula) {
    celula.numOfNeighbors = neighborCounter.countAliveNeighbors(celula.ubucacion)
    applyRulesToAliveCells(celula)
  }

  private def deadCellHandler(ubicacion: Ubicacion) = {
    val celula = Celula(ubicacion)
    celula.numOfNeighbors = neighborCounter.countAliveNeighbors(ubicacion)
    applyRulesToDeadCells(celula)
  }

  private def applyRulesToDeadCells(celula: Celula): Unit = {
    if (celula.numOfNeighbors == 3)
      worldTmp(celula.ubucacion.x)(celula.ubucacion.y) = celula
  }

  private def applyRulesToAliveCells(celula: Celula) {
    if (isUnderPopulation(celula) || isOvercrowding(celula))
      worldTmp(celula.ubucacion.x)(celula.ubucacion.y) = null
  }

  private def isOvercrowding(celula: Celula): Boolean = {
    celula.numOfNeighbors < 2
  }

  private def isUnderPopulation(celula: Celula): Boolean = {
    celula.numOfNeighbors > 3
  }

  def isThereCelula(y: Int, x: Int): Boolean = {
    world(x)(y) != null
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
