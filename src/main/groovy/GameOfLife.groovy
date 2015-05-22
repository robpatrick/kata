import com.google.common.collect.Table
import com.google.common.collect.TreeBasedTable

/**
 * Created by robert.patrick on 21/05/2015.
 */
class GameOfLife {

    int maxRows = 3
    int maxCols = 3


    int getLiveNeighbours(Table grid, int row, int col) {

        int live = 0

        live += grid.get(row - 1, col - 1) ? 1 : 0
        live += grid.get(row - 1, col) ? 1 : 0
        live += grid.get(row - 1, col + 1) ? 1 : 0
        live += grid.get(row, col - 1) ? 1 : 0
        live += grid.get(row, col + 1) ? 1 : 0
        live += grid.get(row + 1, col - 1) ? 1 : 0
        live += grid.get(row + 1, col) ? 1 : 0
        live += grid.get(row + 1, col + 1) ? 1 : 0
        
        live
    }

    Table life(Table grid) {

        Table<Integer, Integer, Boolean> nextGeneration = TreeBasedTable.create()

        for (int col = 0; col < maxCols; col++) {
            for (int row = 0; row < maxRows; row++) {

                int liveNeighbours = getLiveNeighbours(grid, row, col)

                if (grid.get(row, col)) {

                    if (liveNeighbours < 2) {
                        nextGeneration.put(row, col, false)
                    }
                    if (liveNeighbours == 2 || liveNeighbours == 3) {
                        nextGeneration.put(row, col, true)
                    }
                    if (liveNeighbours > 3) {
                        nextGeneration.put(row, col, false)
                    }
                }
                if (!grid.get(row, col)) {
                    if (liveNeighbours == 3) {
                        nextGeneration.put(row, col, true)
                    } else {
                        nextGeneration.put(row, col, false)
                    }
                }
            }
        }

        nextGeneration
    }

    void printThisGeneration(Table myGenerationBaby) {
        for (int row = 0; row < maxRows; row++) {
            for (int col = 0; col < maxCols; col++) {
                print "${myGenerationBaby.get(row, col)} "
            }
            println ''
        }
    }
}
