package utils;

public class LoadAnimation {
    static byte anime;
    public static void animate(int i)
    {
        try
        {
            for(int j = 0 ; j<=100 ; j++)
            {
                switch(anime)
                {
                    case 1:
                        System.out.print("\r[ \\ ] :" + j + "%" + " ...Loading library");
                        break;
                    case 2:
                        System.out.print("\r[ | ] :" + j + "%" + " ...Loading library");
                        break;
                    case 3:
                        System.out.print("\r[ / ] :" + j + "%" + " ...Loading library");
                        break;
                    default:
                        anime = 0;
                        System.out.print("\r[ - ] :" + j + "%" + " ...Loading library");
                }
                anime++;
                Thread.sleep(i);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
