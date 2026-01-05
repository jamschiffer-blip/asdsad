import java.util.*;
import java.util.InputMismatchException ;

public class ConsoleGame extends Game
{

    Scanner sc = new Scanner(System.in) ;

    Player p1;
    Player p2;
    Token tp1 = new Token(1);
    Token tp2 = new Token(2);
    Gameboard g;
    private Token[][] token;

    public ConsoleGame(String Spieler1, String Spieler2) {
        super(Spieler1, Spieler2);
        Player p1 = new Player(Spieler1, tp1);
        Player p2 = new Player (Spieler2, tp2);

    }
    public void play()
    {
        while(this.g.finished()==false)          //hier noch die catches
        {
            try {
                System.out.println("Dein Zug Spieler1, welche Spalte wählst du: "); // unsicher richtige reihenfolge
                int zug1 = sc.nextInt();
                g.drop(zug1, p1);
                printBoard();
                if (g.finished() == true) {
                    printWinner(p1);
                    break;
                }
            }
            catch(ArrayIndexOutOfBoundsException a) {
                System.out.println("Ungültiger Zug");
                sc.nextLine();

            }
            catch(InputMismatchException | GameException e) {
                System.out.println("❌ Ungültige Eingabe! Bitte eine ganze Zahl eingeben.");
                sc.nextLine();
            }
            try {
                System.out.println("Dein Zug Spieler2 , welche Spalte wählst du: ");
                int zug2 = sc.nextInt();

                g.drop(zug2, p2);
                printBoard();
                if (g.finished() == true) {
                    printWinner(p2);
                    break;
                }
            }
            catch(ArrayIndexOutOfBoundsException aa) {
                System.out.println("Ungültiger Zug");
                sc.nextLine();

            }
            catch(InputMismatchException | GameException ee) {
                System.out.println("❌ Ungültige Eingabe! Bitte eine ganze Zahl eingeben.");
                sc.nextLine();
            }

        }
        printWinner(null);
    }
    public void printBoard() throws GameException
    {
        for(int i = 5; i>=0;i--)
        {
            for(int j = 0; i<=6;j++)
            {
                if(token[i][j]== null) System.out.print("  ");
                if(token[i][j].getFarbe()==1) System.out.print("x ");
                if(token[i][j].getFarbe()==2) System.out.print("o ");
            }
            System.out.println();
        }
    }
    public void printWinner(Player p)
    {   if(p != null)
        System.out.println("Der Gewinner ist: " + p.getName());
        else System.out.println("Unentschieden!");
    }
}
