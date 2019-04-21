package io.github.oshan96.openshooting.world;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import io.github.oshan96.openshooting.graphics.EventListenerImpl;
import io.github.oshan96.openshooting.graphics.Graphics;
import io.github.oshan96.openshooting.resources.SpriteSheet;

import java.util.List;

/**
 * @author oshan
 */
public class World {

    static List<Texture> sprites = null;
    static GL2 gl = EventListenerImpl.gl;

    static {
        sprites = SpriteSheet.getInstance().loadSpriteSheet("/images/sprites/kree.png").getSprites(64,64);
    }

    public static void update() {
//        System.out.println("Update");
    }

    public static void render() {
//        System.out.println("Rendering");

        Graphics.createObjectTexture(sprites.get(0),0,0,1,1);

    }
}
