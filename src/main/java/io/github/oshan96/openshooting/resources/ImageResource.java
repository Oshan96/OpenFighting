package io.github.oshan96.openshooting.resources;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;
import io.github.oshan96.openshooting.graphics.Renderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author oshan
 */
public class ImageResource {

    private static Texture texture = null;
    private static BufferedImage image = null;

    public ImageResource(String path) {
        try {
            image = ImageIO.read(ImageResource.class.getResource(path));
            image.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Texture getTexture() {
        if(texture == null) {
            texture = AWTTextureIO.newTexture(Renderer.getProfile(), image, true);
        }
        return texture;
    }
}
