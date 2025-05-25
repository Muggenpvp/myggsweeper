package myggenpv.entity.tiletypes;

public class Mygg implements TileType {

  @Override
  public void execute() {
    System.out.println("I will suck your blood");
  }

  @Override
  public String getType() {
    return "MYGG";
  }
}
