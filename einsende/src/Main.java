import java.util.*;
void main() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Name Spieler1: ");
    String S1 = scanner.next();
    System.out.println("Name Spieler2: ");
    String S2 = scanner.next();
    ConsoleGame c = new ConsoleGame(S1,S2);
    c.play();
}
