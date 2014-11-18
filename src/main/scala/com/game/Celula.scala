package com.game


case class Celula(ubucacion: Ubicacion) {

  var numOfNeighbors: Int = _

  def addNeighbors(numOfNeighborsAdded: Int) = {
    numOfNeighbors += numOfNeighborsAdded
  }

  def clearNeighbors = {
    numOfNeighbors = 0
  }
}
