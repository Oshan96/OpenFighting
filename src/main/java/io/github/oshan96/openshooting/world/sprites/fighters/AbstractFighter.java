package io.github.oshan96.openshooting.world.sprites.fighters;

import com.jogamp.opengl.util.texture.Texture;
import io.github.oshan96.openshooting.graphics.Animation;
import io.github.oshan96.openshooting.resources.SpriteSheet;
import io.github.oshan96.openshooting.world.sprites.BasicGameObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    protected Map<String,Animation> animations = null;


    public AbstractFighter(float x, float y, int height, int width, String fighterName) {
        super(x, y, height, width);
        sprites = SpriteSheet.getInstance()
                .loadSpriteSheet("/images/sprites/"+fighterName+".png")
                .getSprites(height,width);

        initialStance = sprites.get(0);
        currentTexture = initialStance;

        initActions();
    }

    private void initActions() {
        animations = new HashMap<>();

        //a test animation
        Animation testAnime = new Animation();
        Texture[] textures = new Texture[]{
                sprites.get(0),
                sprites.get(1),
                sprites.get(2),
                sprites.get(3)
        };

        testAnime.setSprites(textures);

        animations.put("test",testAnime);
        /////////////////
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
