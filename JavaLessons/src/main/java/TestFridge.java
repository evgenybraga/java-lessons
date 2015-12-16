import com.fridge.FridgeGame;

import java.util.Scanner;

/**
 * Created by ibraga on 30/11/2015.
 */
public class TestFridge {
    public static void main(String[] args) {

        final char op = (char) 8212;  //"—"
        final char cl = (char) 124; //"|"
        int[][] fr = {{1, 1, 1, 1},
                      {1, 1, 1, 1},
                      {1, 1, 1, 1},
                      {1, 1, 1, 1}};

        Scanner in = new Scanner(System.in);
        int row = 0;
        int col = 0;
        int cnt = 0;
        //FridgeGame game = new FridgeGame(4);
        FridgeGame game = new FridgeGame(fr);
        //System.out.println("Base state");
        game.solve();
        game.printFridgeState();
    }

}
