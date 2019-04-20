package io.github.oshan96.openshooting.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

/**
 * @author oshan
 */
public class EventListenerImpl implements GLEventListener {
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();

        gl.glClearColor(0,0,0,1);       //use black when the screen is cleared
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);        //clear the color buffer
        gl.glEnable(GL2.GL_TEXTURE_2D);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
        GL2 gl = glAutoDrawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);     //2-Dimensional
        gl.glLoadIdentity();

        gl.glOrtho(-400,400,-300,300,-1,1);    //-x,x,-y,y,-z,z (screen is mapped to pixel value)
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }
}
