package com.company;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;

//TODO: Choose between tracks, set up short clips of sound effects

public class Music {

    static MediaPlayer mediaPlayer;
    static MediaPlayer inventoryPlayer;

    static ArrayList<Media> ambientTracks;
    static ArrayList<Media> battleTracks;

    static Media darkFlute;
    static Media loneStar;
    static Media doomSock;
    static Media thePrettiestWeed;
    static Media theCloud;
    static Media underATree;
    static Media theMaelstrom;
    static Media theBalladOfTheSpaceBabies;
    static Media unknowableGeometry;
    static Media bonesMcCoy;
    static Media odeToARoom;
    static Media thePrettiestRemix;
    static Media theWhirlingInfinite;
    static Media littleFurnace;
    static Media cabinMusic;
    static Media battles1;
    static Media battles2;
    static Media com64;
    static Media mushrooms;
    static Media deathToEveryone;
    static Media confrontingTheWolf;
    static Media upAMountain;
    static Media activatingTrigons;
    static Media howWeGetOld;
    static Media andWeGotOlder;

    public static void fetchTracks() {
        darkFlute = new Media(new File("src/com/company/resources/Music/DarkFlute.mp3").toURI().toString()); //ambient music
        loneStar = new Media(new File("src/com/company/resources/Music/LoneStar.mp3").toURI().toString()); //ambient music
        doomSock = new Media(new File("src/com/company/resources/Music/DoomSock.mp3").toURI().toString()); //death music
        thePrettiestWeed = new Media(new File("src/com/company/resources/Music/ThePrettiestWeed.mp3").toURI().toString()); //outro music
        theCloud = new Media(new File("src/com/company/resources/Music/TheCloud.mp3").toURI().toString()); //inventory music
        underATree = new Media(new File("src/com/company/resources/Music/UnderATree.mp3").toURI().toString()); //ambient music
        theMaelstrom = new Media(new File("src/com/company/resources/Music/TheMaelstrom.mp3").toURI().toString()); //ambient music
        theBalladOfTheSpaceBabies = new Media(new File("src/com/company/resources/Music/TheBalladOfTheSpaceBabies.mp3").toURI().toString()); //ambient music
        unknowableGeometry = new Media(new File("src/com/company/resources/Music/UnknowableGeometry.mp3").toURI().toString());
        bonesMcCoy = new Media(new File("src/com/company/resources/Music/BonesMcCoy.mp3").toURI().toString()); //ambient music
        odeToARoom = new Media(new File("src/com/company/resources/Music/OdeToARoom.mp3").toURI().toString()); //ambient music
        thePrettiestRemix = new Media(new File("src/com/company/resources/Music/ThePrettiestRemix.mp3").toURI().toString()); //intro theme
        theWhirlingInfinite = new Media(new File("src/com/company/resources/Music/TheWhirlingInfinite.mp3").toURI().toString());
        littleFurnace = new Media(new File("src/com/company/resources/Music/LittleFurnace.mp3").toURI().toString()); //ambient music
        cabinMusic = new Media(new File("src/com/company/resources/Music/CabinMusic.mp3").toURI().toString()); //ambient music
        battles1 = new Media(new File("src/com/company/resources/Music/Battles1.mp3").toURI().toString()); //battle music
        battles2 = new Media(new File("src/com/company/resources/Music/Battles2.mp3").toURI().toString()); //battle music
        com64 = new Media(new File("src/com/company/resources/Music/Com64.mp3").toURI().toString()); //ambient music
        mushrooms = new Media(new File("src/com/company/resources/Music/Mushrooms.mp3").toURI().toString());
        deathToEveryone = new Media(new File("src/com/company/resources/Music/DeathToEveryone.mp3").toURI().toString());
        confrontingTheWolf = new Media(new File("src/com/company/resources/Music/ConfrontingTheWolf.mp3").toURI().toString()); //battle music
        upAMountain = new Media(new File("src/com/company/resources/Music/UpAMountain.mp3").toURI().toString()); //ambient music
        activatingTrigons = new Media(new File("src/com/company/resources/Music/ActivatingTrigons.mp3").toURI().toString());
        howWeGetOld = new Media(new File("src/com/company/resources/Music/HowWeGetOld.mp3").toURI().toString());
        andWeGotOlder = new Media(new File("src/com/company/resources/Music/AndWeGotOlder.mp3").toURI().toString());

        ambientTracks = new ArrayList<Media>();

        ambientTracks.add(darkFlute);
        ambientTracks.add(loneStar);
        ambientTracks.add(underATree);
        ambientTracks.add(theMaelstrom);
        ambientTracks.add(theBalladOfTheSpaceBabies);
        ambientTracks.add(bonesMcCoy);
        ambientTracks.add(odeToARoom);
        ambientTracks.add(littleFurnace);
        ambientTracks.add(cabinMusic);
        ambientTracks.add(com64);
        ambientTracks.add(upAMountain);


        battleTracks = new ArrayList<Media>();

        battleTracks.add(battles1);
        battleTracks.add(battles2);
        battleTracks.add(confrontingTheWolf);



    }

    public static void playIntro() {
        mediaPlayer = new MediaPlayer(thePrettiestRemix);
        mediaPlayer.play();
    }

    public static void playInventory() {
        inventoryPlayer = new MediaPlayer(theCloud);
        inventoryPlayer.play();
    }

    public static void stopInventory() {
        inventoryPlayer = new MediaPlayer(theCloud);
        inventoryPlayer.stop();
    }

    public static void playDeath() {
        mediaPlayer = new MediaPlayer(doomSock);
        mediaPlayer.play();
    }

    public static void playOutro() {
        mediaPlayer = new MediaPlayer(thePrettiestWeed);
        mediaPlayer.play();
    }

    //TODO: Make this work properly, it might start the playlist from the beginning every time. Add shuffling.
    public static void playAmbient() {
        for (Media m : ambientTracks) {
            mediaPlayer = new MediaPlayer(m);
            mediaPlayer.play();
        }
    }

    public static void pauseAmbient() {
        mediaPlayer.pause();
    }

}
