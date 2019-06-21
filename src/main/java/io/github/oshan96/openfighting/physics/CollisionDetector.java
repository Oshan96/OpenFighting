package io.github.oshan96.openfighting.physics;

import java.util.List;
import java.util.ArrayList;

/**
 * @author oshan
 */
public class CollisionDetector {

    private List<Collidable> collidables = new ArrayList<>();

    public void detectCollisions() {
        for (Collidable col : collidables) {
            col.collided();
        }
    }

    public void addCollidable(Collidable collidable) {
        collidables.add(collidable);
    }

    public void removeCollidable(Collidable collidable) {
        collidables.remove(collidable);
    }

}
