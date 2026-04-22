package bluebird.recolor;

import net.minecraft.util.ARGB;

public class Colors {
    public static int xpText = -8323296;
    public static int xpTextBackground = -16777216;
    public static int xpAnvilTextFail = -40864;

    // Interpolates between these colors
    public static int xpOrb1 = 0x00FF00;
    public static int xpOrb2 = 0xFFFF33;

    public static int loadingScreen = ARGB.color(255, 239, 50, 61);
    public static int loadingScreenMonochrome = ARGB.color(255, 0, 0, 0);

    public static int cooldown = Integer.MAX_VALUE;
    public static int slotDragBackground = -2130706433;

    // World, Resource Pack, and Server list icons hover background
    public static int previewIconHover = -1601138544;

    public static int containerTitle = -12566464;
    public static int containerBackground = -1072689136;

    public static int socialInteractionsPlayerBackground = ARGB.color(255, 74, 74, 74);
    public static int socialInteractionsPlayerBackgroundHidden = ARGB.color(255, 48, 48, 48);

    public static int blockOutline = 1711276032;

    // Interpolates between these colors based on the durability
    public static int durabilityBarFull = 0x00FF00;
    public static int durabilityBarHalf = 0xFFFF00;
    public static int durabilityBarBroken = 0xFF0000;

    public static int damageColor = -1291911168;
}
