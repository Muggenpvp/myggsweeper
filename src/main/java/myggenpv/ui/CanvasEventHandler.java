package myggenpv.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CanvasEventHandler implements EventHandler<MouseEvent> {
  private GameView gameView;
  private BoardController boardController;

  public CanvasEventHandler(GameView gameView, BoardController boardController) {
    this.gameView = gameView;
    this.boardController = boardController;
  }

  @Override
  public void handle(MouseEvent mouseEvent) {
    int row = boardController.getRowFromYCoordinate(mouseEvent.getY());
    int column = boardController.getColumnFromXCoordinate(mouseEvent.getX());

    this.boardController.getBoard().getTile(row, column).execute();
    this.boardController.drawBoard(boardController.getBoard());
  }
}
