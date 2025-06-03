package myggenpv.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Spinner;
import myggenpv.engine.BoardFactory;
import myggenpv.engine.SceneController;
import myggenpv.entity.Board;

public class StartGameEventHandler implements EventHandler<ActionEvent> {
  private final Spinner<Integer> rowsSpinner;
  private final Spinner<Integer> columnsSpinner;
  private final Spinner<Integer> myggsSpinner;

  public StartGameEventHandler(Spinner<Integer> rowsSpinner, Spinner<Integer> columnsSpinner, Spinner<Integer> myggsSpinner) {
    this.rowsSpinner = rowsSpinner;
    this.columnsSpinner = columnsSpinner;
    this.myggsSpinner = myggsSpinner;
  }

  @Override
  public void handle(ActionEvent actionEvent) {

    Board board = new BoardFactory().createBoard(this.rowsSpinner.getValue(), this.columnsSpinner.getValue(), this.myggsSpinner.getValue());

    SceneController.switchToGame(board);
  }
}
