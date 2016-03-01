package com.company;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PotionOfRejuvenation extends Potion {
    public PotionOfRejuvenation() {
        super();
        this.name = "Potion of Rejuvenation";
        this.desc = "A pink combination of other potions, it swirls and shakes itself, seeming conflicted.";
        this.health = 10;
        this.energy = 10;
        this.bloodlust = 2;
        try {
            this.picture = ImageIO.read(new File("src/com/company/resources/Potions/Potion Of Rejuvenation.png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

