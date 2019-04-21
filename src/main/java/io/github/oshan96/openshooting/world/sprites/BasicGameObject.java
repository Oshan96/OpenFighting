package io.github.oshan96.openshooting.world.sprites;

import com.jogamp.opengl.util.texture.Texture;

/**
 * @author oshan
 */
public abstract class BasicGameObject {
    protected double x;
    protected double y;
    protected int height;
    protected int width;

    protected Texture currentTexture = null;

    public BasicGameObject(double x, double y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
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
