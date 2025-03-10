package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class RunMultiple implements PixelFilter {

    @Override

    public DImage processImage(DImage img) {
        short[][] grid = img.getBWPixelGrid();


        img.setPixels(grid);
        return img;



    }


}
