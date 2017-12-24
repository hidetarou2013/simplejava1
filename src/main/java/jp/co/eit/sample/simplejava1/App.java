package jp.co.eit.sample.simplejava1;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Controller1 controller = new Controller1();
        controller.method01(new PreData());
    }

}
