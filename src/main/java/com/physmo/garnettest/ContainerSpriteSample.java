package com.physmo.garnettest;

import com.physmo.garnet.GameContainer;
import com.physmo.garnet.Garnet;
import com.physmo.garnet.Texture;
import com.physmo.garnet.spritebatch.Sprite2D;
import com.physmo.garnet.spritebatch.SpriteBatch;

public class ContainerSpriteSample implements GameContainer {

    private static String fileName = "/Users/nick/Dev/java/garnettest/src/main/resources/space.PNG";
    private static float angle = 0;
    private Texture texture;
    private SpriteBatch spriteBatch;

    double movementX;

    public static void main(String[] args) {
        Garnet garnet = new Garnet(new ContainerSpriteSample(), 640, 480);
        garnet.init();
        garnet.run();
    }

    @Override
    public void init(Garnet garnet) {


        texture = Texture.loadTexture(fileName);
        spriteBatch = new SpriteBatch(texture);

        System.out.println("adding keyboard callback from game container");

        garnet.addKeyboardCallback((key, scancode, action, mods) -> {
            System.out.println("keyboard handler" + scancode + "  " + action);
        });

    }

    @Override
    public void tick(double delta) {
        angle += delta * 100f;
        movementX += delta * 0.2;
        while (movementX>1.0f) { movementX-=1.0f; }
    }

    @Override
    public void draw() {


        drawTestSpriteBuilder();

        spriteBatch.render();
        spriteBatch.clear();

    }

    private void drawTestSpriteBuilder() {
        int space = 30;
        int x = 20;

        // Moving
        spriteBatch.add(Sprite2D.build(20+(int)(movementX*300), 20+40, 16, 16, 0, 0, 16, 16));

        // Unscaled
        spriteBatch.add(Sprite2D.build(x, 20, 16, 16, 0, 0, 16, 16));
        x += space;

        // Coloured
        spriteBatch.add(Sprite2D.build(x, 20, 16, 16, 0, 0, 16, 16)
                .addColor(1.0f, 0.5f, 0.25f));
        x += space;

        // Rotated
        spriteBatch.add(Sprite2D.build(x, 20, 16, 16, 0, 0, 16, 16)
                .addAngle(angle));
        x += space;

        // Scaled
        spriteBatch.add(Sprite2D.build(x, 20, 16 * 2, 16 * 2, 0, 0, 16, 16));
        x += space * 2;

        // Tile setter
        spriteBatch.add(Sprite2D.build(x, 20, 16 * 5, 16 * 5)
                .setTile(6, 0, 16)
                .addColor(0.25f, 0.5f, 1.0f));

    }


}
