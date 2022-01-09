
// Declare input class.to pass necessary input values to generate mandelbrot sequence.

public class mandelbrot_input {

    public double xa;
    public double xb;
    public double ya;
    public double yb;
    public int max;
    public int minheight;
    public int maxheight;
    public int minwidth;
    public int maxwidth;
    public String figure;

    public mandelbrot_input(double xa,double ya,double xb,double yb,int max,int minheight,int maxheight,int minwidth,int maxwidth,String figure)
    {
        this.xa = xa;
        this.xb = xb;
        this.ya = ya;
        this.yb = yb;
        this.max = max;
        this.minheight = minheight;
        this.minwidth = minwidth;
        this.maxheight = maxheight;
        this.maxwidth = maxwidth;
        this.figure = figure;

    }

}