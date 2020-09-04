package test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTest {

    public static void main(String[] args) {

        try {
            BufferedImage image = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
//            BufferedImage image = ImageIO.read(new File("/Users/liushitao/jd/daily/steps/designpatterns/src/main/java/images/tankD.gif"));
            if(null != image){
                System.out.println("ok");
            }else {
                System.out.println("not ok");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
