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
}
