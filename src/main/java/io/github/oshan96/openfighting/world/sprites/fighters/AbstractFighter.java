package io.github.oshan96.openfighting.world.sprites.fighters;

import com.jogamp.opengl.util.texture.Texture;
import io.github.oshan96.openfighting.engine.GameLoop;
import io.github.oshan96.openfighting.graphics.ActionAnimation;
import io.github.oshan96.openfighting.graphics.Animation;
import io.github.oshan96.openfighting.graphics.Renderer;
import io.github.oshan96.openfighting.resources.SpriteSheet;
import io.github.oshan96.openfighting.world.sprites.BasicGameObject;

import java.util.*;

/**
 * @author oshan
 */
public abstract class AbstractFighter extends BasicGameObject implements Fighter {

    protected float movementSpeed = 2.0f;
    protected float attackSpeed = 1.0f;
    protected int health = 100;
    protected long lastPowerTime = 0;

    protected AbstractFighter enemy = null;

    protected boolean isFacingLeft = true;

    protected boolean isDefeated = false;

    protected final float charHeight = 4.0f;
    protected final float charWidth = 4.0f;

    protected List<Texture> sprites = null;
    protected Texture initialStance = null;
    protected Texture powerTexture = null;
    protected Texture powerHitTexture = null;

    protected Map<String,Animation> animations = null;

    protected Animation currentAnimation = null;


    public AbstractFighter(float x, float y, int width, int height, String fighterName) {
        this(x,y,width,height,fighterName,0,0);
    }

    /**
     * @param x             horizontal index position (in game units)
     * @param y             vertical index position (in game units)
     * @param width         width of the sprite
     * @param height        height of the sprite
     * @param fighterName   String name of the sprite-sheet of this character
     * @param offsetX       will be reduced from the width of the sprite (if the sprite has blank surrounding space)
     * @param offsetY       will be reduced from the height of the sprite (if the sprite has blank surrounding space)
     */
    public AbstractFighter(float x, float y, int width, int height, String fighterName, int offsetX, int offsetY) {
        super(x, y, width-(offsetX*2), height-(offsetY*2));
        sprites = SpriteSheet.getInstance()
                .loadSpriteSheet("/images/sprites/"+fighterName+".png")
                .getSprites(width,height,offsetX,offsetY,7,18);

        initialStance = sprites.get(0);
        currentTexture = initialStance;

        initActions(fighterName,offsetX,offsetY);
    }

    public AbstractFighter(float x, float y, int width, int height, String fighterName, float movementSpeed) {
        this(x, y, width, height, fighterName);
        this.movementSpeed = movementSpeed;
    }

    /**
     * Creates the movement animations for this character and adds them to animations map
     */
    private void initActions(String name, int offsetX, int offsetY) {
        animations = new HashMap<>();

        //idle animation
        Animation testAnime = new Animation();

        //test animation idle-state
        List<Texture> textures = SpriteSheet
                .getInstance()
                .loadSpriteSheet("/images/sprites/"+name+"/idle/idle_state_"+name+"_sheet.png")
                .getSprites(width,height,offsetX,offsetY,1,5);

        testAnime.setSprites(textures);
        testAnime.setFps(20);

        animations.put("idle",testAnime);
        currentAnimation = testAnime;
        /////////////////

        //defeated animation
        Animation defeatAnime = new Animation();
        List<Texture> defTextures = SpriteSheet
                .getInstance()
                .loadSpriteSheet("/images/sprites/"+name+"/defeat/defeat_state_"+name+"_sheet.png")
                .getSprites(width,height,offsetX,offsetY,1,5);

        defeatAnime.setSprites(defTextures);
        defeatAnime.setFps(20);

        animations.put("defeat",defeatAnime);
        /////

        //shooting animation
        Animation shootingAnime = new ActionAnimation();
        List<Texture> shootTextures = SpriteSheet
                .getInstance()
                .loadSpriteSheet("/images/sprites/"+name+"/shoot/shoot_state_"+name+"_sheet.png")
                .getSprites(width,height,offsetX,offsetY,1,5);

        shootingAnime.setSprites(shootTextures);
        shootingAnime.setFps(16);
        ((ActionAnimation) shootingAnime).setRegisteredFighter(this);

        animations.put("shoot",shootingAnime);
        /////

        //hit animation
        Animation hitAnime = new ActionAnimation();
        List<Texture> hitTextures = SpriteSheet
                .getInstance()
                .loadSpriteSheet("/images/sprites/"+name+"/hit/hit_state_"+name+"_sheet.png")
                .getSprites(width,height,offsetX,offsetY,1,5);

        hitAnime.setSprites(hitTextures);
        hitAnime.setFps(10);
        ((ActionAnimation) hitAnime).setRegisteredFighter(this);

        animations.put("hit",hitAnime);
        /////

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

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(float attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDefeated(boolean defeat) {
        isDefeated = defeat;
        if(isDefeated) {
            this.currentAnimation = animations.get("defeat");
        }
    }

    public Texture getPowerHitTexture() {
        return powerHitTexture;
    }

    public void setPowerHitTexture(Texture powerHitTexture) {
        this.powerHitTexture = powerHitTexture;
    }

    public void setCurrentAnimation(Animation currentAnimation) {
        this.currentAnimation = currentAnimation;
    }

    public Map<String, Animation> getAnimations() {
        return animations;
    }

    public boolean isDefeated() {
        return isDefeated;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public AbstractFighter getEnemy() {
        return enemy;
    }

    public void setEnemy(AbstractFighter enemy) {
        this.enemy = enemy;
    }

    @Override
    public void move(boolean isMovingRight) {
        float xIn = 0;

        if(isMovingRight) {
            xIn++;
        } else {
            xIn--;
        }

        x += xIn * movementSpeed * GameLoop.getDelta();

        if(x>Renderer.tileSize / 2 - 0.5f) {
            x = Renderer.tileSize / 2 - 0.5f;
        } else if(x<-Renderer.tileSize / 2 + 0.5f) {
            x = -Renderer.tileSize / 2 + 0.5f;
        }
    }

    @Override
    public void collided() {
        super.collided();
        if(x<-(Renderer.tileSize / 2 + 0.5f)) {
            x = (Renderer.tileSize / 2 + 0.5f);
        } else if (x> (Renderer.tileSize / 2 - 0.5f)) {
            x = (Renderer.tileSize / 2 - 0.5f);
        }else if((x+charWidth/3f) - (enemy.getX()) > 0 && !isFacingLeft ) {
            x = enemy.getX()-enemy.charWidth/3;
        }else if((x-charWidth/3f) - (enemy.getX()) < 0 && isFacingLeft ) {
            x = enemy.getX()+enemy.charWidth/3;
        }

        if(y< -(Renderer.vTileSize)/2 + 1.5f) {
            y = -Renderer.vTileSize / 2 + 1.5f;
        }
        else if (y > - (Renderer.vTileSize)/2 + 2.8f) {
            y = -Renderer.vTileSize / 2 + 2.8f;
        }
    }

}
