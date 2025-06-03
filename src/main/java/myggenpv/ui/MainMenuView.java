package myggenpv.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import myggenpv.engine.SceneController;

public class MainMenuView {

  public Scene getScene() {

    BorderPane rootNode = new BorderPane();

    VBox centerPane = new VBox();
    centerPane.setSpacing(20);

    Label titleLabel = new Label("Myggsweeper");

    Button startGameButton = new Button("Start Game");
    startGameButton.setOnAction(e -> {
      SceneController.switchToStartGameMenu();
    });

    startGameButton.setPrefWidth(150);

    centerPane.getChildren().addAll(titleLabel, startGameButton);
    centerPane.setAlignment(Pos.CENTER);

    rootNode.setCenter(centerPane);

    return SceneController.wrapScene(rootNode);
  }
}
