package myggenpv.entity;

import myggenpv.entity.tiletypes.TileType;

import java.util.ArrayList;

public class Tile {
  private int column;
  private int row;
  private ArrayList<Tile> neighbouringTiles;
  private TileType tileType;
  private boolean isRevealed = false;

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

  public boolean isRevealed() {
    return this.isRevealed;
  }

  public void setRevealed(boolean state) {
    this.isRevealed = state;
  }

  public int calculateNeighbouringMyggs() {
    int myggs = 0;

    for (Tile neigbouringTile : this.neighbouringTiles) {
      if (neigbouringTile.getTileType() != null && neigbouringTile.getTileType().getType().equals("MYGG")) {
        myggs += 1;
      }
    }

    return myggs;
  }

  public void revealNeighbours() {
    for (Tile neighbouringTile : this.neighbouringTiles) {
      if (!neighbouringTile.isRevealed()) {
        neighbouringTile.setRevealed(true);
        if (neighbouringTile.calculateNeighbouringMyggs() == 0) {
          neighbouringTile.revealNeighbours();
        }
      }
    }
  }

  public void execute() {
    setRevealed(true);
    if (this.tileType != null) {
      this.tileType.execute();
    }
  }
}
