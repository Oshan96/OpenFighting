package io.github.oshan96.openshooting.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

/**
 * @author oshan
 */
public class Graphics {

    public static void createObjectTexture(Texture tex, float x, float y, float w, float h) {
        GL2 gl = EventListenerImpl.gl;


        if (tex != null) {
            gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
        }

        float width = tex.getWidth();
        float height = tex.getHeight();

        gl.glColor4f(1, 1, 1, 1);

        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0, 1);
        gl.glVertex2f(-1 , -1 );

        gl.glTexCoord2f(1, 1);
        gl.glVertex2f(1 , -1 );

        gl.glTexCoord2f(1, 0);
        gl.glVertex2f(1 , 1 );

        gl.glTexCoord2f(0, 0);
        gl.glVertex2f(-1 , 1 );
        gl.glEnd();

        gl.glFlush();



    }
}
