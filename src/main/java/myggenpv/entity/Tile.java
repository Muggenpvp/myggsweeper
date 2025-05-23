package myggenpv.entity;

import myggenpv.entity.tiletypes.TileType;

import java.util.ArrayList;

public class Tile {
  private int column;
  private int row;
  private ArrayList<Tile> neighbouringTiles;
  private TileType tileType;

  public Tile(int row, int column) {
    setRow(row);
    setColumn(column);
  }

  public void setRow(int row) {
    if (row < 0) {
      throw new IllegalArgumentException("row can not be a negative number");
    }
    this.row = row;
  }

  public int getRow() {
    return this.row;
  }

  public void setColumn(int column) {
    if (column < 0) {
      throw new IllegalArgumentException("column can not be a negative number");
    }
    this.column = column;
  }

  public int getColumn() {
    return this.column;
  }

  public void setTileType(TileType tileType) {
    this.tileType = tileType;
  }

  public TileType getTileType() {
    return this.tileType;
  }

  public void setNeighbouringTiles(ArrayList<Tile> tiles) {
    this.neighbouringTiles = tiles;
  }

  public ArrayList<Tile> getNeighbouringTiles() {
    return this.neighbouringTiles;
  }
}
