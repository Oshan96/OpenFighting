package io.github.oshan96.openfighting.world.sprites.fighters.impl;

import com.jogamp.newt.event.KeyEvent;
import io.github.oshan96.openfighting.engine.GameLoop;
import io.github.oshan96.openfighting.graphics.Graphics;
import io.github.oshan96.openfighting.graphics.Renderer;
import io.github.oshan96.openfighting.inputs.KeyEventListener;
import io.github.oshan96.openfighting.resources.ImageResource;
import io.github.oshan96.openfighting.world.World;
import io.github.oshan96.openfighting.world.sprites.BasicGameObject;
import io.github.oshan96.openfighting.world.sprites.fighters.AbstractFighter;

/**
 * @author oshan
 */
public class FighterBee extends AbstractFighter {

    public FighterBee(float x, float y, int width, int height) {
        this(x, y, width, height, 0, 0);
    }

    /**
     * @param x         horizontal index position (in game units)
     * @param y         vertical index position (in game units)
     * @param width     width of the sprite
     * @param height    height of the sprite
     * @param offsetX   will be reduced from the width of the sprite (if the sprite has blank surrounding space)
     * @param offsetY   will be reduced from the height of the sprite (if the sprite has blank surrounding space)
     */
    public FighterBee(float x, float y, int width, int height, int offsetX, int offsetY) {
        super(x, y, width, height, "bee", offsetX, offsetY);
        powerTexture = new ImageResource().setImage("/images/powers/bee_power.png").getTexture();
    }

    /**
     * Checks all the keyEvents happened for character movements
     */
    @Override
    public void update() {
        float yIn = 0;
        //testing code
        if(KeyEventListener.isRegisteredKey(KeyEvent.VK_D)) {
            move(true);
        }

        if (KeyEventListener.isRegisteredKey(KeyEvent.VK_A)) {
            move(false);
        }

        if (KeyEventListener.isRegisteredKey(KeyEvent.VK_W)) {

            y += ++yIn * movementSpeed * GameLoop.getDelta();

            if(y>Renderer.tileSize / 2 - 0.5f) {
                y = Renderer.tileSize / 2 - 0.5f;
            } else if(y<-Renderer.tileSize / 2 + 0.5f) {
                y = -Renderer.tileSize / 2 + 0.5f;
            }
        }

        if (KeyEventListener.isRegisteredKey(KeyEvent.VK_S)) {
            y += --yIn * movementSpeed * GameLoop.getDelta();

            if(y>Renderer.tileSize / 2 - 0.5f) {
                y = Renderer.tileSize / 2 - 0.5f;
            } else if(y<-Renderer.tileSize / 2 + 0.5f) {
                y = -Renderer.tileSize / 2 + 0.5f;
            }
        }

        if(KeyEventListener.isRegisteredKey(KeyEvent.VK_F)) {

            //test
            BasicGameObject power = new BasicGameObject(x-1f,y,16,16) {
                float movementSpeed = 6;
                {
                    currentTexture = powerTexture;
                }
                @Override
                public void update() {
                    float xIn = 0;
                    x+= --xIn * movementSpeed * GameLoop.getDelta();

                    if(x< -(Renderer.tileSize / 2 + 0.5f)){
                        World.removeGameObject(this);
                    }
                }

                @Override
                public void render() {
                    Graphics.createObjectTexture(currentTexture,x,y,0.8f,0.8f,180);
                }
            };
            World.addGameObject(power);
            ////
        }
    }

    /**
     * Render the updates to the screen
     */
    @Override
    public void render() {
        animations.get("test").play();
        Graphics.createObjectTexture(currentAnimation.getCurrentImage(),x,y,charWidth,charHeight,180);
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
