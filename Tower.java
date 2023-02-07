import java.util.*;

public class Tower {
  private ArrayList<Integer> blocks;  private int number;  private int size;
  public Tower (int n, boolean start, int id) {
    blocks = new ArrayList<Integer>();
    size = n;
    if (start) {
      for (int i = 1; i <= n; i++) {
        blocks.add(i);
      }
    }
    number = id;
  }
  public static int transfer(Tower origin, Tower recipient) {
    if (origin.blocks.size() == 0) {
      return -1; //error code for origin tower not having any
    }
    int transferNum = origin.blocks.get(0);
    if (recipient.blocks.size() == 0) {
      recipient.blocks.add(transferNum);
      origin.blocks.remove(0);
      return 1; // 1 represents a successful transfer of blocks
    }
    else if (transferNum < recipient.blocks.get(0)) {
      recipient.blocks.add(0, transferNum);
      origin.blocks.remove(0);
      return 1;
    }
    else {
      return -2; // error code for the transfer top being bigger than the origin top
    }
  }
  public int size() {
    return this.blocks.size();
  }
  public int get(int i) {
    return blocks.get(blocks.size() - 1 - i);
  }
  public boolean isOrdered() {
    for (int i = 0; i < this.blocks.size(); i++) {
      if (this.blocks.get(i) != i + 1) {
        return false;
      }
    }
    if (blocks.size() == this.size) {
      return true;
    }
    return false;
  }
}