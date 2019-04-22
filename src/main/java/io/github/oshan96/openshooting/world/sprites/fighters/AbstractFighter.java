package io.github.oshan96.openshooting.world.sprites.fighters;

import com.jogamp.opengl.util.texture.Texture;
import io.github.oshan96.openshooting.resources.SpriteSheet;
import io.github.oshan96.openshooting.world.sprites.BasicGameObject;

import java.util.List;

/**
 * @author oshan
 */
public abstract class AbstractFighter extends BasicGameObject implements Fighter {
    /**
     * attackSpeed determines the time delay between two hits
     */
    protected double attackSpeed;

    protected List<Texture> sprites = null;
    protected Texture initialStance = null;


    public AbstractFighter(float x, float y, int height, int width, String fighterName) {
        super(x, y, height, width);
        sprites = SpriteSheet.getInstance()
                .loadSpriteSheet("/images/sprites/"+fighterName+".png")
                .getSprites(height,width);

        initialStance = sprites.get(0);
        currentTexture = initialStance;

    }

    public AbstractFighter(float x, float y, int height, int width, String fighterName, double attackSpeed) {
        this(x, y, height, width, fighterName);
        this.attackSpeed = attackSpeed;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
}
