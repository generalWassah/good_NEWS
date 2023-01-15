package com.adadu.implementations;
import com.adadu.selectNEWS.SelectNEWS;

import java.util.Locale;

public class InWard {

    char[] collectSubText = {}; // store intermediate chars for processing
    String newDiffusedText = ""; //store diffused intermediate chars
    SelectNEWS myNEWS = new SelectNEWS();

    //returns first orbit of the iterated sequence using one of NEWS function
    public String getFirstOrbit(String newText, char selectNEWS) {
        String inWardDiffused;
        if(selectNEWS !='N' && selectNEWS !='E'  && selectNEWS !='W' && selectNEWS !='S' ){
            System.out.println("enter valid diffusion option");
            System.exit(20);
        }
        int strLen = newText.length();
        int maxIter = (strLen) / 2; //maximum iteration for the while loop

        int subArrayLength = strLen; //intermediate chars length

        int leftIndex = 0; // beginning of target plaintext
        int rightIndex = strLen; // end of the target plaintext
        int iter=maxIter; // number of iterations
        // while loop
        while(iter>0){
            collectSubText = new char[subArrayLength];
            for (int i = leftIndex; i < rightIndex; i++) {
                collectSubText[i] = newText.charAt(i);
            }// for i
            // diffuse collected subText
            newDiffusedText = myNEWS.diffuseMessage(collectSubText,selectNEWS);
            //replace corresponding newDiffusedText into newText
            for (int j = leftIndex; j < rightIndex; j++) {
                char[] charText1 = newText.toCharArray();
                //replace chars with diffused txt at iterStrtPoint2
                charText1[j] = newDiffusedText.charAt(j);
                newText = String.valueOf(charText1);

            }//for j

            rightIndex--;
            leftIndex++;
            iter--;

        }// while
            inWardDiffused=newText;
        return inWardDiffused;
    }// method getInWardDiffused

    // returns the last orbit of the iterated sequence
    public String getLastOrbit(String newText, char selectNEWS){

        OutWard outWard = new OutWard();
        String lastOrbit="";
      if (selectNEWS=='N'){
          lastOrbit = outWard.getFirstOrbit(newText,'S');
      }else if (selectNEWS=='E'){
          lastOrbit = outWard.getFirstOrbit(newText,'W');
      }else if (selectNEWS=='W'){
          lastOrbit = outWard.getFirstOrbit(newText,'E');
      }else if (selectNEWS=='S'){
          lastOrbit = outWard.getFirstOrbit(newText,'N');
      }
      return lastOrbit;
    } // last orbit
    // returns orbit at specified index(iter) using one of NEWS function
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
    } // orbits up to
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
