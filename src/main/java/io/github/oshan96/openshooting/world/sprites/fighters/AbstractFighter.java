package io.github.oshan96.openshooting.world.sprites.fighters;

import com.jogamp.opengl.util.texture.Texture;
import io.github.oshan96.openshooting.engine.GameLoop;
import io.github.oshan96.openshooting.graphics.Animation;
import io.github.oshan96.openshooting.graphics.Renderer;
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
     * movementSpeed determines the time delay between two hits
     */
    protected float movementSpeed = 2.0f;
    protected boolean isFacingLeft = true;

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

    public AbstractFighter(float x, float y, int height, int width, String fighterName, float movementSpeed) {
        this(x, y, height, width, fighterName);
        this.movementSpeed = movementSpeed;
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(float movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public boolean isFacingLeft() {
        return isFacingLeft;
    }

    public void setFacingLeft(boolean facingLeft) {
        isFacingLeft = facingLeft;
    }

    @Override
    public void move(boolean isMovingRight) {
        float xIn = 0;
        if(isFacingLeft) {
            if(isMovingRight) {
                xIn++;
            } else {
                xIn--;
            }
        } else {
            if(isMovingRight) {
                xIn++;
            } else {
                xIn--;
            }
        }

        x += xIn * movementSpeed * GameLoop.getDelta();

        if(x>Renderer.tileSize / 2 - 0.5f) {
            x = Renderer.tileSize / 2 - 0.5f;
        } else if(x<-Renderer.tileSize / 2 + 0.5f) {
            x = -Renderer.tileSize / 2 + 0.5f;
        }
    }
}
