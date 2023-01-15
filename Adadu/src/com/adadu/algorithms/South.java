package com.adadu.algorithms;
public class South {
    // The South function is an iterated function based on specific solution of homogenous linear Diophantine equation
/**  This class represents one of the four algorithms(functions) which we will call 'South' with following implementation.
    Given the following homogenous linear Diophantine equation A1*X1 + A2*X2 + ... + Ai-1*Xi-1 + Ai*Xi = 0.
    where, all Ai's and Xi's represents the coefficients and variables respectively. The solution according to the South function
    is as follows.
    Xn+1 = -Xn + An - An+1, n = 0,1,2,...
    This solution is possible because 0 which is the constant in the equation above is always divisible by the greatest common
    divisor of any given set of integers.
    In order to ensure consistency of the function, there is need to define the term A0*X0 which are inputs to the function
    where  X0 = -A1+A2-A3+...-An-1+An,
           A0 = 0.
    The South function has an inverse function called the North function. In order to recover all Ai's from all Xi's, all the Xi's
    is fed into the North function as input.
   The four algorithms(functions) are collectively referred as NEWS functions. Where the word 'NEWS' is derived from the initials
   of the function names.
   Note: inverse exists only when n%2 = 0. i.e the input is even
*/

    // get the first orbit of the iterated sequence
    public String getFirstOrbit(String newText){
        String diffusedText;
        int len = newText.length();
        // Encryption

        int msgPsum = 0, msgNsum = 0;
        int msgTsum;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                msgPsum = ((msgPsum + ((int) newText.charAt(i) - 65)) % 26 + 26) % 26;
            } else {
                msgNsum = ((msgNsum - (int) newText.charAt(i) - 65) % 26 + 26) % 26;
            }
        }
        msgTsum = (msgPsum + msgNsum) % 26;
        // declaring variables for diffusion formula
        int a1 = 0, x1 = msgTsum;
        int a2, x2;
        // array of char that will store the output of below function
        char[] dChar = new char[len];
        //diffusion function
        for (int j = 0; j < len; j++) {
            x2 = (int) newText.charAt(j) - 65;
            a2 = ((-x2 + x1 - a1 ) % 26 + 26) % 26;


            dChar[j] = (char) ( (a2) + 65);

            a1 = a2;
            x1 = x2;
        }//for j
        diffusedText = String.valueOf(dChar);

        return diffusedText;
    }// method

    // get the last orbit of the iterated sequence
    public String getLastOrbit(String newText){
        North north = new North();
        return north.getFirstOrbit(newText);
    }
    // print orbit to at most iter(common to all)
    public String getOrbitAt(String newText, int iter){
        int i = 1;
        while(true) {
            String orbitsGen = getFirstOrbit(newText);
            if(i==iter) {
                return orbitsGen;
            }
            newText = orbitsGen;
            i++;
        }// while
    }
    // print orbits up to specified index
    public void printOrbitsUpTo(String newText, int iter){
        String diffusedText;
        int i = 1;
        while(iter>0){
            diffusedText = getFirstOrbit(newText);
            System.out.println(diffusedText+" "+i++);
            newText = diffusedText;
            iter--;
        }
    }
    // print all orbits(common to all)
    public void printAllOrbits(String newText){

        String firstOrbit = getFirstOrbit(newText);
        String firstOrbitOdd = firstOrbit;
        System.out.println(firstOrbit+" "+1);
        int t = 2;
        while(true){
            String orbitsGen = getFirstOrbit(firstOrbit);

            if (newText.equals(orbitsGen)) {
                System.out.println(orbitsGen + " " + t++);
                break;
            } else if (firstOrbitOdd.equals(orbitsGen)) {
                break;
            }
            System.out.println(orbitsGen+" "+t++);

            firstOrbit=orbitsGen;
        }
    }// method all orbits
    // print similar inputs for odd length of string
    public void printSimilarInputs(String outPutText){
        if(outPutText.length()%2==0){
            System.out.println("The string length provided is even an therefore has no similar input");
        }
        else{
            String[] similarInputs = new String[26];
            char[] storeChar = new char[outPutText.length()];
            // initializing the size of the similar inputs
            int sz = 25;
            while(sz>-1){
                int a1 = 0, x1 = sz;
                // function to compute similar seeds
                for (int i = 0; i <outPutText.length() ; i++) {
                    int x2 = (int)outPutText.charAt(i)-65;
                    int a2 = ((-x2-x1+a1)%26+26)%26;
                    storeChar[i] = (char)(a2+65);
                    a1 = a2;
                    x1 = x2;
                } // for loop
                similarInputs[sz] = String.valueOf(storeChar);
                if(sz == 0){
                    break;
                }
                sz--;
            }// while loop
            for (int i = 0; i < 26; i++) {
                System.out.println(similarInputs[i]+" "+i);
            }
        }// else
    }// print similar inputs

}//class
