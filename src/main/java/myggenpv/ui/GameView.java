package myggenpv.ui;

import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import myggenpv.engine.SceneController;
import myggenpv.entity.Board;
import myggenpv.entity.Tile;

import java.util.HashMap;

public class GameView {
  private BoardController boardController;
  private Canvas canvas;
  private GraphicsContext graphicsContext;

  public Scene getScene(Board board) {
    this.boardController = new BoardController(this, board);

    BorderPane rootNode = new BorderPane();

    this.canvas = new Canvas(500, 500);
    this.graphicsContext = canvas.getGraphicsContext2D();

    this.canvas.setOnMouseClicked(new CanvasEventHandler(this, this.boardController));

    boardController.drawBoard(board);

    rootNode.setCenter(this.canvas);

    return SceneController.wrapScene(rootNode);
  }

  public void drawTile(double xCoordinate, double yCoordinate, double tileWidth, double tileHeight, Tile tile) {
    Color strokeColor = null;
    Color fillColor = Color.LIGHTGRAY;
    String tileType = "";

    if (tile.isRevealed()) {
      fillColor = Color.WHITE;

      if (tile.getTileType() != null) {
        tileType = tile.getTileType().getType();
      }

      this.graphicsContext.setFill(fillColor);
      this.graphicsContext.fillRect(xCoordinate, yCoordinate, tileWidth, tileHeight);

      fillColor = Color.BLACK;
      this.graphicsContext.setFill(fillColor);
      switch (tileType.toUpperCase()) {
        case "MYGG":
          this.graphicsContext.setTextBaseline(VPos.CENTER);
          this.graphicsContext.setFont(new Font(tileHeight/2));
          this.graphicsContext.fillText("M", xCoordinate+tileWidth/4, yCoordinate+tileHeight/2);
          break;
        default:
          this.graphicsContext.setTextBaseline(VPos.CENTER);
          this.graphicsContext.setFont(new Font(tileHeight/2));
          this.graphicsContext.fillText(String.valueOf(tile.getNeighbouringMyggs()), xCoordinate+tileWidth/4, yCoordinate+tileHeight/2);
          break;
      }

    } else {

      this.graphicsContext.setFill(fillColor);
      this.graphicsContext.fillRect(xCoordinate, yCoordinate, tileWidth, tileHeight);
    }
    this.graphicsContext.strokeRect(xCoordinate, yCoordinate, tileWidth, tileHeight);
  }

  public Canvas getCanvas() {
    return this.canvas;
  }
}
