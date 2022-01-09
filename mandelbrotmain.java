public class mandelbrotmain {
    public static void main(String[] args) {

        // Declasre array of input class.

        mandelbrot_input[] arr;

        //  Declare limit as 4 to split the input image 1000 By 1000 image.
        arr = new mandelbrot_input[4];

        // Store the input valies like min/max-range of real numbers,imaginarynumbers,maximumlimit,pixel size and piture name.
        arr[0] = new mandelbrot_input(-2,-2.5,2,2.5,50,0,500,0,500,"figure1");
        arr[1] = new mandelbrot_input(-2,-2.5,2,2.5,50,501,1000,0,500,"figure2");
        arr[2] = new mandelbrot_input(-2,-2.5,2,2.5,50,0,500,501,1000,"figure3");
        arr[2] = new mandelbrot_input(-2,-2.5,2,2.5,50,501,1000,501,1000,"figure4");

        // For parallel processing supply the 4 different input value and start the thread simultaneously.

        for(int i=0;i<4;i++)
        {
            mandelbrot_multithread  newThread = new mandelbrot_multithread(arr[i]);
            Thread firstThread = new Thread(newThread);
            firstThread.start();

        }
  
    }
}
