package myggenpv;

import myggenpv.entity.Tile;

public class Main {
  public static void main(String[] args) {
    Tile tile = new Tile(4, 5);
    System.out.println("Row: " + tile.getRow() + " Column: " + tile.getColumn());
  }
}