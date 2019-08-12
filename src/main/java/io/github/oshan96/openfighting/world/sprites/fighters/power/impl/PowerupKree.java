package io.github.oshan96.openfighting.world.sprites.fighters.power.impl;

import com.jogamp.opengl.util.texture.Texture;
import io.github.oshan96.openfighting.engine.GameLoop;
import io.github.oshan96.openfighting.graphics.Graphics;
import io.github.oshan96.openfighting.graphics.Renderer;
import io.github.oshan96.openfighting.world.World;
import io.github.oshan96.openfighting.world.sprites.fighters.power.AbstractPowerup;

/**
 * @author oshan
 */
public class PowerupKree extends AbstractPowerup {

    public PowerupKree(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    public PowerupKree(float x, float y, int width, int height, Texture texture) {
        this(x, y, width, height);
        currentTexture = texture;
    }

    @Override
    public void update() {
        float xIn = 0;
        x+= ++xIn * movementSpeed * GameLoop.getDelta();

        if(tookHit || x>Renderer.tileSize / 2 - 0.5f){
            World.removeGameObject(this);
        }
    }

    @Override
    public void render() {
        Graphics.createObjectTexture(currentTexture,x,y,0.8f,0.8f,0);
    }

    @Override
    public String toString() {
        return "PowerupKree";
    }
}
