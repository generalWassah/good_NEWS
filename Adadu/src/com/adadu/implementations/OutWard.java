package com.adadu.implementations;
import com.adadu.selectNEWS.SelectNEWS;

public class OutWard {
    char[] collectSubText = {}; // store intermediate chars for processing
    String newDiffusedText = ""; //store diffused intermediate chars
    SelectNEWS myNEWS = new SelectNEWS();
//method for outWardDiffuse
    public String getFirstOrbit(String newText, char selectNEWS){
        String outWardDiffused;

        if(selectNEWS !='N' && selectNEWS !='E'  && selectNEWS !='W' && selectNEWS !='S' ){
            System.out.println("enter valid diffusion option");
            System.exit(20);
        }

        int strLen = newText.length();
    int maxIter = (strLen) / 2; //maximum iteration for the while loop
    int leftIndex = maxIter - 1;
    int iterStrtPoint1 = 0; // iteration starting point 1
    int iterStrtPoint2 = 0; // iteration starting point 2
    int subArrayLength = 2; //intermediate chars length
    int iter=maxIter;
// while loop
        while(iter>0){

            iterStrtPoint1 = leftIndex;
            iterStrtPoint2 = leftIndex;
            collectSubText = new char[subArrayLength];
            // for loop
            for (int i = 0; i < subArrayLength; i++) {
            collectSubText[i] = newText.charAt(iterStrtPoint1);
              iterStrtPoint1++;
            }// for i

            // diffuse collected subText
            newDiffusedText = myNEWS.diffuseMessage(collectSubText,selectNEWS);

            //replace corresponding newDiffusedText into newText
            for (int j = 0; j < subArrayLength; j++) {
                char[] charText1 = newText.toCharArray();
                //replace chars with diffused txt at iterStrtPoint2
                charText1[iterStrtPoint2] = newDiffusedText.charAt(j);
                iterStrtPoint2++;
                newText = String.valueOf(charText1);
            }//for j

        subArrayLength+=2;
        leftIndex--;
        iter--;

    }// while

          outWardDiffused=newText;

        return outWardDiffused;

    }// method getOutWardDiffused

    // returns the last orbit of the iterated sequence
    public String getLastOrbit(String newText, char selectNEWS){

        InWard inWard = new InWard();
        String lastOrbit="";
        if (selectNEWS=='N'){
            lastOrbit = inWard.getFirstOrbit(newText,'S');
        }else if (selectNEWS=='E'){
            lastOrbit = inWard.getFirstOrbit(newText,'W');
        }else if (selectNEWS=='W'){
            lastOrbit = inWard.getFirstOrbit(newText,'E');
        }else if (selectNEWS=='S'){
            lastOrbit = inWard.getFirstOrbit(newText,'N');
        }
        return lastOrbit;
    }// last orbit
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
    }// orbit at
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
    }// orbits up to
    // print all orbits
    public void printAllOrbits(String newText, char newsFunction){

        String originalText = newText;
        int t = 1;
        while(true){
            String orbitsGen = getFirstOrbit(newText,newsFunction);
            System.out.println(orbitsGen+" "+t++);
            if(originalText.equals(orbitsGen)){
                break;
            }
            newText=orbitsGen;
        }
    }// print all orbits

}//class
