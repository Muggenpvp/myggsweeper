package myggenpv.entity;

import java.util.ArrayList;

public class Tile {
  private int column;
  private int row;
  private ArrayList<Tile> neighbouringTiles;

  public Tile(int column, int row) {
    this.column = column;
    this.row = row;
  }

  public int getColumn() {
    return this.column;
  }

  public int getRow() {
    return this.row;
  }
}
