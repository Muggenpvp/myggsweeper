package myggenpv.engine;

import myggenpv.entity.Board;
import myggenpv.entity.Tile;

import java.util.HashMap;

public class BoardFactory {

  public Board createBoard(int columns, int rows, int myggs) {

    Board board = new Board();
    board.setTiles(createTiles(columns, rows));

    return board;
  }

  public HashMap<String, Tile> createTiles(int columns, int rows) {
    HashMap<String, Tile> tiles = new HashMap<>();
    String coordinates = "";

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        coordinates = i + "," + j;
        tiles.put(coordinates, new Tile(i, j));
      }
    }

    return tiles;
  }
}
