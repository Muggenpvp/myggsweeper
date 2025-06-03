package myggenpv.engine;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import myggenpv.entity.Board;
import myggenpv.ui.GameView;
import myggenpv.ui.MainMenuView;
import myggenpv.ui.StartGameMenuView;

public class SceneController {
  private static Stage stage;

  public SceneController(Stage stage) {
    SceneController.stage = stage;
  }

  public static void switchToMainMenu() {
    setScene(new MainMenuView().getScene());
  }

  public static void switchToStartGameMenu() {
    setScene(new StartGameMenuView().getScene());
  }

  public static void switchToGame(Board board) {
    setScene(new GameView().getScene(board));
  }

  public static Scene wrapScene(Parent root) {
    double width = stage.getWidth();
    double height = stage.getHeight();

    if (stage.getScene() != null) {
      Scene oldScene = stage.getScene();
      width = oldScene.getWidth();
      height = oldScene.getHeight();
    }

    return new Scene(root, width, height);
  }

  public static Stage getStage() {
    return stage;
  }

  private static void setScene(Scene scene) {
    stage.setScene(scene);
  }
}
