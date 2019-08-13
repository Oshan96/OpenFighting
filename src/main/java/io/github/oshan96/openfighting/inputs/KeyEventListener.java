package io.github.oshan96.openfighting.inputs;

import com.jogamp.newt.event.KeyEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * @author oshan
 */
public class KeyEventListener implements com.jogamp.newt.event.KeyListener {

    private static Set<Short> registeredKeys = new HashSet<>();

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        registeredKeys.add(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        registeredKeys.remove(keyEvent.getKeyCode());
    }

    public static boolean isRegisteredKey(short keyCode) {
        return registeredKeys.contains(keyCode);
    }

    public static void clearKeys() {
        registeredKeys.clear();
    }
}
