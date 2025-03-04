package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class CheckDashesFilter implements PixelFilter {

    @Override
    public DImage processImage(DImage img) {
        short[][] grid = img.getBWPixelGrid();

        grid = crop(grid,0,0,500,500);

        System.out.println("Image is " + grid.length + " by "+ grid[0].length);

     int dashcount = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < 40; c++) {
                if(grid[r][c]==grid[r][c+10]){
                    dashcount++;

                }

            }
        }
        System.out.println(dashcount);



        img.setPixels(grid);
        return img;
    }private short[ ][ ] crop (short[][]grid, int r1, int c1, int r2, int c2){
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
