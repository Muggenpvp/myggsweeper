package myggenpv.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import myggenpv.entity.Board;
import myggenpv.entity.Tile;

public class BoardController {
  private GameView gameView;
  private Board board;
  private double tileWidth;
  private double tileHeight;

  public BoardController(GameView gameView, Board board) {
    this.gameView = gameView;
    this.board = board;
  }

  public void drawBoard(Board board) {
    this.tileHeight = calculateTileDimensions(this.gameView.getCanvas().getWidth(), this.gameView.getCanvas().getHeight(), this.board.getColumns(), this.board.getRows());
    this.tileWidth = calculateTileDimensions(this.gameView.getCanvas().getWidth(), this.gameView.getCanvas().getHeight(), this.board.getColumns(), this.board.getRows());
    for (Tile tile : board.getTiles().values()) {
      double xCoordinate = getXCoordinateFromColumn(tile.getColumn());
      double yCoordinate = getYCoordinateFromRow(tile.getRow());
      this.gameView.drawTile(xCoordinate, yCoordinate, this.tileWidth, this.tileHeight, tile);
    }
  }

  public double getXCoordinateFromColumn(int column) {
    return  column * this.tileWidth;
  }

  public double getYCoordinateFromRow(int row) {
    return this.gameView.getCanvas().getHeight() - ((row + 1) * this.tileHeight);
  }

  public int getColumnFromXCoordinate(double xCoordinate) {
    return (int) Math.floor(xCoordinate / this.tileWidth);
  }

  public int getRowFromYCoordinate(double yCoordinate) {
    return (int) Math.floor((this.gameView.getCanvas().getHeight() - yCoordinate) / this.tileHeight);
  }

  public double calculateTileDimensions(double canvasWidth, double canvasHeight, int columns, int rows) {
    // Calculate tile width and height based on canvas size and board dimensions
    tileWidth = canvasWidth / columns;
    tileHeight = canvasHeight / rows;

    // Adjust tile width and height to maintain square tiles
    if (this.tileWidth < this.tileHeight) {
      tileHeight = this.tileWidth;
    } else {
      tileWidth = this.tileHeight;
    }

    return tileHeight;
  }

  public Board getBoard() {
    return this.board;
  }
}
