package io.github.oshan96.openshooting.world;

import io.github.oshan96.openshooting.graphics.EventListenerImpl;
import io.github.oshan96.openshooting.graphics.Graphics;
import io.github.oshan96.openshooting.graphics.Renderer;
import io.github.oshan96.openshooting.world.sprites.BasicGameObject;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author oshan
 */
public class World {

    private static List<BasicGameObject> gameObjects = null;

    static {
        gameObjects = new CopyOnWriteArrayList<>();
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
        Graphics.createObjectTexture(EventListenerImpl.background,0,0,Renderer.tileSize ,Renderer.vTileSize);
        for(BasicGameObject object : gameObjects)
            object.render();
    }

    /**
     * adds the game-object to the world
     *
     * @param gameObject GameObject to be added to the scene
     */
    public static void addGameObject(BasicGameObject gameObject) {
        gameObjects.add(gameObject);
    }

    /**
     * removes a game-object from the worlds
     *
     * @param gameObject GameObject which needs to be removed from the scene
     */
    public static void removeGameObject(BasicGameObject gameObject) {
        gameObjects.remove(gameObject);
    }
}
