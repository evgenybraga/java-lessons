import java.util.Scanner;

/**
 * Created by ibraga on 30/11/2015.
 */
public class TestFridge {
    public static void main(String[] args) {

        final char op = (char) 8212;  //"—"
        final char cl = (char) 124; //"|"
        char[][] fr =
/*
                    {{cl, cl, cl, cl},
                     {op, cl, op, op},
                     {op, cl, op, op},
                     {op, cl, op, op},
*/
                       {{cl, cl, cl, op},
                        {op, cl, op, cl},
                        {op, cl, op, cl},
                        {cl, op, cl, cl},
                };

        Scanner in = new Scanner(System.in);
        int row = 0;
        int col = 0;
        int cnt = 0;
        FridgeGame game = new FridgeGame(4);
        //FridgeGame game = new FridgeGame(fr);
        //System.out.println("Base state");
        game.printFridgeState();

/*
        while (game.isStateExists(game.getLockedState()) && (row != -1 || col != -1) ) {
            System.out.print("row = ");
            row = in.nextInt();
            System.out.print("col = ");
            col = in.nextInt();
            if (row != -1 && col != -1) {
                game.doSwitch(row, col);
                game.printFridgeState();
                game.getListToSwitch();
            }
        }
*/

        while (cnt < 5 && game.isStateExists(game.getLockedState()))
        {
            //game.switchState(game.getLockedState(), true);
            game.doSwitch(game.getListToSwitch());
            System.out.print("");
            cnt++;
        }
        game.printFridgeState();
    }

}
