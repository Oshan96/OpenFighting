package io.github.oshan96.openshooting.graphics;

import com.jogamp.opengl.util.texture.Texture;
import io.github.oshan96.openshooting.world.sprites.fighters.AbstractFighter;

import java.util.List;

/**
 * @author oshan
 */
public class ActionAnimation extends Animation {

    private AbstractFighter registeredFighter = null;

    public ActionAnimation(AbstractFighter registeredFighter) {
        this.registeredFighter = registeredFighter;
    }

    public ActionAnimation(List<Texture> sprites, AbstractFighter registeredFighter) {
        super(sprites);
        this.registeredFighter = registeredFighter;
    }

    @Override
    public void play() {
        long currentTime = System.nanoTime();

        if(currentTime > lastFrameTime + (1000000000/(this.getSprites().size() * registeredFighter.getAttackSpeed()))) {
            currentFrame++;

            if(currentFrame >= sprites.size()) {
                return;
            }

            lastFrameTime = currentTime;
        }
    }
}
