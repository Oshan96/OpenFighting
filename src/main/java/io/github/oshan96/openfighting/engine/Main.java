package io.github.oshan96.openfighting.engine;

import io.github.oshan96.openfighting.graphics.Renderer;

/**
 * @author oshan
 */
public class Main {
    public static void main(String[] args) {
        Renderer.init();
        GameLoop.getInstance().start();
    }
}
