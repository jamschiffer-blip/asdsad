public abstract class Game
{
    protected Player[] feld;
    protected Gameboard g;

    public Game(String Spieler1, String Spieler2)
    {
        g = new Gameboard();
        feld[0].getName();
        feld[1].getName();
    }
    abstract void play();
    abstract void printBoard() throws GameException;
    abstract void printWinner(Player p);
}
