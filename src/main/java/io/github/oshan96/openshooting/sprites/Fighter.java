package io.github.oshan96.openshooting.sprites;

/**
 * @author oshan
 */
public interface Fighter {
    void lowPunch();
    void lowKick();
    void highKick();
    void highPunch();
    void block();

    void jump();
    void crouch();
    void turnLeft();
    void turnRight();
}
