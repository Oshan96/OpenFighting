package io.github.oshan96.openshooting.resources;

import com.jogamp.opengl.GLBase;
import com.jogamp.opengl.GLContext;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;
import io.github.oshan96.openshooting.graphics.Renderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author oshan
 */
public class ImageResource {

    private Texture texture = null;
    private BufferedImage image = null;

    public ImageResource() {

    }

    public ImageResource(String path) {
        setImage(path);
    }

    public Texture getTexture() {
        texture = AWTTextureIO.newTexture(Renderer.getProfile(), image, true);

        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public BufferedImage getImage() {
        return image;
    }

    public ImageResource setImage(BufferedImage image) {
        this.image = image;
        this.image.flush();
        return this;
    }

    public ImageResource setImage(String path) {
        try {
            image = ImageIO.read(ImageResource.class.getResource(path));
            image.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }
}
