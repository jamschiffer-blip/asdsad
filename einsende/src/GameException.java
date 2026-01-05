public class GameException extends Exception
{
    String Grund;

    public GameException(String Grund) {

        this.Grund = Grund;
    }
}
