package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Write a description of class Graphics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OurGraphics {
    // instance variables
    final JLayeredPane mainPane; //the layered pane that all actions take place on
    //final JLabel menuPanel;
    final JPanel menuPullout;
    final JPanel inventoryPanel;
    final JButton inventory;
    final JButton stats;
    final JButton save;
    final JButton exit;
    final JButton back;
    final JButton menuBack;
    final JButton menuMouseOverButton;
    final JPanel menuOptionDisplay;


    ImageDrawer openingImage;
    ImageDrawer dimBackground;

    public OurGraphics() {

        mainPane = new JLayeredPane(); //Constructs a new instance of the JLayeredPane class with identifier mainPane

        menuOptionDisplay = new JPanel();//Constructs a new instance of the JPanel class with identifier menuOptionDisplay

        menuMouseOverButton = new JButton(new ImageIcon("src/com/company/resources/Assets/menuicon.png"));
        menuMouseOverButton.setOpaque(false); //Invokes the setOpaque method with explicit parameter of false on the menuButton object
        menuMouseOverButton.setContentAreaFilled(false);//Invokes the setContentAreaFilled method with explicit parameter of false on the menuButton object
        menuMouseOverButton.setBorderPainted(false);//Invokes the setBorderPainted method with explicit parameter of false on the menuButton object
        menuMouseOverButton.setBounds((int) Util.screen_size.getWidth() - 50, 0, 50, 50);

        openingImage = new ImageDrawer(0); //Constructs a new instance of the ImageDrawer class with identifier openingImage and explicit parameter of 0 to retrieve the first image
        openingImage.setBounds(0, 0, (int) Util.screen_size.getWidth(), (int) Util.screen_size.getHeight()); //Invokes the setBounds method on the openingImage object to make cover the whole area of any screen

        dimBackground = new ImageDrawer(4);
        dimBackground.setBounds(0, 0, (int) Util.screen_size.getWidth(), (int) Util.screen_size.getHeight());


        //This begins the creation and modification of the menuPullout JPanel. The menuPullout is the panel that opens when the menu button is moused over.
        //TODO: Animate sliding out, Make transparent border and body, Properly resize icons (found in resources folder) as they're jaggy now, Set proper border
        menuPullout = new JPanel();
        menuPullout.setBounds((int) Util.screen_size.getWidth() - 570, 0, 570, 100);

        inventory = new JButton(new ImageIcon("src/com/company/resources/Assets/inventory.png")); //Constructs a new instance of the JButton class with identifier inventory with explicit parameter of a string
        stats = new JButton(new ImageIcon("src/com/company/resources/Assets/stats.png")); //Constructs a new instance of the JButton class with identifier stats with explicit parameter of a string
        save = new JButton(new ImageIcon("src/com/company/resources/Assets/save.png")); //Constructs a new instance of the JButton class with identifier save with explicit para meter of a string
        exit = new JButton(new ImageIcon("src/com/company/resources/Assets/exit.png")); //Constructs a new instance of the JButton class with identifier exit with explicit parameter of a string
        back = new JButton(new ImageIcon("src/com/company/resources/Assets/backicon.png")); //Constructs a new instance of the JButton class with identifier back with explicit parameter of a new empty instance of the ImageIcon class


        menuBack = new JButton(new ImageIcon("src/com/company/resources/Assets/backarrowfixed.png"));
        menuBack.setBorderPainted(false);
        menuBack.setFocusPainted(false);
        menuBack.setContentAreaFilled(false);
        menuBack.setBounds(25, 25, 75, 75);

        inventory.setBorderPainted(false);
        inventory.setFocusPainted(false);
        inventory.setContentAreaFilled(false);

        stats.setBorderPainted(false);
        stats.setFocusPainted(false);
        stats.setContentAreaFilled(false);

        save.setBorderPainted(false);
        save.setFocusPainted(false);
        save.setContentAreaFilled(false);

        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        exit.setContentAreaFilled(false);

        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);

        menuPullout.add(inventory);
        menuPullout.add(stats);
        menuPullout.add(save);
        menuPullout.add(back);
        menuPullout.add(exit);
        //This ends the creation and modification of the menuPullout panel.

        //This begins the creation and modification of the inventory panel. This is the panel that allows you to equip items and see your inventory.
        inventoryPanel = new JPanel();


        class ButtonListener implements ActionListener //An inner class to respond to button presses
        {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == exit) { //If the source of the button press is the exit button

                    System.exit(0); //Invokes the exit method on the System class with explicit parameter 0 to exit the game
                }
                if (e.getSource() == back) { //If the source of the button press is the back button
                    mainPane.remove(mainPane.getIndexOf(menuPullout)); //Invokes the remove method onto the mainPane object with explicit parameter of the returned value from the invocation of the getIndexOf method on the mainPane object with explicit paramter of the menuPanel object
                    Starter.frame.repaint(); //Invokes the repaint method on the final variable of the Started class in order to repaint the main frame
                    mainPane.add(menuMouseOverButton, new Integer(2));

                }
                if (e.getSource() == inventory) { //If the source of the button press is the inventory button
                    dimScreen();
                }
                if (e.getSource() == stats) { //If the source of the button press is the inventory button
                    dimScreen();
                }
                if (e.getSource() == menuBack) {
                    brightenScreen();
                }
            }
        }


        class MainPlayerMover implements MouseListener { //An inner class to respond to mouse events

            public void mouseClicked(MouseEvent e) {


                MoveThreader.cancel(); //Sid please comment code this
                //GameLogic.character.moveTo(new Point((int) Util.screenPointAdjust(e.getPoint()).getX(), PiecewiseHandler.getY((int) Util.screenPointAdjust(e.getPoint()).getX(), Starter.getCurrentFrame())), 500);
                GameLogic.character.moveTo(new Point(e.getX(), e.getY()), 500);//Update this to work with the proper piecewise handler.
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        }

        class MenuButtonListener implements MouseListener { //to manage mousing over the corner and opening the options
            public void mouseClicked(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                //Should open up the options pane and spawn and manage the buttons inside said pane
                mainPane.remove(menuMouseOverButton);
                mainPane.add(menuPullout, new Integer(2));
            }

            public void mouseExited(MouseEvent e) {

            }
        }

        class AutoCloser implements MouseListener { //to manage mousing over the corner and opening the options
            public void mouseClicked(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {
                mainPane.add(menuMouseOverButton, new Integer(2));
            }
        }


        Starter.frame.addMouseListener(new MainPlayerMover()); //Invokes the addMouseListener method onto the the final object frame from the starter class with the explicit parameter of a new instance of the inner MainPlayerMover class

        menuPullout.addMouseListener(new AutoCloser());
        menuMouseOverButton.addMouseListener(new MenuButtonListener());

        stats.addActionListener(new ButtonListener());
        back.addActionListener(new ButtonListener()); //Invokes the addActionListener method onto the back object with the explicit parameter of a new instance of the inner ButtonListener class
        inventory.addActionListener(new ButtonListener());
        exit.addActionListener(new ButtonListener()); //Invokes the addActionListener method onto the exit object with the explicit parameter of a new instance of the inner ButtonListener class
        menuBack.addActionListener(new ButtonListener());

        SaveGame gameSave = new SaveGame(save, Inventory.getListOfPotions()); //Constructs a new instance of the SaveGame class with identifier gameSave and explicit parameters of the save JButton object, and the list of potions from the Inventory class
        gameSave.saveGame(); //Invokes the saveGame method onto the gameSave object

    }

    private void dimScreen() {
        mainPane.add(dimBackground, new Integer(2));
        mainPane.remove(mainPane.getIndexOf(menuPullout));
        mainPane.remove(mainPane.getIndexOf(menuMouseOverButton));
        mainPane.add(menuBack, new Integer(3));
    }

    private void brightenScreen() {
        mainPane.remove(mainPane.getIndexOf(dimBackground));
        mainPane.remove(mainPane.getIndexOf(menuBack));
        Starter.frame.repaint();
        mainPane.add(menuMouseOverButton, new Integer(2));
    }

    public void addEntity(Entity e) {
        //Sid please comment code this
        e.setBounds(0, 0, (int) Util.screen_size.getWidth(), (int) Util.screen_size.getHeight());
        mainPane.add(e, new Integer(1));
    }

    public JLayeredPane getGraphics(int chapterNum) //Given the explicit variable of the chapter number, will return the layered pane with the necessary elements
    {


        switch (chapterNum) {
            //To dim the background, use the dullBackground image given by the ImageDrawer class.

            case 0: //If it is the opening chapter
            {
                mainPane.add(menuMouseOverButton, new Integer(2));
                mainPane.add(openingImage, new Integer(0)); //The opening image is added to the bottom layer;
                return mainPane; //The pane is returned

            }
            default: {
                return null;
            }
        }

    }


}
