package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class RunMultiple implements PixelFilter {

    PixelFilter CheckBubbles = new CheckBubbles();
    PixelFilter CropImage = new CropImage();
    PixelFilter FixedThresholdFilter = new FixedThresholdFilter();

    @Override

    public DImage processImage(DImage img) {



        img = CropImage.processImage(img);

        img = FixedThresholdFilter.processImage(img);

        //img = CheckBubbles.processImage(img);


        return img;



    }


}
