package myggenpv.ui;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import myggenpv.engine.BoardFactory;
import myggenpv.engine.SceneController;
import myggenpv.entity.Board;


public class MyggSweeperApp extends Application {
  private Board board;

  public void init() {
    this.board = new BoardFactory().createBoard(4, 5, 1);
  }

  @Override
  public void start(Stage stage) throws Exception {

    // Initialize scene controller with the stage
    new SceneController(stage);

    stage.setTitle("Myggsweeper");

    // Show the main menu scene initially
    SceneController.switchToMainMenu();

    // Maximize the window by default
    stage.setMaximized(true);

    // Display the stage
    stage.show();
  }

  public static void appMain(String[] args) {
    launch();
  }


}
