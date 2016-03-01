package com.company;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PotionOfHealth extends Potion {
    public PotionOfHealth() {
        super();
        this.name = "Potion of Health";
        this.desc = "A healing concoction. Red and thick, much like blood.";
        this.health = 10;
        try {
            this.picture = ImageIO.read(new File("src/com/company/resources/Potions/Potion Of Health.png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

