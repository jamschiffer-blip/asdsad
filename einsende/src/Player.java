public class Player
{
    private String Name;
    private Token token;

    public Player(String Name, Token token) {
        this.Name = Name;
        this.token = token;
    }

    public String getName() {
        return Name;
    }

    public Token getToken() {
        return token;
    }
}
