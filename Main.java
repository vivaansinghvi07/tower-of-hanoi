import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println("Welcome to Tower of Hanoi. The objective of this game is to move all the pieces from tower 1 to tower 3, with all of them being prefectly stacked on tower 3. To move the uppermost piece from one tower to another, type the origin tower number, followed by a space, and then the recipient tower number. For example, a turn would be \"1 3\". Enjoy!");
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the size of the game you want to play: ");
    int size = scan.nextInt();  scan.nextLine();
    Game game = new Game(size);
    while(!game.isOver()) {
      System.out.println(game);
      game.playerMove(scan.nextLine());
    }
    System.out.println(game);
    System.out.println("You won!");
    int moves = game.getMoves();
    System.out.println("It took you " + moves + " moves.");
    if (moves == Math.pow(2, size) - 1) {
      System.out.println("You solved it optimally!");
    }
    else {
      System.out.println("You did not solve it optimally.");
    }
  }
}