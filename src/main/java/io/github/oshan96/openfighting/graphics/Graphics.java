package io.github.oshan96.openfighting.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

/**
 * @author oshan
 */
public class Graphics {

    public static void createObjectTexture(Texture tex, float x, float y, float width, float height, float rotation) {
        GL2 gl = EventListenerImpl.gl;

        gl.glEnable(GL2.GL_TEXTURE_2D);
        gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);

        if (tex != null) {
            gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
        }

        gl.glTranslatef(x, y, 0);
        if(rotation!=0)
            gl.glRotatef(-rotation,0,1,0);

        gl.glColor4f(1, 1, 1, 1);

        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0, 1);
        gl.glVertex2f(-width/2 , -height/2 );

        gl.glTexCoord2f(1, 1);
        gl.glVertex2f(width/2 , -height/2 );

        gl.glTexCoord2f(1, 0);
        gl.glVertex2f(width/2 , height/2 );

        gl.glTexCoord2f(0, 0);
        gl.glVertex2f(-width/2 , height/2 );
        gl.glEnd();

        gl.glDisable(GL2.GL_TEXTURE_2D);
        gl.glDisable(GL2.GL_BLEND);

        gl.glFlush();

        if(rotation!=0)
            gl.glRotatef(rotation,0,1,0);
        gl.glTranslatef(-x, -y, 0);

    }
}
