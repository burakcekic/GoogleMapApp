package core;


import java.io.*;
import java.util.Properties;

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

    public String getProperties(String param) throws IOException
    {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("conf.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties.getProperty(param);

    }


}
