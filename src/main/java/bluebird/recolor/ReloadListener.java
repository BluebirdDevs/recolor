package bluebird.recolor;

import java.util.ArrayList;
import java.util.*;

public interface ReloadListener {
    List<ReloadListener> listeners = new ArrayList<>();
    void recolor$reload();

    static void addListener(ReloadListener listener) {
        listeners.add(listener);
    }

    static void reloadAll() {
        for (ReloadListener listener : listeners) {
            listener.recolor$reload();
        }
    }
}
