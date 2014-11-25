package com.game

import javafx.animation.{Animation, KeyFrame, Timeline}
import javafx.application.Application
import javafx.event.{ActionEvent, EventHandler}
import javafx.scene.Scene
import javafx.scene.layout.{HBox, VBox}
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.stage.Stage
import javafx.util.Duration

object WindowGameOfLife {

  def main(args: Array[String]) = Application.launch(classOf[WindowGameOfLifeLauncher], args: _*)


}

class WindowGameOfLifeLauncher extends Application {


  private val squareSize: Double = 40

  override def start(stage: Stage): Unit = {
    val width = getParameters.getNamed.get("width").toInt
    val height = getParameters.getNamed.get("height").toInt
    stage.setTitle("GameOfLife")
    val vBox = new VBox

    val rectArray = Array.ofDim[Rectangle](width, height)

    for (x <- 0 until width) {
      val hBox = new HBox
      for (y <- 0 until height) {
        val rect = new Rectangle(squareSize, squareSize);
        rect.setFill(Color.WHITE)
        hBox.getChildren.add(rect)
        rectArray(x)(y) = rect
      }
      vBox.getChildren.add(hBox)
    }



    val scene = new Scene(vBox, width * squareSize, height * squareSize);
    stage.setScene(scene)
    stage.show()
    animateGame(width, height, rectArray)
  }

  def animateGame(width: Int, height: Int, rectArray: Array[Array[Rectangle]]) {
    val fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler[ActionEvent]() {
      val gameOfLife = new GameOfLifeImpl(width, height)
      gameOfLife.world.setCelula(Celula(Ubicacion(0, 0)))
      gameOfLife.world.setCelula(Celula(Ubicacion(0, 1)))
      gameOfLife.world.setCelula(Celula(Ubicacion(1, 1)))

      def handle(event: ActionEvent): Unit = {
        gameOfLife.playGame()
        for (x <- 0 until width; y <- 0 until height) {
          if (!gameOfLife.world.isThereCelula(x, y)) {
            rectArray(x)(y).setFill(Color.WHITE)
          }
          else
            rectArray(x)(y).setFill(Color.BLACK)
        }

      }
    }))
    fiveSecondsWonder.setCycleCount(Animation.INDEFINITE)
    fiveSecondsWonder.play()
  }
}
