package io.github.oshan96.openfighting.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.texture.Texture;
import io.github.oshan96.openfighting.resources.ImageResource;
import io.github.oshan96.openfighting.world.World;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author oshan
 */
public class EventListenerImpl implements GLEventListener {

    public static GL2 gl;
    public static Texture background = null;

    TextRenderer t;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL().getGL2();
        gl.glClearColor(0,0,0,1);

        background = new ImageResource("/images/background/street.png").getTexture();
        Graphics.createObjectTexture(background,0,0,Renderer.tileSize,Renderer.vTileSize,0);

        try {
            InputStream in = getClass().getResourceAsStream("/fonts/MK.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT,in).deriveFont(36f).deriveFont(Font.BOLD);
            t = new TextRenderer(font);
        } catch (Exception ex) {
            System.out.println("Font failed to load");
        }

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);        //clear the color buffer

        World.render();
        t.beginRendering(Renderer.getWindowWidth(),Renderer.getWindowHeight());
        t.setColor(Color.ORANGE);
        t.draw("START FIGHT",Renderer.getWindowWidth()/2 - 125,Renderer.getWindowHeight()/2);
        t.endRendering();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
        gl = glAutoDrawable.getGL().getGL2();

        gl.glMatrixMode(GL2.GL_PROJECTION);     //2-Dimensional
        gl.glLoadIdentity();

        gl.glOrtho(-Renderer.tileSize / 2, Renderer.tileSize / 2, -Renderer.vTileSize/2, Renderer.vTileSize/2, -1, 1);

        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }
}
