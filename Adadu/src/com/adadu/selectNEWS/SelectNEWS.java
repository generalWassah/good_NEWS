package com.adadu.selectNEWS;

import com.adadu.algorithms.*;

public class SelectNEWS {
    North north = new North();
    South south = new South();
    East east = new East();
    West west = new West();

    // implementation

    String newDiffusedText = ""; //store diffused intermediate chars

    public String diffuseMessage(char[] collectSubText, char newsFunction) {

        String newCollectSubText = "";
        newCollectSubText = String.valueOf(collectSubText);

        // choose the type of diffusion u want
        if (newsFunction=='N') {
            newDiffusedText = north.getFirstOrbit(newCollectSubText);
        } else if (newsFunction=='E') {
            newDiffusedText = east.getFirstOrbit(newCollectSubText);
        } else if (newsFunction=='W') {
            newDiffusedText = west.getFirstOrbit(newCollectSubText);
        } else if (newsFunction=='S') {
            newDiffusedText = south.getFirstOrbit(newCollectSubText);
        }
        return newDiffusedText;
    }// method DiffusionChoice

}// class SelectNEWS
