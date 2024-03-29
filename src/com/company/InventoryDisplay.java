package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class InventoryDisplay {
    public static JPanel InventoryDisplay() {
        JPanel panel = new JPanel(new GridLayout(5, 1));

        JLayeredPane healthPotionPane = new JLayeredPane();
        JLayeredPane energyPotionPane = new JLayeredPane();
        JLayeredPane bloodlustPotionPane = new JLayeredPane();
        JLayeredPane rejuvenationPotionPane = new JLayeredPane();
        JLayeredPane lifePotionPane = new JLayeredPane();

        try {
            ImageIcon healthPotion = new ImageIcon(ImageIO.read(new File("src/com/company/resources/Potions/Potion Of Health.png")));
            ImageIcon energyPotion = new ImageIcon(ImageIO.read(new File("src/com/company/resources/Potions/Potion Of Energy.png")));
            ImageIcon bloodlustPotion = new ImageIcon(ImageIO.read(new File("src/com/company/resources/Potions/Potion Of Bloodlust.png")));
            ImageIcon rejuvenationPotion = new ImageIcon(ImageIO.read(new File("src/com/company/resources/Potions/Potion Of Rejuvenation.png")));
            ImageIcon lifePotion = new ImageIcon(ImageIO.read(new File("src/com/company/resources/Potions/Potion Of Life.png")));

            JLabel healthPotionImage = new JLabel(healthPotion);
            JLabel energyPotionImage = new JLabel(energyPotion);
            JLabel bloodlustPotionImage = new JLabel(bloodlustPotion);
            JLabel rejuvenationPotionImage = new JLabel(rejuvenationPotion);
            JLabel lifePotionImage = new JLabel(lifePotion);

            healthPotionImage.setBounds(0, 0, 100, 100);
            energyPotionImage.setBounds(0, 0, 100, 100);
            bloodlustPotionImage.setBounds(0, 0, 100, 100);
            rejuvenationPotionImage.setBounds(0, 0, 100, 100);
            lifePotionImage.setBounds(0, 0, 100, 100);

            healthPotionImage.setVisible(true);
            energyPotionImage.setVisible(true);
            bloodlustPotionImage.setVisible(true);
            rejuvenationPotionImage.setVisible(true);
            lifePotionImage.setVisible(true);

            healthPotionPane.add(healthPotionImage, new Integer(0));
            energyPotionPane.add(energyPotionImage, new Integer(0));
            bloodlustPotionPane.add(bloodlustPotionImage, new Integer(0));
            rejuvenationPotionPane.add(rejuvenationPotionImage, new Integer(0));
            lifePotionPane.add(lifePotionImage, new Integer(0));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        JLabel displayNumberOfHealthPotion = new JLabel();
        JLabel displayNumberOfEnergyPotion = new JLabel();
        JLabel displayNumberOfBloodlustPotion = new JLabel();
        JLabel displayNumberOfRejuvenationPotion = new JLabel();
        JLabel displayNumberOfLifePotion = new JLabel();

        displayNumberOfHealthPotion.setBounds(0, 80, 20, 20);
        displayNumberOfEnergyPotion.setBounds(0, 80, 20, 20);
        displayNumberOfBloodlustPotion.setBounds(0, 80, 20, 20);
        displayNumberOfRejuvenationPotion.setBounds(0, 80, 20, 20);
        displayNumberOfLifePotion.setBounds(0, 80, 20, 20);

        int numberOfHealthPotion = 0;
        int numberOfEnergyPotion = 0;
        int numberOfBloodlustPotion = 0;
        int numberOfRejuvenationPotion = 0;
        int numberOfLifePotion = 0;

        Inventory.addItem(new PotionOfBloodlust());
        for (Item s : Inventory.getListOfPotions()) {
            if (s.getName() != null) {
                if (s.getName().equals("Potion of Health")) {
                    numberOfHealthPotion++;
                } else if (s.getName().equals("Potion of Energy")) {
                    numberOfEnergyPotion++;
                } else if (s.getName().equals("Potion of Bloodlust")) {
                    numberOfBloodlustPotion++;
                } else if (s.getName().equals("Potion of Rejuvenation")) {
                    numberOfRejuvenationPotion++;
                } else if (s.getName().equals("Potion of Life")) {
                    numberOfLifePotion++;
                }
            }
        }

        displayNumberOfHealthPotion.setText("X" + Integer.toString(numberOfHealthPotion));
        displayNumberOfEnergyPotion.setText("X" + Integer.toString(numberOfEnergyPotion));
        displayNumberOfBloodlustPotion.setText("X" + Integer.toString(numberOfBloodlustPotion));
        displayNumberOfRejuvenationPotion.setText("X" + Integer.toString(numberOfRejuvenationPotion));
        displayNumberOfLifePotion.setText("X" + Integer.toString(numberOfLifePotion));

        displayNumberOfHealthPotion.setVisible(true);
        displayNumberOfEnergyPotion.setVisible(true);
        displayNumberOfBloodlustPotion.setVisible(true);
        displayNumberOfRejuvenationPotion.setVisible(true);
        displayNumberOfLifePotion.setVisible(true);

        healthPotionPane.add(displayNumberOfHealthPotion, new Integer(1));
        energyPotionPane.add(displayNumberOfEnergyPotion, new Integer(1));
        bloodlustPotionPane.add(displayNumberOfBloodlustPotion, new Integer(1));
        rejuvenationPotionPane.add(displayNumberOfRejuvenationPotion, new Integer(1));
        lifePotionPane.add(displayNumberOfLifePotion, new Integer(1));

        healthPotionPane.setVisible(true);
        energyPotionPane.setVisible(true);
        bloodlustPotionPane.setVisible(true);
        rejuvenationPotionPane.setVisible(true);
        lifePotionPane.setVisible(true);

        panel.add(healthPotionPane);
        panel.add(energyPotionPane);
        panel.add(bloodlustPotionPane);
        panel.add(rejuvenationPotionPane);
        panel.add(lifePotionPane);

        panel.add(healthPotionPane);
        panel.add(energyPotionPane);
        panel.add(bloodlustPotionPane);
        panel.add(rejuvenationPotionPane);
        panel.add(lifePotionPane);

        panel.setVisible(true);

        return panel;
    }
}
