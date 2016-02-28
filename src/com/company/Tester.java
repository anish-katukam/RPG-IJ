package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tester {
    static final JFrame frame = new JFrame("Swords & Sworcery");
    static final OurGraphics graphics = new OurGraphics();
    static private int currentFrame = 0;

    public static void main(String Args[]) {

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/com/company/resources/Splashes/OpeningSplash.jpg"));
        } catch (IOException e) {
        }

        frame.setSize((int) Util.screen_size.getWidth(), (int) Util.screen_size.getHeight());

        // //        final JFXPanel fxPanel = new JFXPanel();
        //         frame.add(fxPanel);
        //         initFX(fxPanel);
        //         frame.setDefaultfullScreenButtonOperation(JFrame.EXIT_ON_fullScreenButton);

        GameLogic.character.setSprites(new String[]{"src/com/company/resources/Assets/character/front.PNG"});
        GameLogic.character.setPosition(100, 100);
        GameLogic.character.set_curr_sprite(0);

        //e.moveTo(new Point(500,500), 5000);
        graphics.addEntity(GameLogic.character);

        frame.add(graphics.getGraphics(0));
        frame.setUndecorated(true);

        frame.setVisible(true);

    }

    //   private static void initFX(JFXPanel fxPanel) {
    //   }
    public static int getCurrentFrame() {
        return currentFrame;
    }

    public static void setCurrentFrame(int f) {
        currentFrame = f;
    }
}

