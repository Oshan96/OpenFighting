package io.github.oshan96.openshooting.engine;

import io.github.oshan96.openshooting.graphics.Renderer;

/**
 * @author oshan
 */
public class Main {
    public static void main(String[] args) {
        Renderer.init();
        GameLoop.getInstance().start();
    }
}
