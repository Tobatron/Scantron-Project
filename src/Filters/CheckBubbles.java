package Filters;

import Interfaces.PixelFilter;
import core.DImage;

import java.util.ArrayList;

public class CheckBubbles implements PixelFilter {


    @Override

    public DImage processImage(DImage img) {
        short[][] grid = img.getBWPixelGrid();
        ArrayList<Integer> blackList = new ArrayList<>();

//        for (int r = 53; r <= ; r += 12) {
//            for (int c = ; c < ; c++) {
//
//            }
//
//        }


        img.setPixels(grid);
        return img;



    }

    public static int getNumBlack(short[][] arr){
        int counter = 0;
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (arr[r][c] <80) counter++;
            }
        }
        return counter;
    }

}
