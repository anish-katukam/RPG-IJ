package com.company;


import java.awt.*;

//////
////class to animate movement of the character////
//////
public class MoveThreader extends Thread //creates new thread when constructed
{
    private static volatile boolean cancel = false; //cancel all threads
    private volatile int d; //duration of movement
    private volatile Point p; //point to move to
    private volatile Entity e; //entity to move
    private int spriteTracker;

    public MoveThreader(Entity _e, Point _p, int _d) {
        e = _e; // set explicit variables to those passed to the constructor
        p = _p;
        d = _d;
        this.start(); //start the thread
    }

    public static void cancel() {

        cancel = true; //cancel all threads
    }

    public void run() //method called by the threader
    {
        cancel = false;
        long millis = System.currentTimeMillis(); //get start time
        double x_orig = e.getPosition().getX(); // get original x and y coords
        double y_orig = e.getPosition().getY();
        double x_distance = p.getX() - e.getPosition().getX(); //get total distance to move on x and y axis
        double y_distance = p.getY() - e.getPosition().getY();
        double curr_time = System.currentTimeMillis() - millis; // get current time, adjusted for start offset
        spriteTracker = 0;
        while (curr_time < d && !cancel) //while not canceled and not out of time
        {
            curr_time = System.currentTimeMillis() - millis; //update time
            GameLogic.character.set_curr_sprite(spriteTracker);
            e.setPosition((int) (((curr_time / d)) * x_distance + x_orig), (int) (((curr_time / d)) * y_distance + y_orig)); // determine current distance  as a ratio of elapsed time/total time
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e1) {
//                e1.printStackTrace();
//            }
            //e.setPosition((int)(((curr_time/d))*x_distance+x_orig), piecewise_handler.getY((int)(((curr_time/d))*x_distance+x_orig), Starter.getCurrentFrame()));
//            if (spriteTracker == 4) {
//                spriteTracker = 0;
//            } else {
//                spriteTracker++;
//            }
            if ((System.currentTimeMillis() % 10) % 10 + System.currentTimeMillis() % 10 == 11) {
                if (spriteTracker == 4) {
                    spriteTracker = 0;
                } else {
                    spriteTracker++;
                }
            }
        }
    }
}

