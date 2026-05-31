package bluebird.recolor;

public class ColorUtils {
    public static int lerpColor(int a, int b, float t) {
        int ar = (a >> 16) & 0xFF;
        int ag = (a >> 8) & 0xFF;
        int ab = a & 0xFF;

        int br = (b >> 16) & 0xFF;
        int bg = (b >> 8) & 0xFF;
        int bb = b & 0xFF;

        int r = (int)(ar + (br - ar) * t);
        int g = (int)(ag + (bg - ag) * t);
        int b2 = (int)(ab + (bb - ab) * t);

        return (r << 16) | (g << 8) | b2;
    }
}
