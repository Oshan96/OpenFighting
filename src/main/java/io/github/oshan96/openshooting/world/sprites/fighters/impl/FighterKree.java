package io.github.oshan96.openshooting.world.sprites.fighters.impl;

import io.github.oshan96.openshooting.graphics.Graphics;
import io.github.oshan96.openshooting.graphics.Renderer;
import io.github.oshan96.openshooting.world.sprites.fighters.AbstractFighter;

/**
 * @author oshan
 */
public class FighterKree extends AbstractFighter {

    private static int place = 0;   //for testing

    public FighterKree(float x, float y, int height, int width) {
        super(x, y, height, width, "kree");

    }

    @Override
    public void update() {
        //testing code
        if(place > 5)
            place = 0;
        currentTexture = sprites.get(place++);

        x+=0.02;
        if(x > Renderer.tileSize / 2)
            x= - Renderer.tileSize / 2;

        ////////////////
    }

    @Override
    public void render() {
        Graphics.createObjectTexture(currentTexture,x,y,width,height);
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

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }
}
