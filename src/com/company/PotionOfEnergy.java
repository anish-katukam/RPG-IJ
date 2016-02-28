package com.company;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PotionOfEnergy extends Potion {
    public PotionOfEnergy() {
        super();
        this.name = "Potion of Energy";
        this.desc = "A yellow, light concoction. Invigorating and mildly sweet.";
        this.energy = 10;
        try {
            this.picture = ImageIO.read(new File("Resources/Potions/Energy Potion.png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
