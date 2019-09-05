import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class White_Frame implements PlugInFilter {
public int setup (String arg, ImagePlus im) {
return DOES_8G; // this plugin accepts 8-bit grayscale images 9
}
public void run (ImageProcessor ip) {
int w = ip.getWidth();
int h = ip.getHeight();
if(w<21 || h < 21){
return;
}
// iterate over all image coordinates
for (int u = 0; u < w; u++) {
for (int v = 0; v < h; v++) {
if(u<10 || u>(w-11) || v<10 || v > (h-11)){
ip.putPixel(u, v, 255);
}
}
}
}
}