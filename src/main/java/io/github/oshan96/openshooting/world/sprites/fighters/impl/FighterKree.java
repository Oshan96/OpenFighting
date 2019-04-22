package io.github.oshan96.openshooting.world.sprites.fighters.impl;

import com.jogamp.newt.event.KeyEvent;
import io.github.oshan96.openshooting.graphics.Graphics;
import io.github.oshan96.openshooting.inputs.KeyEventListener;
import io.github.oshan96.openshooting.world.sprites.fighters.AbstractFighter;

/**
 * @author oshan
 */
public class FighterKree extends AbstractFighter {

    public FighterKree(float x, float y, int height, int width) {
        super(x, y, height, width, "kree");

    }

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
