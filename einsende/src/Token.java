public class Token
{
    private int farbe;
    public   static int Yellow = 1;
    public static int Red = 2;
    public static int neutral = 0;

    public Token(int farbe) {
        this.farbe = farbe;
    }

    public int getFarbe() {
        return farbe;
    }
}
