package myggenpv.ui;

import myggenpv.engine.BoardFactory;
import myggenpv.entity.Board;
import myggenpv.entity.Tile;

import java.util.Scanner;

public class MyggSweeperApp {
  private Board board;

  public void init() {
    this.board = new BoardFactory().createBoard(4, 5, 1);
  }

  public void start() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      displayBoard();
      String coordinates = scanner.nextLine();
      Tile tile =  this.board.getTiles().get(coordinates);
      tile.execute();
      if (tile.calculateNeighbouringMyggs() == 0) {
        tile.revealNeighbours();
      }
    }
  }

  public void displayBoard() {
    StringBuilder boardDisplay = new StringBuilder();

    for (int i = 0; i < this.board.getRows(); i++) {
      for (int j = 0; j < this.board.getColumns(); j++) {
        Tile tile = this.board.getTile(i, j);
        if (!tile.isRevealed()) {
          boardDisplay.append("#");
        } else if (tile.getTileType() == null) {
          boardDisplay.append(tile.calculateNeighbouringMyggs());
        } else if (tile.getTileType().getType().equals("MYGG")) {
          boardDisplay.append("M");
        }
      }
      boardDisplay.append("\n");
    }

    System.out.println(boardDisplay);
  }


}
