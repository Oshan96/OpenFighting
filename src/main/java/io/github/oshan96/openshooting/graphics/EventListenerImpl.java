package io.github.oshan96.openshooting.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import io.github.oshan96.openshooting.world.World;
import io.github.oshan96.openshooting.world.sprites.fighters.impl.FighterKree;

/**
 * @author oshan
 */
public class EventListenerImpl implements GLEventListener {

    public static GL2 gl;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL().getGL2();
        gl.glClearColor(0,0,0,1);       //use black when the screen is cleared
        gl.glEnable(GL2.GL_TEXTURE_2D);

        FighterKree playerOne = new FighterKree(0,0,64,64);
        World.addGameObject(playerOne);
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
//        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);        //clear the color buffer

        World.render();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
        gl = glAutoDrawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);     //2-Dimensional
        gl.glLoadIdentity();

//        gl.glOrtho(-400,400,-300,300,-1,1);    //-x,x,-y,y,-z,z (screen is mapped to pixel value)

        float unitsTall = Renderer.getWindowHeight() / (Renderer.getWindowWidth() / Renderer.tileSize);

        gl.glOrtho(-Renderer.tileSize / 2, Renderer.tileSize / 2, -unitsTall / 2, unitsTall / 2, -1, 1);

        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }
}
