package com.game

case class NeighborCounter(world: World) {

  val width = world.width
  val height = world.height

  def countAliveNeighbors(celula: Celula) = {
    celula.clearNeighbors
    addCornersNeighbors(celula)
    addLeftAndRight(celula)
    addTopAndBotton(celula)
  }

  def addCornersNeighbors(celula: Celula) {
    celula.addNeighbors(countNeighborsInTheCorners(celula.ubucacion.x, celula.ubucacion.y))
  }

  def addLeftAndRight(celula: Celula) = {
    if (isThereLeftNeighbor(celula.ubucacion.x, celula.ubucacion.y))
      celula.addNeighbors(1)
    if (isThereRightNeighbor(celula.ubucacion.x, celula.ubucacion.y))
      celula.addNeighbors(1)
  }

  def addTopAndBotton(celula: Celula) = {
    if (isThereTopNeighbor(celula.ubucacion.x, celula.ubucacion.y))
      celula.addNeighbors(1)
    if (isThereBottomNeighbor(celula.ubucacion.x, celula.ubucacion.y))
      celula.addNeighbors(1)
  }

  private def countNeighborsInTheCorners(x: Int, y: Int): Int = {
    val leftTopCorner = verifyLeftTopCornerNeighbor(x, y, 0)
    val rightTopCorner = verifyRightTopCornerNeighbor(x, y, leftTopCorner)
    val rightBottomCorner = verifyRightBottomCornerNeighbor(x, y, rightTopCorner)
    verifyLeftBottomCornerNeighbor(x, y, rightBottomCorner)
  }


  private def verifyLeftTopCornerNeighbor(y: Int, x: Int, aliveNeighbors: Int): Int = {
    if (isNotFewerThanTheWorld(x) && isNotFewerThanTheWorld(y) && world(x - 1)(y - 1) != null)
      aliveNeighbors + 1
    else
      aliveNeighbors
  }

  private def isThereLeftNeighbor(y: Int, x: Int): Boolean = {
    isNotFewerThanTheWorld(x) && world(x - 1)(y) != null
  }


  private def verifyLeftBottomCornerNeighbor(y: Int, x: Int, aliveNeighbors: Int): Int = {
    if (isNotFewerThanTheWorld(x) && haveToCheckBottom(y) && world(x - 1)(y + 1) != null)
      aliveNeighbors + 1
    else
      aliveNeighbors

  }


  private def isThereBottomNeighbor(y: Int, x: Int): Boolean = {
    haveToCheckBottom(y) && world(x)(y + 1) != null
  }

  private def verifyRightBottomCornerNeighbor(y: Int, x: Int, aliveNeighbors: Int): Int = {
    if (haveToCheckRight(x) && haveToCheckBottom(y) && world(x + 1)(y + 1) != null)
      aliveNeighbors + 1
    else
      aliveNeighbors

  }

  private def isThereRightNeighbor(y: Int, x: Int): Boolean = {
    haveToCheckRight(x) && world(x + 1)(y) != null
  }


  private def verifyRightTopCornerNeighbor(y: Int, x: Int, aliveNeighbors: Int): Int = {
    if (isNotFewerThanTheWorld(y) && haveToCheckRight(x) && world(x + 1)(y - 1) != null)
      aliveNeighbors + 1
    else
      aliveNeighbors

  }

  private def isThereTopNeighbor(y: Int, x: Int): Boolean = {
    isNotFewerThanTheWorld(y) && world(x)(y - 1) != null
  }

  private def isNotFewerThanTheWorld(dot: Int): Boolean = {
    dot - 1 > -1
  }

  private def haveToCheckRight(x: Int): Boolean = {
    x + 1 < width
  }

  private def haveToCheckBottom(y: Int): Boolean = {
    y + 1 < height
  }

}
