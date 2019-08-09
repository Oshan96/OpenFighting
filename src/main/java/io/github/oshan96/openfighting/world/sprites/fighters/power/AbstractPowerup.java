package io.github.oshan96.openfighting.world.sprites.fighters.power;

import io.github.oshan96.openfighting.world.sprites.BasicGameObject;

/**
 * @author oshan
 */
public abstract class AbstractPowerup extends BasicGameObject {

    protected float movementSpeed = 6;

    public AbstractPowerup(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

}
