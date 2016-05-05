package com.company;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

//TODO: Choose between tracks, set up short clips of sound effects

public class Music {
    static MediaPlayer mediaPlayer;

    public static void playTrack() {
        Media darkFlute = new Media(new File("src/com/company/resources/Music/darkflute.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(darkFlute);
        mediaPlayer.play();
    }
}
