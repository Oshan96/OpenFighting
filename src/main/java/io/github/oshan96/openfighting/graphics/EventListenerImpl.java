package io.github.oshan96.openfighting.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.texture.Texture;
import io.github.oshan96.openfighting.resources.ImageResource;
import io.github.oshan96.openfighting.world.World;

import java.awt.*;
import java.io.InputStream;

/**
 * @author oshan
 */
public class EventListenerImpl implements GLEventListener {

    public static GL2 gl;
    public static Texture background = null;

    private TextRenderer textRenderer;
    private TextRenderer winText;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL().getGL2();
        gl.glClearColor(0,0,0,1);

        background = new ImageResource("/images/background/street.png").getTexture();
        Graphics.createObjectTexture(background,0,0,Renderer.tileSize,Renderer.vTileSize,0);

        try {
            InputStream in = getClass().getResourceAsStream("/fonts/pixel_font.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT,in).deriveFont(52f).deriveFont(Font.PLAIN);
            textRenderer = new TextRenderer(font);

            InputStream in2 = getClass().getResourceAsStream("/fonts/pixel_font.ttf");
            Font font2 = Font.createFont(Font.TRUETYPE_FONT,in2).deriveFont(80f).deriveFont(Font.PLAIN);
            winText = new TextRenderer(font2);
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

        World.render(); //render game objects in world

        //render text
        textRenderer.beginRendering(Renderer.getWindowWidth(),Renderer.getWindowHeight());
        textRenderer.setColor(Color.ORANGE);
        textRenderer.draw("KREE : " + World.getPlayerOne().getHealth(),20,Renderer.getWindowHeight() - 70);
        textRenderer.draw("BEE : " + World.getPlayerTwo().getHealth(),Renderer.getWindowWidth() - 200,Renderer.getWindowHeight() - 70);
        textRenderer.endRendering();

        if(World.getWinner() != null) {
            winText.beginRendering(Renderer.getWindowWidth(),Renderer.getWindowHeight());
            winText.setColor(Color.ORANGE);
            winText.draw(World.getWinner().toString() + " WINS!", Renderer.getWindowWidth()/2 - 230, Renderer.getWindowHeight()/2);
            winText.endRendering();
        }
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
