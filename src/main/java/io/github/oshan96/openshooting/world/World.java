package io.github.oshan96.openshooting.world;

import io.github.oshan96.openshooting.world.sprites.BasicGameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oshan
 */
public class World {

    private static List<BasicGameObject> gameObjects = null;

    static {
        gameObjects = new ArrayList<>();
    }

    public static void update() {
        for(BasicGameObject object : gameObjects)
            object.update();

    }

    public static void render() {
        for(BasicGameObject object : gameObjects)
            object.render();
    }

    public static void addGameObject(BasicGameObject gameObject) {
        gameObjects.add(gameObject);
    }
}
