import java.util.*;

public class Gameboard {
    Scanner sc = new Scanner(System.in);
    int eingabe = sc.nextInt();
    String g = "ungültiger Zug";
    GameException e = new GameException(g);
    Token neutral = new Token(0);
    public Token[][] token;
    public static int rows = 6;
    public static int columns = 7;

    public Gameboard() {
        //Spielfeld erzeugen
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                token[i][j] = neutral;
            }
        }


    }

    public Token getToken(int Zeilenindex, int Spaltenindex) throws GameException {
        if (Zeilenindex > 5 || Spaltenindex > 6) throw e;
        else return token[Zeilenindex][Spaltenindex];
    }

    public void drop(int Spalte, Player p) throws GameException {


        if (Spalte >= 1 && Spalte <= columns) {
            Spalte = Spalte - 1;
            for (int i = 0; i <= 5; i++) {
                if (token[i][Spalte] == neutral) {
                    token[i][Spalte] = p.getToken();
                    break;
                }
                if (token[5][Spalte] != neutral) throw e;
            }
        }
        if (Spalte < 1 && Spalte > columns) throw e;
    }

    public boolean finished() {
        int tmp = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j < 7; j++) {
                if (token[i][0] == token[i][j] && token[i][j] != null ) tmp++;
            }
            if (tmp >= 4) {
                return true;
            }
        }
        int tmp2 = 1;
        for (int l = 0; l < 7; l++) {
            for (int j = 1; j < 6; j++) {
                if (token[0][l] == token[j][l] && token[j][l] != null ) tmp++;
            }
            if (tmp2 >= 4) {
                return true;

            }
        }


        int tmp3 = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 4; j++) {
                for (int r = 1; r <= 3; r++) {
                    if (token[i][j] == token[i + r][j + r] && token[i + r][j + r]!=null ) tmp3++;
                }
            }
            if (tmp3 == 4) {
                return true;
            }


        }
        for (int i = 6; i >= 3; i--) {
            for (int j = 4; j <= 7; j++) {
                for (int r = 1; r <= 3; r++) {
                    if (token[i][j] == token[i + r][j + r] && token[i + r][j + r]!=null ) tmp3++;
                }
            }
            if (tmp3 == 4) {
                return true;
            }


        }
        int tmp5 = 0;
        for (int i = 0; i <= 6; i++) {
            if (token[5][i] != null) tmp5++;
        }
        if (tmp5 == 6) return true;

        return false;

    }
}