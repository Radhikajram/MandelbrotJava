import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class mandelbrot_multithread implements Runnable {

    private double xa;
    private double xb;
    private double ya;
    private double yb;
    private int max;
    private int minheight;
    private int maxheight;
    private int minwidth;
    private int maxwidth;
    private String figure;

   // Get the passed input values in constructor.

    public mandelbrot_multithread(mandelbrot_input mandelbrot_input) {
        this.xa = mandelbrot_input.xa;
        this.xb = mandelbrot_input.xb;
        this.ya = mandelbrot_input.ya;
        this.yb = mandelbrot_input.yb;
        this.max = mandelbrot_input.max;
        this.minheight = mandelbrot_input.minheight;
        this.minwidth = mandelbrot_input.minwidth;
        this.maxheight = mandelbrot_input.maxheight;
        this.maxwidth = mandelbrot_input.maxwidth;
        this.figure = mandelbrot_input.figure;
    }
    // run the Mandelbort logic.
    @Override
	public void run() {
    
        // input the picutre pixel values
        int imageX=1000,imageY=1000;

        // convert to png image.
        String figureName = figure + ".png";

        BufferedImage image = new BufferedImage(imageX,imageY, BufferedImage.TYPE_INT_RGB);
        int black = 0x000000, white = 0xFFFFFF;
      
        double maxheight1 = imageX ;
      
        double maxwidth1  = imageY ;

        //Loop through the range minheight & maxheight(row) and minwidhth & maxwidht(col)

        for (int row = minheight; row < maxheight; row++) {
            for (int col = minwidth; col < maxwidth; col++) {
                // Calculate the real and imaginary numbers.

                double c_re = (col - maxwidth1/2)*4.0/maxwidth1;

                double c_im = (row - maxheight1/2)*4.0/maxwidth1;

                // As the Mandelbort numbers lies within the range -2 to 2 and -2.5 to 2.5.Iterate for this range.
                // Calcuate the next sequence of real and imaginary numbers using the formula. f_{c}(z)=z^{2}+c
                double x = 0, y = 0;
                int iterations = 0;
                while (x*x+y*y < 4 && iterations < max && xa < c_re && xb > c_re && ya < c_im && yb > c_im ) {
                    double x_new = x*x-y*y+c_re;
                    y = 2*x*y+c_im;
                    x = x_new;
                    iterations++;
                } 

                if (iterations < max) image.setRGB(col, row, white);
                // Mandelbrot numbers are painted in black.
                else image.setRGB(col, row, black);
            }
        }

        try {
            ImageIO.write(image, "png", new File(figureName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





