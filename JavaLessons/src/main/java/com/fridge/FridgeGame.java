package com.fridge;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ibraga on 30/11/2015.
 */
public class FridgeGame {

    private final static char STATE_OPEN = (char) 8212;  //"—"
    private final static char STATE_LOCKED = (char) 124; //"|"

    private enum State {
        opened,
        locked
    }


    private class Latch {
        final int row;
        final int column;
        final String description;
        State state;

        Latch(int row, int column, State state) {
            this.row = row;
            this.column = column;
            this.description = "row = ".concat(String.valueOf(row).concat("; column = ").concat(String.valueOf(column)));
            this.state = state;
            //this.stateToPrint = (state == State.opened ? STATE_OPEN:STATE_LOCKED);
        }
    }


    private class FridgeException extends Exception {

    }


    //private char[][] latchesMatrix;
    private Latch[][] latches;
    private int size = 0;

    /**
     * Defines game matrix of @size
     * and fill it with random values
     */
    public FridgeGame(int size) {
        this.size = size;
        this.latches = new Latch[size][size];
        Random random = new Random();
        //Fill matrix with all opened latches
        for (int row = 0; row < size; row++) {
            //latches[row] = new Latch[size];
            for (int column = 0; column < size; column++) {
                latches[row][column] = new Latch(row, column, State.opened);
            }
        }
        // Start tangle matrix
        for (int row = 0; row < size; row++) {
            singleSwitch(random.nextInt(size), random.nextInt(size));
        }

    }

    /**
     * Defines game matrix based on input parameter @latches
     */
    public FridgeGame(int[][] latches) {
        size = latches.length;
        this.latches = new Latch[size][size];
        //0 - Opened state
        //1 - Locked state
        try {
            for (int row = 0; row < latches.length; row++) {
                for (int column = 0; column < latches[row].length; column++) {
                    switch (latches[row][column]) {
                        case 0:
                            this.latches[row][column] = new Latch(row, column, State.opened);
                            break;
                        case 1:
                            this.latches[row][column] = new Latch(row, column, State.locked);
                            break;
                        default:
                            throw new FridgeException();
                    }
                }
            }
        } catch (FridgeException e) {
            e.printStackTrace();
        }
    }

    public static State opened() {
        return State.opened;
    }

    public static State locked() {
        return State.locked;
    }

    private void setState(int row, int column, State state) throws IndexOutOfBoundsException {
        try {
            latches[row][column].state = state;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public State getState(int row, int column) throws IndexOutOfBoundsException {
        try {
            return latches[row][column].state;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Returns list of latches with given state
     *
     * @param state
     * @return
     */
    private ArrayList<Latch> getLatchList(State state) {
        ArrayList<Latch> latchList = new ArrayList<Latch>();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (getState(row, col) == state) {
                    latchList.add(new Latch(row, col, state));
                }
            }
        }
        return latchList;
    }

    public boolean isStateExists(State state) {
        return (getLatchList(state).size() > 0 ? true : false);
    }


    public void invertState(int row, int column) {
        if (getState(row, column) == State.opened) {
            setState(row, column, State.locked);
        } else {
            setState(row, column, State.opened);
        }
    }

    /**
     * Switch given latch and connected to them neighbours to opposite state
     *
     * @param row
     * @param column
     */
    public void singleSwitch(int row, int column) {
        invertState(row, column);
        for (int index = 0; index < size; index++) {
            if (index != row) {
                invertState(index, column);
            }
            if (index != column) {
                invertState(row, index);
            }
        }
    }

    public void switchState(State state, boolean printResult) {
        ArrayList<Latch> latchList = getLatchList(state);
        ArrayList<Latch> latchToSwitch = new ArrayList<Latch>();
        int switches = 0;

        for (Latch latch : latchList) {
            if ((stateCount(latch.row, latch.column) & 1) != 0) {
                latchToSwitch.add(latch);
            }
        }

        for (Latch element : (latchToSwitch.size() > 0 ? latchToSwitch : latchList)) {
            System.out.println("Switching " + element.description);
            if (isStateExists(state)) {
                singleSwitch(element.row, element.column);
            }
            if (printResult) {
                printFridgeState();
            }
            switches++;
        }
        System.out.println("Switched amount = " + switches);
        printFridgeState();
    }


    /**
     * Get number of latches in same state as latch[row, column] in row and column + specified latch
     *
     * @param row
     * @param column
     * @return
     */
    private int stateCount(int row, int column) {
        State current = getState(row, column);
        int latchStateCount = 1;
        for (int index = 0; index < size; index++) {
            if (index != row && getState(index, column) == current) {
                latchStateCount++;
            }

            if (index != column && getState(row, index) == current) {
                latchStateCount++;
            }
        }
        return latchStateCount;
    }


    public void printFridgeState() {
        System.out.println("----------------------");
        for (int row = 0; row < size; row++) {
            System.out.print("[ ");
            for (int column = 0; column < size; column++) {
                System.out.print((latches[row][column].state == State.opened ? STATE_OPEN : STATE_LOCKED) + " ");
            }
            System.out.println("]");
        }
        System.out.println("----------------------");
    }

    public void solve() {
        while (isStateExists(FridgeGame.locked())) {
            switchState(FridgeGame.locked(), false);
            System.out.print("");
        }
    }


}

