package myggenpv.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import myggenpv.engine.SceneController;

public class StartGameMenuView {
  private Spinner<Integer> rowsSpinner;
  private Spinner<Integer> columnsSpinner;
  private Spinner<Integer> myggsSpinner;

  public Scene getScene() {

    BorderPane rootNode = new BorderPane();

    VBox centerPane = new VBox();
    centerPane.setSpacing(20);

    Label titleLabel = new Label("Myggsweeper");
    Label rowsLabel = new Label("Number of rows:");
    Label columnsLabel = new Label("Number of columns:");
    Label myggsLabel = new Label("Number of myggs:");

    this.rowsSpinner = new Spinner<>(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50));
    this.rowsSpinner.getValueFactory().setValue(5);

    this.columnsSpinner = new Spinner<>(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50));
    this.columnsSpinner.getValueFactory().setValue(5);

    this.myggsSpinner = new Spinner<>(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50));
    this.myggsSpinner.getValueFactory().setValue(8);

    Button playButton = new Button("Play");
    playButton.setOnAction(new StartGameEventHandler(this.rowsSpinner, this.columnsSpinner, this.myggsSpinner));

    playButton.setPrefWidth(150);

    centerPane.getChildren().addAll(titleLabel, rowsLabel, this.rowsSpinner, columnsLabel, this.columnsSpinner, myggsLabel, this.myggsSpinner, playButton);
    centerPane.setAlignment(Pos.CENTER);

    rootNode.setCenter(centerPane);

    return SceneController.wrapScene(rootNode);
  }
}
