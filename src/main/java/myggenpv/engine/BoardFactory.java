package myggenpv.engine;

import myggenpv.entity.Board;
import myggenpv.entity.Tile;
import myggenpv.entity.tiletypes.Mygg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class BoardFactory {

  public Board createBoard(int rows, int columns, int myggs) {

    Board board = new Board();
    board.setTiles(createTiles(rows, columns));
    setNeighbouringTiles(board);
    generateMyggs(rows, columns, myggs, board);

    return board;
  }

  public HashMap<String, Tile> createTiles(int rows, int columns) {
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

  public void generateMygg(int row, int column, Board board) {
    board.getTile(row, column).setTileType(new Mygg());
  }

  public void generateMyggs(int rows, int columns, int totalAmount, Board board) {
    Random random = new Random();
    int amountGenerated = 0;

    int row;
    int column;
    while (amountGenerated < totalAmount) {
      row = random.nextInt(rows);
      column = random.nextInt(columns);

      if (board.getTile(row, column).getTileType() == null) {
        generateMygg(row, column, board);
        amountGenerated++;
      }
    }
  }

  public void setNeighbouringTiles(Board board) {
    for (Tile tile : board.getTiles().values()) {
      ArrayList<Tile> neighbouringTiles = new ArrayList<>();

      Tile topLeft = board.getTile(tile.getRow()+1, tile.getColumn()-1);
      Tile topCenter = board.getTile(tile.getRow()+1, tile.getColumn());
      Tile topRight = board.getTile(tile.getRow()+1, tile.getColumn()+1);
      Tile left = board.getTile(tile.getRow(), tile.getColumn()-1);
      Tile right = board.getTile(tile.getRow(), tile.getColumn()+1);
      Tile bottomLeft = board.getTile(tile.getRow()-1, tile.getColumn()-1);
      Tile bottomCenter = board.getTile(tile.getRow()-1, tile.getColumn());
      Tile bottomRight = board.getTile(tile.getRow()-1, tile.getColumn()+1);

      if (topLeft != null) {
        neighbouringTiles.add(topLeft);
      }
      if (topCenter != null) {
        neighbouringTiles.add(topCenter);
      }
      if (topRight != null) {
        neighbouringTiles.add(topRight);
      }
      if (left != null) {
        neighbouringTiles.add(left);
      }
      if (right != null) {
        neighbouringTiles.add(right);
      }
      if (bottomLeft != null) {
        neighbouringTiles.add(bottomLeft);
      }
      if (bottomCenter != null) {
        neighbouringTiles.add(bottomCenter);
      }
      if (bottomRight != null) {
        neighbouringTiles.add(bottomRight);
      }

      tile.setNeighbouringTiles(neighbouringTiles);
    }
  }
}
