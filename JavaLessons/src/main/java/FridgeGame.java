import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ibraga on 30/11/2015.
 */
public class FridgeGame {
    private class Latch {
        final int latchRow;
        final int latchCol;
        final String latchPosition;

        Latch(int row, int col) {
            this.latchRow = row;
            this.latchCol = col;
            this.latchPosition = "row = " + row + "; col = " + col;
        }
    }

    private final static char STATE_OPEN = (char) 8212;  //"—"
    private final static char STATE_LOCKED = (char) 124; //"|"
    private final static char STATE_UNDEFINED = (char) 0; //"|"

    private char[][] latchesMatrix;
    private int latchesMatrixSize = 0;

    /**
     * Defines game matrix of @size
     * and fill it with random values
     */
    public FridgeGame(int size) {
        latchesMatrixSize = size;
        latchesMatrix = new char[size][size];
        Random random = new Random();
        //Fill matrix with all opened latches
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                //latchesMatrix[row][col] = (random.nextInt(2) == 1 ? STATE_OPEN:STATE_LOCKED);
                latchesMatrix[row][col] = STATE_OPEN;
            }
        }
        // Start tangle matrix
        for (int row = 0; row < size; row++) {
            this.invertLatchState(random.nextInt(size), random.nextInt(size));
            System.out.println(random.nextInt(size) + " " + random.nextInt(size));
        }

    }

    /**
     * Defines game matrix based on input parameter @latches
     */
    public FridgeGame(char[][] latches) {
        latchesMatrixSize = latches.length;
        latchesMatrix = new char[latchesMatrixSize][latchesMatrixSize];
        latchesMatrix = latches;
    }


    public char getLockedState() {
        return STATE_LOCKED;
    }

    public char getOpenedState() {
        return STATE_OPEN;
    }

    public char getUndefinedState() {
        return STATE_UNDEFINED;
    }

    public char[][] getLatchesMatrix() {
        return latchesMatrix;
    }

    public int getLatchesMatrixSize() {
        return latchesMatrixSize;
    }

    public void setLatchState(int row, int col, char state) {
        if (row < getLatchesMatrixSize() && col < getLatchesMatrixSize() && (state == getLockedState() || state == getOpenedState())) {
            latchesMatrix[row][col] = state;
        }
    }

    public char getLatchState(int row, int col) {
        try {
            if (!(row >= 0 && row < getLatchesMatrixSize() && col >= 0 && col < getLatchesMatrixSize())) {
                throw new IndexOutOfBoundsException("Unable to locate state of matrix for row = " + row + " and col = " + col);
            }
            return latchesMatrix[row][col];
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return getUndefinedState();
        }
    }

    private ArrayList<Latch> getListOfLatches(char state) {
        ArrayList<Latch> latchList = new ArrayList<Latch>();
        if (state == getOpenedState() || state == getLockedState()) {
            for (int row = 0; row < getLatchesMatrixSize(); row++) {
                for (int col = 0; col < getLatchesMatrixSize(); col++) {
                    if (getLatchState(row, col) == state) {
                        latchList.add(new Latch(row, col));
                    }
                }
            }
        }
        return latchList;
    }

    public boolean isStateExists(char state) {
        if (state == getOpenedState() || state == getLockedState()) {
            return (getListOfLatches(state).size() > 0);
        }
        return false;
    }

    /**
     * Switch all latches in matrix of specified state
     * Also exists conditional print of result
     *
     * @param state
     * @param printResult
     */
    public void switchState(char state, boolean printResult) {
        ArrayList<Latch> latchesList = getListOfLatches(state);
        if (latchesList.size() > 0) {
            int latchId = 0;
            while (latchId < latchesList.size() && isStateExists(state)) {
                doSwitch(latchesList.get(latchId).latchRow, latchesList.get(latchId).latchCol);
                latchId++;
            }
            if (printResult) {
                System.out.println(latchId + " switched");
                printFridgeState();
            }
        }
    }

    public void invertLatchState(int row, int col) {
        if (row < getLatchesMatrixSize() && col < getLatchesMatrixSize()) {
            if (getLatchState(row, col) == getOpenedState()) {
                setLatchState(row, col, getLockedState());
            } else {
                setLatchState(row, col, getOpenedState());
            }
        }

    }

    public void doSwitch(int latchRow, int latchCol) {
        if (latchRow < getLatchesMatrixSize() && latchCol < getLatchesMatrixSize()) {
            invertLatchState(latchRow, latchCol);
            for (int idx = 0; idx < getLatchesMatrixSize(); idx++) {
                if (idx != latchRow) {
                    invertLatchState(idx, latchCol);
                }

                if (idx != latchCol) {
                    invertLatchState(latchRow, idx);
                }
            }
        }
    }

    public void printFridgeState() {
        System.out.println("----------------------");
        for (int row = 0; row < getLatchesMatrixSize(); row++) {
            System.out.print("[ ");
            for (int col = 0; col < getLatchesMatrixSize(); col++) {
                System.out.print(latchesMatrix[row][col] + " ");
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
        if (row < getLatchesMatrixSize() && column < getLatchesMatrixSize()) {
            char latchState = getLatchState(row, column);
            int latchStateCount = 1;
            for (int index = 0; index < getLatchesMatrixSize(); index++) {
                if (index != row && getLatchState(index, column) == latchState) {
                    latchStateCount++;
                }

                if (index != column && getLatchState(row, index) == latchState) {
                    latchStateCount++;
                }
            }
            return latchStateCount;
        }
        return 0;
    }

    /**
     *
     */
    public void getListToSwitch() {
        ArrayList<Latch> latchLocked = getListOfLatches(getLockedState());
        for (Latch locked : latchLocked) {
            if (sameStateCount(locked.latchRow, locked.latchCol) % 2 != 0) {
                System.out.println(locked.latchPosition + "; " + sameStateCount(locked.latchRow, locked.latchCol));
            }
        }
    }

}
