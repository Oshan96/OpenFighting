package io.github.oshan96.openfighting.world.sprites.fighters.power;

import io.github.oshan96.openfighting.graphics.Renderer;
import io.github.oshan96.openfighting.inputs.KeyEventListener;
import io.github.oshan96.openfighting.world.World;
import io.github.oshan96.openfighting.world.sprites.BasicGameObject;
import io.github.oshan96.openfighting.world.sprites.fighters.AbstractFighter;

/**
 * @author oshan
 */
public abstract class AbstractPowerup extends BasicGameObject {

    protected float movementSpeed = 6;
    protected AbstractFighter enemy = null;
    protected AbstractFighter owner = null;
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

    public void setOwner(AbstractFighter owner) {
        this.owner = owner;
    }

    @Override
    public void collided() {
        if(this.x > enemy.getX() - 1 && this.x < enemy.getX() + 1 && this.y > enemy.getY()-0.4f && this.y < enemy.getY() + 0.4f) {
            enemy.setCurrentAnimation(enemy.getAnimations().get("hit"));
            enemy.setHealth(enemy.getHealth() - 10);
            this.currentTexture = owner.getPowerHitTexture();
            tookHit = true;
            if(enemy.getHealth() <= 0) {
                World.setWinner(owner);
                enemy.setDefeated(true);
                KeyEventListener.clearKeys();
                Renderer.getGLWindow().removeKeyListener(Renderer.getGLWindow().getKeyListener(0));
            }
        }
    }

}
