package myggenpv;

import myggenpv.engine.BoardFactory;
import myggenpv.entity.Tile;
import myggenpv.entity.Board;
import myggenpv.ui.MyggSweeperApp;

public class Main {
  public static void main(String[] args) {
    MyggSweeperApp myggSweeperApp = new MyggSweeperApp();

    myggSweeperApp.init();
    myggSweeperApp.start();
  }
}