package io.github.oshan96.openshooting.graphics;

import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

/**
 * @author oshan
 */
public class Renderer {

    private static GLWindow window = null;
    private static GLProfile profile = null;

    public static void init() {
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        window = GLWindow.create(capabilities);
        window.setSize(800,600);
        window.setResizable(false);

        window.setTitle("Open Fighting - I");

        window.addGLEventListener(new EventListenerImpl());

        ///////////////////
        FPSAnimator animator = new FPSAnimator(window, 60);     //60fps

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDestroyNotify(WindowEvent windowEvent) {
                if(animator.isAnimating())
                    animator.stop();
                System.exit(0);
            }
        });

        //////////////
        animator.start();           //start the rendering loop
        window.setVisible(true);


    }

    public static GLProfile getProfile() {
        return profile;
    }

    public static void main(String[] args) {
        init();
    }
}
