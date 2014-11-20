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
    val hBox = new HBox


    val rect = new Rectangle(squareSize, squareSize);
    rect.setFill(Color.RED);
    hBox.getChildren.add(rect)


    val scene = new Scene(hBox, width * squareSize, height * squareSize);
    stage.setScene(scene)
    stage.show()
    val fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler[ActionEvent]() {
      var b: Int = 1

      def handle(event: ActionEvent) {
        rect.setFill(Color.rgb(50, 50, b))
        b += 10
      }
    }))
    fiveSecondsWonder.setCycleCount(Animation.INDEFINITE)
    fiveSecondsWonder.play()
  }
}
