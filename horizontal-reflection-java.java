import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class Reflected_Image implements PlugInFilter {
public int setup (String arg, ImagePlus im) {
return DOES_8G; // this plugin accepts 8-bit grayscale images 9
}
public void run (ImageProcessor ip) {
int w = ip.getWidth();
int h = ip.getHeight();
// iterate over all image coordinates
for (int u = 0; u < h/2; u++) {
for (int v = 0; v < w; v++) {
int p = ip.getPixel(v,u);
int p1 = ip.getPixel( v,h-u-1);
ip.putPixel(v,u, p1);
ip.putPixel( v,h-u-1, p);
}
}
}
}