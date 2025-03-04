package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class SeparateBubbles implements PixelFilter {


    @Override
    public DImage processImage(DImage img) {
        short[][] grid = img.getBWPixelGrid();


        grid = crop(grid,0,0,1500,500);
        grid = downSample(grid);

        img.setPixels(grid);
        return img;



    }

    private short[][] downSample (short[][]grid){

        short[][] newGrid = new short[grid.length/2][grid[0].length/2];
        short avg;

        for (int r = 0; r < grid.length-2; r += 2) {
            for (int c = 0; c < grid[r].length-2; c += 2) {
                int a1 = grid[r][c];
                int b1 = grid[r + 1][c];
                int c1 = grid[r][c + 1];
                int d1 = grid[r + 1][c + 1];
                avg = (short) ((a1 + b1 + c1 + d1) / 4);
                newGrid[r/2][c/2] = avg;
            }

        }
        return newGrid;

    }

    private short[][] crop (short[][]grid, int r1, int c1, int r2, int c2){
        int newRows = r2 - r1 + 1;
        int newCols = c2 - c1 + 1;
        short[][] croppedGrid = new short[newRows][newCols];

        for (int i = 0; i < newRows; i++) {
            for (int j = 0; j < newCols; j++) {
                croppedGrid[i][j] = grid[r1 + i][c1 + j];
            }
        }

        return croppedGrid;
    }
}
