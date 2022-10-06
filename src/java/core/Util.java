package core;

public class Util
{
    private static Util INSTANCE;


    public static Util getINSTANCE()
    {
        if(INSTANCE == null) INSTANCE = new Util();
        return INSTANCE;
    }

    private Util() { }
    public void exceptionHandler(Exception e)
    {
        System.out.println("hata mesajı:" + e.getMessage());
        System.out.println("hata sebebi:" + e.getCause());
    }

}
