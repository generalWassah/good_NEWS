package com.adadu.implementations;
import com.adadu.selectNEWS.SelectNEWS;

public class RightWardReversed {
    char[] collectSubText = {}; // store intermediate chars for processing
    String newDiffusedText = ""; //store diffused intermediate chars
    SelectNEWS myNEWS = new SelectNEWS();
      //method for leftWardReversed diffused
    public String getFirstOrbit(String newText, char selectNEWS) {
        String rightWardReversedDiffused;

        if(selectNEWS !='N' && selectNEWS !='E'  && selectNEWS !='W' && selectNEWS !='S' ){
            System.out.println("enter valid diffusion option");
            System.exit(20);
        }

        int strLen = newText.length();
        int maxIter = (strLen) / 2; //maximum iteration for the while loop
        int subArrayLength = strLen; //intermediate chars length
        int iter=maxIter;
        // while loop
        while(iter>0){

            collectSubText = new char[subArrayLength];
            // for loop
            for (int i = 0; i < subArrayLength; i++) {
                collectSubText[i] = newText.charAt(i);
            }// for i

            // diffuse collected subText
            newDiffusedText = myNEWS.diffuseMessage(collectSubText,selectNEWS);
            //replace corresponding newDiffusedText into newText
            for (int j = 0; j < subArrayLength; j++) {

                char[] charText1 = newText.toCharArray();

                //replace String with diffused txt at iterStrtPoint2
                charText1[j] = newDiffusedText.charAt(j);
                newText = String.valueOf(charText1);

            }//for j
            subArrayLength-=2;
            iter--;
        }// while
           rightWardReversedDiffused=newText;
        return rightWardReversedDiffused;
    }// method getLeftToRightDiffused

    // returns the last orbit of the iterated sequence
    public String getLastOrbit(String newText, char selectNEWS){

        RightWard rightWard = new RightWard();
        String lastOrbit="";
        if (selectNEWS=='N'){
            lastOrbit = rightWard.getFirstOrbit(newText,'S');
        }else if (selectNEWS=='E'){
            lastOrbit = rightWard.getFirstOrbit(newText,'W');
        }else if (selectNEWS=='W'){
            lastOrbit = rightWard.getFirstOrbit(newText,'E');
        }else if (selectNEWS=='S'){
            lastOrbit = rightWard.getFirstOrbit(newText,'N');
        }
        return lastOrbit;
    } // last orbit
    // return orbit at specified index(iter) using one of NEWS function
    public String getOrbitAt(String newText, int iter,char selectNEWS){

        int i = 1;
        while(true) {
            String orbitsGen = getFirstOrbit(newText, selectNEWS);
            if(i==iter) {
                return orbitsGen;
            }
            newText = orbitsGen;
            i++;
        }// while
    } // orbit at
    // print orbits up to specified index(iter) using one of NEWS function
    public void printOrbitsUpTo(String newText, int iter,char selectNEWS){

        String diffusedText;
        int i = 1;
        while(iter>0){
            diffusedText = getFirstOrbit(newText,selectNEWS);
            System.out.println(diffusedText+" "+i++);
            newText = diffusedText;
            iter--;
        }
    } // orbit up to
    // print all orbits
    public void printAllOrbits(String newText, char selectNEWS){

        String originalText = newText;
        int t = 1;
        while(true){
            String orbitsGen = getFirstOrbit(newText,selectNEWS);
            System.out.println(orbitsGen+" "+t++);
            if(originalText.equals(orbitsGen)){
                break;
            }
            newText=orbitsGen;
        }
    }// print all orbits

}
