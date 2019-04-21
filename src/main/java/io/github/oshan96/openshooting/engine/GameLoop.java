package io.github.oshan96.openshooting.engine;

import io.github.oshan96.openshooting.graphics.Renderer;
import io.github.oshan96.openshooting.world.World;

/**
 * @author oshan
 */
public class GameLoop extends Thread {

    private int fps_cap = 60;
    private long targetTime = 1000000000 / fps_cap;   //frames per sec

    private int updateCount = 0;
    private long lastUpdateTime = 0;
    private final static int MAX_UPDATES = 5;

    private static GameLoop gameLoop = null;

    private GameLoop() {
        this.setName("Game Loop");
    }

    @Override
    public void run() {

        lastUpdateTime = System.nanoTime();
//        int fps = 0;
//        long lastFPSCheck = System.nanoTime();

        while(this.isAlive()) {

            //poll inputs
            updateCount = 0;
            long curretTime = System.nanoTime();

            //handle the lagging
            while (curretTime - lastUpdateTime >= targetTime) {
                //update world
                World.update();
                updateCount++;
                if (updateCount >= MAX_UPDATES) {
                    break;
                }
                lastUpdateTime += targetTime;
            }

            //render
            Renderer.render();


            long startTime = System.nanoTime();
            long takenTime = System.nanoTime() - startTime;

            //fps capping
            if(takenTime < targetTime){
                try {
                    Thread.sleep((targetTime - takenTime) / 1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public static GameLoop getInstance() {
        if(gameLoop == null) {
            gameLoop = new GameLoop();
        }

        return gameLoop;
    }

    public void setFPS(int fps_cap) {
        this.fps_cap = fps_cap;
    }

    public int getFPS() {
        return this.fps_cap;
    }


}
