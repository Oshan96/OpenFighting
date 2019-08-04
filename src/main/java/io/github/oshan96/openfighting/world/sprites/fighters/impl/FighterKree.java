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
        powerTexture = new ImageResource().setImage("/images/powers/kree_power.png").getTexture();
    }

    /**
     * Checks all the keyEvents happened for character movements
     */
    @Override
    public void update() {
        float yIn = 0;
        //testing code
        if(KeyEventListener.isRegisteredKey(KeyEvent.VK_RIGHT)) {
            move(true);
        }

        if (KeyEventListener.isRegisteredKey(KeyEvent.VK_LEFT)) {
            move(false);
        }

        if (KeyEventListener.isRegisteredKey(KeyEvent.VK_UP)) {

            y += ++yIn * movementSpeed * GameLoop.getDelta();

            if(y>Renderer.tileSize / 2 - 0.5f) {
                y = Renderer.tileSize / 2 - 0.5f;
            } else if(y<-Renderer.tileSize / 2 + 0.5f) {
                y = -Renderer.tileSize / 2 + 0.5f;
            }
        }

        if (KeyEventListener.isRegisteredKey(KeyEvent.VK_DOWN)) {
            y += --yIn * movementSpeed * GameLoop.getDelta();

            if(y>Renderer.tileSize / 2 - 0.5f) {
                y = Renderer.tileSize / 2 - 0.5f;
            } else if(y<-Renderer.tileSize / 2 + 0.5f) {
                y = -Renderer.tileSize / 2 + 0.5f;
            }
        }

        if(KeyEventListener.isRegisteredKey(KeyEvent.VK_ENTER)) {

            //test
            BasicGameObject power = new BasicGameObject(x+1f,y,16,16) {
                float movementSpeed = 6;
                {
                    currentTexture = powerTexture;
                }
                @Override
                public void update() {
                    float xIn = 0;
                    x+= ++xIn * movementSpeed * GameLoop.getDelta();

                    if(x>Renderer.tileSize / 2 - 0.5f){
                        World.removeGameObject(this);
                    }
                }

                @Override
                public void render() {
                    Graphics.createObjectTexture(currentTexture,x,y,0.7f,0.8f,0);
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
        Graphics.createObjectTexture(currentAnimation.getCurrentImage(),x,y,charWidth,charHeight,0);
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
