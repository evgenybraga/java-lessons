package com.fridge;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ibraga on 30/11/2015.
 */
public class FridgeGame {

    private final static char STATE_OPEN = (char) 8212;  //"—"
    private final static char STATE_LOCKED = (char) 124; //"|"

    public enum State {
        opened,
        locked
    }

    private class Latch {
        final int row;
        final int column;
        final String description;
        State state;

        Latch(int row, int col, State state) {
            this.row = row;
            this.column = col;
            this.description = "row = ".concat(String.valueOf(row).concat("; col = ").concat(String.valueOf(col)));
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
            doSwitch(random.nextInt(size), random.nextInt(size));
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

    private void setState(int row, int col, State state) throws IndexOutOfBoundsException {
        try {
            latches[row][col].state = state;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public State getState(int row, int col) {
        try {
            return latches[row][col].state;

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

    /**
     * Switch all latches of specified state
     * Also exists conditional print of result
     *
     * @param state
     * @param printResult
     */
    public void switchState(State state, boolean printResult) {
        ArrayList<Latch> latchesList = getLatchList(state);
        if (latchesList.size() > 0) {
            int latchId = 0;
            while (latchId < latchesList.size() && isStateExists(state)) {
                doSwitch(latchesList.get(latchId).row, latchesList.get(latchId).column);
                latchId++;
            }
            if (printResult) {
                System.out.println(latchId + " switched");
                printFridgeState();
            }
        }
    }

    public void invertState(int row, int col) {
        if (getState(row, col) == State.opened) {
            setState(row, col, State.locked);
        } else {
            setState(row, col, State.opened);
        }
    }

    public void doSwitch(int row, int col) {
        invertState(row, col);
        for (int index = 0; index < size; index++) {
            if (index != row) {
                invertState(index, col);
            }
            if (index != col) {
                invertState(row, index);
            }
        }
    }

    public void doSwitch(ArrayList<Latch> latch) {
        int switches = 0;
        for (Latch element : latch) {
            doSwitch(element.row, element.column);
            System.out.println("Switching " + element.description);
            printFridgeState();
            switches++;
        }
        System.out.println("Switched amount = " + switches);
    }

    public void printFridgeState() {
        System.out.println("----------------------");
        for (int row = 0; row < size; row++) {
            System.out.print("[ ");
            for (int col = 0; col < size; col++) {
                System.out.print((latches[row][col].state == State.opened ? STATE_OPEN : STATE_LOCKED) + " ");
            }
            System.out.println("]");
        }
        System.out.println("----------------------");
    }

    /**
     * @param row
     * @param column
     * @return
     */
    private int sameStateCount(int row, int column) {
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

    /**
     *
     */
    public ArrayList<Latch> getListToSwitch() {
        ArrayList<Latch> latchLocked = getLatchList(State.locked);
        ArrayList<Latch> latchToSwitch = new ArrayList<Latch>(0);
        for (Latch locked : latchLocked) {
            if (sameStateCount(locked.row, locked.column) % 2 != 0) {
                latchToSwitch.add(locked);
            }
        }
        return latchToSwitch;
    }

}
