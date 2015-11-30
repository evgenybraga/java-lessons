import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ibraga on 30/11/2015.
 */
public class FridgeGame
{
    private class LockedList
    {
        final int lockedLatchRow;
        final int lockedLatchCol;
        final String lockedLatchPos;

        LockedList(int row, int col)
        {
            this.lockedLatchRow = row;
            this.lockedLatchCol = col;
            this.lockedLatchPos = "row = " + row + "; col = " + col;
        }
    }

    private final static char STATE_OPEN = (char)8212;  //"—"
    private final static char STATE_LOCKED = (char)124; //"|"

    private char[][] latchesMatrix;
    private int latchesMatrixSize = 0;

    public FridgeGame(int size)
    {
        latchesMatrixSize = size;
        latchesMatrix = new char[size][size];
        Random random = new Random();

        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
            {
                latchesMatrix[row][col] = (random.nextInt(2) == 1 ? STATE_OPEN:STATE_LOCKED);
            }
        }
    }

    public FridgeGame(char[][] latches)
    {
        latchesMatrixSize = latches.length;
        latchesMatrix = new char[latchesMatrixSize][latchesMatrixSize];
        latchesMatrix = latches;
    }

    public int getLatchesMatrixSize()
    {
        return latchesMatrixSize;
    }

    public boolean isLatchOpen(int row, int col)
    {
        return (latchesMatrix[row][col] == STATE_OPEN ? true:false);
    }

    public void setLatchState(int row, int col, char state)
    {
        if(row <= getLatchesMatrixSize() && col <= getLatchesMatrixSize() && (state == STATE_LOCKED || state == STATE_OPEN))
        {
            latchesMatrix[row][col] = state;
        }
    }

    private ArrayList<LockedList> getListOfLocked()
    {
        ArrayList<LockedList> lockedList = new ArrayList<LockedList>();
        for (int row = 0; row < getLatchesMatrixSize(); row++)
        {
            for (int col = 0; col < getLatchesMatrixSize(); col++)
            {
                if (!isLatchOpen(row, col))
                {
                    lockedList.add(new LockedList(row, col));
                }
            }
        }
        //System.out.println(lockedList.size());
        /*for (int idx = 0; idx < lockedList.size(); idx++)
        {
            System.out.println(lockedList.get(idx).lockedLatchPos);
        }
        */
        return lockedList;
    }

    public boolean isLockedExists()
    {
        return getListOfLocked().size() > 0 ? true:false;
    }

    public void switchLocked(boolean printresult)
    {
        ArrayList<LockedList> lockedList = getListOfLocked();

        if (lockedList.size() > 0)
        {
            for (int lockidx = 0; lockidx < lockedList.size(); lockidx++)
            {
                if (printresult)
                {
                    System.out.println("Switch " + lockedList.get(lockidx).lockedLatchPos);
                }

                doSwitch(lockedList.get(lockidx).lockedLatchRow, lockedList.get(lockidx).lockedLatchCol);

                if (printresult)
                {
                    printFridgeState();
                }
            }
        }
    }


    public void invertLatchState(int row, int col)
    {
        if(row <= getLatchesMatrixSize() && col <= getLatchesMatrixSize())
        {
            if (isLatchOpen(row, col))
            {
                setLatchState(row, col, STATE_LOCKED);
            }
            else
            {
                setLatchState(row, col, STATE_OPEN);
            }
        }

    }
    public void doSwitch(int latchRow, int latchCol)
    {
        if(latchRow <= getLatchesMatrixSize() && latchCol <= getLatchesMatrixSize())
        {
            invertLatchState(latchRow, latchCol);
            for (int idx = 0; idx < getLatchesMatrixSize(); idx++)
            {
                if (idx != latchRow)
                {
                    invertLatchState(idx, latchCol);
                }

                if (idx != latchCol)
                {
                    invertLatchState(latchRow, idx);
                }
            }
        }
    }

    public void printFridgeState()
    {
        System.out.println("----------------------");
        for (int row = 0; row < getLatchesMatrixSize(); row++)
        {
            System.out.print("[ ");
            for (int col = 0; col < getLatchesMatrixSize(); col++)
            {
                System.out.print(latchesMatrix[row][col] + " ");
            }
            System.out.println("]");
        }
        System.out.println("----------------------");
    }


}
