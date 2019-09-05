import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class Horizontal_Shift implements PlugInFilter {
private ImagePlus im;
public int setup (String arg, ImagePlus im) {
this.im = im;
return DOES_8G; // this plugin accepts 8-bit grayscale images 9
}
public void run (ImageProcessor ip) {
int w = ip.getWidth();
int h = ip.getHeight();
for (int i = 0; i < w; i++) {
for (int v = 0; v < h; v++) {
int lastPixel = ip.getPixel(w-1, v);
for (int u = w-1; u > 0; u--) {
int p = ip.getPixel(u-1, v);
ip.putPixel(u, v, p);
}
ip.putPixel(0, v, lastPixel);
}
im.updateAndDraw();
}
}
}