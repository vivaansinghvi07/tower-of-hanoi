public class Game {
  
  private Tower[] t;
  private int size;
  private int moves;
  
  public Game (int n) {
    t = new Tower[3];
    t[0] = new Tower(n, true, 1);
    t[1] = new Tower(n, false, 2);
    t[2] = new Tower(n, false, 3);
    size = n;
    moves = 0;
  }
  
  public void playerMove(String input) {
    int n1; int n2;
    try {
      n1 = Integer.parseInt("" + input.charAt(0));
      n2 = Integer.parseInt("" + input.charAt(2));
    }
    catch (Exception e) {
      System.out.println("Please follow the appropriate syntax rules for entering input");
      return;
    }
    if (n1 < 1 || n1 > 3 || n2 < 1 || n2 > 3) {
      System.out.println("Remember, there are only three towers! Tower numbers are 1, 2, or 3.");
      return;
    }
    else if (n1 == n2) {
      System.out.println("Tower numbers cannot match!");
      return;
    }
    int result = Tower.transfer(this.t[n1 - 1], this.t[n2 - 1]);
    if (result == 1) {
      moves++;
      return;
    }
    else if (result == -1) {
      System.out.println("The tower you are trying to transfer from does not have any blocks!");
      return;
    }
    else if (result == -2) {
      System.out.println("You cannot transfer a larger piece onto a smaller one!");
      return;
    }
  }

  public String toString() {
    Tower t1 = t[0];  int s1 = t1.size();
    Tower t2 = t[1];  int s2 = t2.size();
    Tower t3 = t[2];  int s3 = t3.size();
    String base = getChars("_", size + 1) + "|" + getChars("_", size + 1) + "  " + getChars("_", size + 1) + "|" + getChars("_", size + 1) + "  " + getChars("_", size + 1) + "|" + getChars("_", size + 1);
    String towers = new String("");
    for (int i = size + 1; i >= 0; i--) {
      String row = new String("");
      int num1 = 0;  int num2 = 0;  int num3 = 0;
      if (i < s1) {
        num1 = t1.get(i);
      }
      row = row + getChars(" ", size + 1 - num1) + getChars("o", num1) + "|" + getChars("o", num1) + getChars(" ", size + 1 - num1);
      row += "  ";
      if (i < s2) {
        num2 = t2.get(i);
      }
      row = row + getChars(" ", size + 1 - num2) + getChars("o", num2) + "|" + getChars("o", num2) + getChars(" ", size + 1 - num2);
      row += "  ";
      if (i < s3) {
        num3 = t3.get(i);
      }
      row = row + getChars(" ", size + 1 - num3) + getChars("o", num3) + "|" + getChars("o", num3) + getChars(" ", size + 1 - num3);
      row += "\n";
      towers += row;
    }
    return towers + base;
  }

  private String getChars(String chara, int times) {
    String output = new String("");
    while (times --> 0) {
      output += chara;
    }
    return output;
  }

  public boolean isOver() {
    return t[2].isOrdered();
  }

  public int getMoves() {
    return this.moves;
  }
}




