package io.github.oshan96.openshooting.resources;

import io.github.oshan96.openshooting.graphics.Renderer;

/**
 * @author oshan
 */
public class UnitsConverter {
    public static float convertWidth(float width) {
        return width / Renderer.tileSize;
    }

    public static float convertHeight(float height) {
        return height / Renderer.vTileSize;
    }

}
