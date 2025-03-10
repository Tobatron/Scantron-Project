package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class CheckBubbles implements PixelFilter {


    @Override

    public DImage processImage(DImage img) {
        short[][] grid = img.getBWPixelGrid();


        int count = 5;

        for (int i = 55; i < grid.length-5; i+=10) {
            for (int j = 60; j < grid[0].length; j+=10) {
                for (int r = i; r < i+5; r++) {
                    if(grid[r][j]<50){
                        count++;




                    }
                }
            }

        }

        img.setPixels(grid);
        return img;



    }
}
