package com.lastshot;

public class Conway {
    public GridCanvas grid;

    public Conway() {
        grid = new GridCanvas(5, 10, 20);
        grid.turnOn(3, 1);
        grid.turnOn(3, 2);
        grid.turnOn(3, 3);
        grid.turnOn(1, 1);
        grid.turnOn(2, 1);
    }

    public void mainloop() {
        while(true) {
            this.update();
            grid.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("lol");
            }
        }
    }

    public int countAlive(int r, int c) {
        int count = 0;
        count += grid.test(r-1, c-1);
        count += grid.test(r-1, c);
        count += grid.test(r-1, c+1);
        count += grid.test(r, c+1);
        count += grid.test(r, c-1);
        count += grid.test(r+1, c+1);
        count += grid.test(r+1, c);
        count += grid.test(r+1, c+1);

        return count;
    }

    public void update() {
        int[][] counts = countNeighbors();
        updateGrid(counts);
    }

    private int[][] countNeighbors() {
        int rows = grid.numRows();
        int cols = grid.numCol();

        int[][] counts = new int[rows][cols];
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                counts[r][c] = countAlive(r, c);
            }
        }
        return counts;
    }

    private void updateGrid(int[][] counts) {
        int rows = grid.numRows();
        int cols = grid.numCol();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = grid.getCell(r, c);
                updateCell(cell, counts[r][c]);
            }
        }
    }

    private static void updateCell(Cell cell, int count) {
        if(cell.isOn()) {
            if(count<2 || count>3) {
                cell.turnOff();
            }
        } else {
            if(count == 3) {
                cell.turnOn();
            }
        }
    }
}
