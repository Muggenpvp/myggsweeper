package myggenpv;

import myggenpv.engine.BoardFactory;
import myggenpv.entity.Tile;
import myggenpv.entity.Board;

public class Main {
  public static void main(String[] args) {
    Board board = new BoardFactory().createBoard(4, 4, 0);
  }
}