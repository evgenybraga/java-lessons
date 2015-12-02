import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;
/**
 * Created by ibraga on 30/11/2015.
 */
public class TestFridge
{
    public static void main(String[] args)
    {
        final char op = (char)8212;  //"—"
        final char cl = (char)124; //"|"
        char[][] fr = {{op, cl, op},
                       {op, cl, op},
                       {cl, cl, cl}};

        Scanner in = new Scanner(System.in);
        int row = 0;
        int col = 0;
        int cnt = 0;
        FridgeGame game = new FridgeGame(3);
        //FridgeGame game = new FridgeGame(fr);
        System.out.println("Base state");
        game.printFridgeState();
/*
        while (row != -1 || col != -1)
        {
            System.out.print("row = ");
            row = in.nextInt();
            System.out.print("col = ");
            col = in.nextInt();
            if (row != -1 && col != -1)
            {
                game.doSwitch(row, col);
                game.printFridgeState();
            }
        }
        */


        while (cnt < 2 && game.isStateExists(game.getLockedState()))
        {
            game.switchLatchesWithState(game.getLockedState(), true);
            //game.printFridgeState();
            cnt++;
        }

    }

}
