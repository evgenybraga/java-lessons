import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by ibraga on 30/11/2015.
 */
public class TestFridge
{
    public static void main(String[] args)
    {
        final char op = (char)8212;  //"—"
        final char cl = (char)124; //"|"
        char[][] fr = {{cl, op, cl}, {op, op, op}, {op, op, op}};

        //FridgeGame game = new FridgeGame(fr);
        FridgeGame game = new FridgeGame(2);
        System.out.println("Base state");
        game.printFridgeState();
        System.out.println("------------------------");
        System.out.println(game.isLockedExists());
        for (int i = 0; i < 10000; i++)
        {
            if (game.isLockedExists())
            {
                game.switchLocked(true);
            }
            else
            {
                System.out.println(i);
                break;
            }
        }



        game.printFridgeState();
        /*
        while (game.isLockedExists())
        {
            game.switchLocked();
        }
        */


    }

}
