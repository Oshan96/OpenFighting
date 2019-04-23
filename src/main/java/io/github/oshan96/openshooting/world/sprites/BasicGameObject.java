package io.github.oshan96.openshooting.world.sprites;

import com.jogamp.opengl.util.texture.Texture;

/**
 * @author oshan
 */
public abstract class BasicGameObject {
    protected float x;
    protected float y;
    protected int height;
    protected int width;

    protected Texture currentTexture = null;

    public BasicGameObject(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Texture getCurrentTexture() {
        return currentTexture;
    }

    public void setCurrentTexture(Texture currentTexture) {
        this.currentTexture = currentTexture;
    }

    public abstract void update();

    public abstract void render();


}
