package io.github.oshan96.openshooting.world.sprites.fighters.impl;

import com.jogamp.newt.event.KeyEvent;
import io.github.oshan96.openshooting.graphics.Graphics;
import io.github.oshan96.openshooting.inputs.KeyEventListener;
import io.github.oshan96.openshooting.world.sprites.fighters.AbstractFighter;

/**
 * @author oshan
 */
public class FighterKree extends AbstractFighter {

    public FighterKree(float x, float y, int width, int height) {
        this(x,y,width,height,0,0);
    }

    /**
     * @param x         horizontal index position (in game units)
     * @param y         vertical index position (in game units)
     * @param width     width of the sprite
     * @param height    height of the sprite
     * @param offsetX   will be reduced from the width of the sprite (if the sprite has blank surrounding space)
     * @param offsetY   will be reduced from the height of the sprite (if the sprite has blank surrounding space)
     */
    public FighterKree(float x, float y, int width, int height, int offsetX, int offsetY) {
        super(x, y, width, height, "kree", offsetX, offsetY);
    }

    /**
     * Checks all the keyEvents happened for character movements
     */
    @Override
    public void update() {
        //testing code
        if(KeyEventListener.isRegisteredKey(KeyEvent.VK_RIGHT)) {
            move(true);
        }

        if (KeyEventListener.isRegisteredKey(KeyEvent.VK_LEFT)) {
            move(false);
        }

        if (KeyEventListener.isRegisteredKey(KeyEvent.VK_UP)) {
            jump();
        }

    }

    /**
     * Render the updates to the screen
     */
    @Override
    public void render() {
        animations.get("test").play();
//        Graphics.createObjectTexture(currentTexture,x,y,width,height);
        Graphics.createObjectTexture(animations.get("test").getCurrentImage(),x,y,width,height);
    }


    @Override
    public void lowPunch() {

    }

    @Override
    public void lowKick() {

    }

    @Override
    public void highKick() {

    }

    @Override
    public void highPunch() {

    }

    @Override
    public void block() {

    }

    @Override
    public void jump() {

    }

    @Override
    public void crouch() {

    }

}
