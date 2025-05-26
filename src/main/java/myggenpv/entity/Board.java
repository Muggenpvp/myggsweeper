package myggenpv.entity;

import java.util.HashMap;

public class Board {
  private HashMap<String, Tile> tiles;

  public Board() {

  }

  public void setTiles(HashMap<String, Tile> tiles) {
    this.tiles = tiles;
  }

  public HashMap<String, Tile> getTiles() {
    return this.tiles;
  }

  public Tile getTile(int row, int column) {
    return this.tiles.get(row + "," + column);
  }

  public int getColumns() {
    int highestColumn = 0;

    for (Tile tile : tiles.values()) {
      if (tile.getColumn() > highestColumn) {
        highestColumn = tile.getColumn();
      }
    }

    return highestColumn + 1;
  }

  public int getRows() {
    int highestRow = 0;

    for (Tile tile : tiles.values()) {
      if (tile.getRow() > highestRow) {
        highestRow = tile.getRow();
      }
    }

    return highestRow + 1;
  }
}
