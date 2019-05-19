package io.github.oshan96.openfighting.resources;

import io.github.oshan96.openfighting.graphics.Renderer;

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
