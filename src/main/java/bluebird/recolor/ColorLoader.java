package bluebird.recolor;

import com.google.gson.*;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;

import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.*;

public class ColorLoader {
    private static final Map<Field, Integer> DEFAULT_VALUES = new HashMap<>();

    public static final Identifier LOCATION = Identifier.fromNamespaceAndPath(RecolorMain.MOD_ID, "colors.json");
    private static final Map<String, Field> FIELD_MAP = new HashMap<>();

    static {
        for (Field field : Colors.class.getDeclaredFields()) {
            if (field.getType() == int.class) {
                FIELD_MAP.put(field.getName(), field);
            }
            try {
                DEFAULT_VALUES.put(field, field.getInt(null));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void resetToDefaults() {
        for (Map.Entry<Field, Integer> entry : DEFAULT_VALUES.entrySet()) {
            try {
                entry.getKey().setInt(null, entry.getValue());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void reload(ResourceManager resourceManager) {
        try {
            resetToDefaults();

            List<Resource> stack = resourceManager.getResourceStack(LOCATION);

            for (Resource res : stack) {
                JsonObject json = JsonParser.parseReader(
                        new InputStreamReader(res.open())
                ).getAsJsonObject();

                apply(json);
            }

        } catch (Exception e) {
            RecolorMain.LOGGER.error("Failed to load color pack config", e);
        }
    }

    private static void apply(JsonObject json) {
        for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
            Field field = FIELD_MAP.get(entry.getKey());
            if (field == null) continue;

            try {
                int color = parseColor(entry.getValue());
                field.setInt(null, color);
            } catch (Exception e) {
                RecolorMain.LOGGER.error("Failed to parse color for key: {}", entry.getKey());
            }
        }
    }

    private static int parseColor(JsonElement element) {
        if (element.isJsonPrimitive()) {
            String hex = element.getAsString().replace("#", "").toLowerCase();

            if (hex.length() == 6) {
                int r = Mth.clamp(Integer.parseInt(hex.substring(0, 2), 16), 0, 255);
                int g = Mth.clamp(Integer.parseInt(hex.substring(2, 4), 16), 0, 255);
                int b = Mth.clamp(Integer.parseInt(hex.substring(4, 6), 16), 0, 255);
                return ARGB.color(r, g, b);
            } else if (hex.length() == 8) {
                int a = Mth.clamp(Integer.parseInt(hex.substring(0, 2), 16), 0, 255);
                int r = Mth.clamp(Integer.parseInt(hex.substring(2, 4), 16), 0, 255);
                int g = Mth.clamp(Integer.parseInt(hex.substring(4, 6), 16), 0, 255);
                int b = Mth.clamp(Integer.parseInt(hex.substring(6, 8), 16), 0, 255);
                return ARGB.color(a, r, g, b);
            }

            throw new IllegalArgumentException("Invalid hex color: " + hex);
        }

        if (element.isJsonArray()) {
            JsonArray arr = element.getAsJsonArray();
            if (arr.size() == 3) {
                int r = Mth.clamp(arr.get(0).getAsInt(), 0, 255);
                int g = Mth.clamp(arr.get(1).getAsInt(), 0, 255);
                int b = Mth.clamp(arr.get(2).getAsInt(), 0, 255);
                return ARGB.color(r, g, b);
            } else if (arr.size() == 4) {
                int r = Mth.clamp(arr.get(0).getAsInt(), 0, 255);
                int g = Mth.clamp(arr.get(1).getAsInt(), 0, 255);
                int b = Mth.clamp(arr.get(2).getAsInt(), 0, 255);
                int a = Mth.clamp(arr.get(3).getAsInt(), 0, 255);
                return ARGB.color(a, r, g, b);
            }

            throw new IllegalArgumentException("Color array must have 3 or 4 elements (RGB / RGBA)");
        }

        throw new IllegalArgumentException("Unsupported color format: " + element);
    }
}