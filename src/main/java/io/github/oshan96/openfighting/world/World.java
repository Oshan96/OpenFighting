package io.github.oshan96.openfighting.world;

import io.github.oshan96.openfighting.graphics.EventListenerImpl;
import io.github.oshan96.openfighting.graphics.Graphics;
import io.github.oshan96.openfighting.graphics.Renderer;
import io.github.oshan96.openfighting.physics.Collidable;
import io.github.oshan96.openfighting.physics.CollisionDetector;
import io.github.oshan96.openfighting.world.sprites.BasicGameObject;
import io.github.oshan96.openfighting.world.sprites.fighters.impl.FighterBee;
import io.github.oshan96.openfighting.world.sprites.fighters.impl.FighterKree;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author oshan
 */
public class World {

    private static List<BasicGameObject> gameObjects = null;
    private static CollisionDetector collisionDetector = null;

    static {
        gameObjects = new CopyOnWriteArrayList<>();
        collisionDetector = new CollisionDetector();

        FighterKree playerOne = new FighterKree(0,-4.7f,64,64, 0, 0);
        FighterBee playerTwo = new FighterBee(2.5f,-4.7f,64,64, 0, 0);
        World.addGameObject(playerOne);
        World.addGameObject(playerTwo);
    }

    /**
     * updates all the game-objects currently in the scene by calling their "update()" methods
     */
    public static void update() {
        for(BasicGameObject object : gameObjects)
            object.update();
    }

    /**
     * calls the "render()" method of all game-objects
     */
    public static void render() {
        Graphics.createObjectTexture(EventListenerImpl.background,0,0,Renderer.tileSize ,Renderer.vTileSize,0);
        for(BasicGameObject object : gameObjects)
            object.render();
    }

    /**
     * calls "collided()" method of all collidable game-objects
     */
    public static void detectCollision() {
        collisionDetector.detectCollisions();
    }

    /**
     * adds the game-object to the world
     *
     * @param gameObject GameObject to be added to the scene
     */
    public static void addGameObject(BasicGameObject gameObject) {
        gameObjects.add(gameObject);
        if(gameObject instanceof Collidable) {
            collisionDetector.addCollidable(gameObject);
        }
    }

    /**
     * removes a game-object from the worlds
     *
     * @param gameObject GameObject which needs to be removed from the scene
     */
    public static void removeGameObject(BasicGameObject gameObject) {
        gameObjects.remove(gameObject);
        collisionDetector.removeCollidable(gameObject);
    }
}
