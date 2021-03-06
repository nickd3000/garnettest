package com.physmo.garnettest;

import com.physmo.garnet.GameContainer;
import com.physmo.garnet.Garnet;
import com.physmo.garnet.regularfont.RegularFont;

public class ContainerRegularFontSample implements GameContainer {

    public static final String fontFileName = "/Users/nick/Dev/java/garnettest/src/main/resources/8x8Font.png";
    static int c = 0;
    RegularFont regularFont;

    @Override
    public void init(Garnet garnet) {
        regularFont = new RegularFont(fontFileName, 8, 8);
    }

    @Override
    public void tick(double delta) {
    }

    @Override
    public void draw() {
        //regularFont.renderChar((char)(Math.random()*250.0),20,20,2);
        regularFont.renderChar('A', 20, 20, 1);
        regularFont.drawText("Abcdefg 12345", 20, 60, 2);
        regularFont.drawText("The quick brown fox", 20, 80, 2);
        regularFont.drawText("Regular font sample", 20, 100, 4);
        regularFont.render();
    }

}
