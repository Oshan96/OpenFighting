package io.github.oshan96.openfighting.graphics;

import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import io.github.oshan96.openfighting.inputs.KeyEventListener;

/**
 * @author oshan
 */
public class Renderer {

    private static GLWindow window = null;
    private static GLProfile profile = null;

    public static int tileSize = 20;
    public static int vTileSize = 14;

    public static void init() {
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        window = GLWindow.create(capabilities);

        window.setSize(800,600);
        window.setResizable(false);
        window.setTitle("Open Fighting - I");

        window.addGLEventListener(new EventListenerImpl());
        window.addKeyListener(new KeyEventListener());
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDestroyNotify(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        window.setVisible(true);

    }

    public static void render() {
        if(window != null)
            window.display();
    }

    public static GLProfile getProfile() {
        return profile;
    }

    public static int getWindowWidth () {
        return window.getWidth();
    }

    public static int getWindowHeight () {
        return window.getHeight();
    }

    public static GLWindow getGLWindow() {
        return window;
    }

}
