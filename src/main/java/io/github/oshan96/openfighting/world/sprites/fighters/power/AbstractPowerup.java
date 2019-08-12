package io.github.oshan96.openfighting.world.sprites.fighters.power;

import io.github.oshan96.openfighting.graphics.Renderer;
import io.github.oshan96.openfighting.world.sprites.BasicGameObject;
import io.github.oshan96.openfighting.world.sprites.fighters.AbstractFighter;

/**
 * @author oshan
 */
public abstract class AbstractPowerup extends BasicGameObject {

    protected float movementSpeed = 6;
    protected AbstractFighter enemy = null;
    protected boolean tookHit = false;

    public AbstractPowerup(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    public AbstractFighter getEnemy() {
        return enemy;
    }

    public void setEnemy(AbstractFighter enemy) {
        this.enemy = enemy;
    }

    @Override
    public void collided() {
        if(this.x > enemy.getX() - 1 && this.x < enemy.getX() + 1 && this.y == enemy.getY()) {
            enemy.setHealth(enemy.getHealth() - 10);
            tookHit = true;
        }
    }


}
