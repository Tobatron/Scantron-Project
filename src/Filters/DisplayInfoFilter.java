package Filters;

import Interfaces.PixelFilter;
import core.DImage;

import java.sql.SQLOutput;

public class DisplayInfoFilter implements PixelFilter {
    public DisplayInfoFilter() {
        System.out.println("Filter running...");
    }

    @Override
    public DImage processImage(DImage img) {
        short[][] grid = img.getBWPixelGrid();

        grid = crop(grid,0,0,500,500);

        System.out.println("Image is " + grid.length + " by "+ grid[0].length);

        int blackCount = 0;
        int whiteCount = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] < 10) blackCount++;
                if (grid[r][c] > 240) whiteCount++;
            }
        }


        System.out.println(blackCount + " nearly black pixels and " + whiteCount + " nearly white pixels");
        System.out.println("----------------------------------------");
        System.out.println("If you want, you could output information to a file instead of printing it.");
        img.setPixels(grid);
        return img;
    }
  private short[ ][ ] crop (short[][]grid, int r1, int c1, int r2, int c2){
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

