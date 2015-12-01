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
        char[][] fr = {{cl, cl, cl}, {cl, cl, cl}, {cl, cl, cl}};

        //FridgeGame game = new FridgeGame(fr);
        FridgeGame game = new FridgeGame(4);
        System.out.println("Base state");
        game.printFridgeState();
        System.out.println("------------------------");
        System.out.println(game.isLockedExists());
        int cnt = 0;
        while (game.isLockedExists() || cnt >= 1000000)
        {
            game.switchLocked(true);
            cnt++;
        }


        game.printFridgeState();System.out.println(cnt);
        /*
        while (game.isLockedExists())
        {
            game.switchLocked();
        }
        */


    }

}
