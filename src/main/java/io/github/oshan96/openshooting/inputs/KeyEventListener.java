package io.github.oshan96.openshooting.inputs;

import com.jogamp.newt.event.KeyEvent;

/**
 * @author oshan
 */
public class KeyEventListener implements com.jogamp.newt.event.KeyListener {
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
