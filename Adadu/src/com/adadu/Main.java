package com.adadu;

import java.util.Scanner;

import com.adadu.algorithms.*;
import com.adadu.key.*;
import com.adadu.implementations.*;
/* for the purpose of this project, only the English letters is allowed.
 of course the project can be implemented using blocks or bytes instead of English letters
*/

/** The project is about the cryptographic diffusion as identified by Claude Shannon. Four basic algorithms is developed and
 six implementations of the algorithm is presented. These algorithms are derived from some specific solutions of homogenous
 linear Diophantine equation in n unknowns, where n>=2. The algorithms can be iterated yielding distinct orbits until convergence.
 Note that even(character string) converges back to the original input(bijective) while odd(character string) may converge to the
 original input or may converge to a string that shares similar characteristics with the original input.
 */
/*Diffusion:
Diffusion is achieved whenever each of the ciphertext characters(or blocks) is affected by more than one plaintext characters(blocks).
meaning if a single plaintext character is changed it will cause more than half of the ciphertext characters to change and similarly
if a single ciphertext character is changed, it will cause more than half of plaintext character to change. A diffusion method should
exhibit the avalanche effect i.e a slight change in the input should cause drastic change in the output and vice versa.
The four algorithms(functions) so presented and its six implementations satisfies the avalanche effect thereby frustrating statistical
analysis on plaintext.
 */
public class Main {
    /* sample plaintext
    AttackAtDawn
    AttackAtDawnWithTheFighterJets; LearnToWorkHarderOnYourselfThanYouDoOnYourJobIfYouWantTrueSuccessAndHappinessA
   TakeGoodCareOfMeBecauseYouMightNotHaveABetterChoiceAsYouThoughtA */

    public static void main(String[] args) {

        // declaring variables for storing the message
        String originalMessage;
        String encryptedMessage;
        String decryptedMessage;

        Scanner sc = new Scanner(System.in);

        // Symbol definition
        // N = North algorithm(function)
        // E = East algorithm(function)
        // W = West algorithm(function)
        // S = South algorithm(function)

        //declaring object variable for the four algorithms
        North north = new North();
        East east = new East();
        West west = new West();
        South south = new South();

        // object variable for the six different implementations
        InWard inWard = new InWard();
        OutWard outWard = new OutWard();

        RightWard rightWard = new RightWard();
        RightWardReversed rightWardReversed = new RightWardReversed();

        LeftWard leftWard = new LeftWard();
        LeftWardReversed leftWardReversed = new LeftWardReversed();

        // creating object variable 'myAdaduKey' for the Key
        AdaduKey myAdaduKey = new AdaduKey();

        //user is asked to input message
        System.out.println("Enter message");
        originalMessage = sc.nextLine().toUpperCase();

        int msgLen = originalMessage.length();
        /* if message length is odd append to it the upper case letter "T" to make it even. this is done to ensure invertibility
         of the function. of course one can use any character of his choice. since message length is increased we update its
          length accordingly
         */
        String newMessage=originalMessage;
        if (msgLen % 2 != 0) {
            newMessage = originalMessage + 'T';
            msgLen = newMessage.length();
        }

        System.out.println("Select option:\n 1.Algorithm(Function) \n 2.Implementation \n 3.Simple Encryption");

       int myNum = sc.nextInt();
        if(myNum==1){
            System.out.println("you have chosen Algorithm(Function)");
            System.out.println("Select option:\n 1.North function \n 2.East function \n 3.West function \n 4.South function");
            int chooseNEWS = sc.nextInt();
            if(chooseNEWS==1){// North function
                System.out.println("you have chosen North Function");
                System.out.println("Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsUpTo \n 5.printAllOrbits \n 6.printSimilarInputs");
                int N_method = sc.nextInt();
                if(N_method==1){
                    System.out.println(north.getFirstOrbit(originalMessage));
                }else if(N_method==2){
                    System.out.println(north.getLastOrbit(originalMessage));
                }else if(N_method==3){
                    System.out.print("select index: ");
                    int N_index1 = sc.nextInt();
                    System.out.println(north.getOrbitAt(originalMessage,N_index1));
                }else if(N_method==4){
                    System.out.print("select index: ");
                    int N_index2 = sc.nextInt();
                    north.printOrbitsUpTo(originalMessage,N_index2);
                }else if(N_method==5){
                    north.printAllOrbits(originalMessage);
                }else if(N_method==6){
                    if(originalMessage.length()%2==1){
                        north.printSimilarInputs(originalMessage);
                    }else {
                        north.printSimilarInputs(originalMessage+"A");
                    }
                }
                System.exit(11);
            }else if(chooseNEWS==2){// East function
                System.out.println("you have chosen East Function");
                System.out.println("Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsUpTo \n 5.printAllOrbits \n 6.printSimilarInputs");
                int E_method = sc.nextInt();
                if(E_method==1){
                    System.out.println(east.getFirstOrbit(originalMessage));
                }else if(E_method==2){
                    System.out.println(east.getLastOrbit(originalMessage));
                }else if(E_method==3){
                    System.out.print("select index: ");
                    int E_index1 = sc.nextInt();
                    System.out.println(east.getOrbitAt(originalMessage,E_index1));
                }else if(E_method==4){
                    System.out.print("select index: ");
                    int E_index2 = sc.nextInt();
                    east.printOrbitsUpTo(originalMessage,E_index2);
                }else if(E_method==5){
                    east.printAllOrbits(originalMessage);
                }else if(E_method==6){
                    if(originalMessage.length()%2==1){
                        east.printSimilarInputs(originalMessage);
                    }else {
                        east.printSimilarInputs(originalMessage+"A");
                    }
                }
                System.exit(22);
            }else if(chooseNEWS==3){// West function
                System.out.println("you have chosen West Function");
                System.out.println("Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsUpTo \n 5.printAllOrbits \n 6.printSimilarInputs");
                int W_method = sc.nextInt();
                if(W_method==1){
                    System.out.println(west.getFirstOrbit(originalMessage));
                }else if(W_method==2){
                    System.out.println(west.getLastOrbit(originalMessage));
                }else if(W_method==3){
                    System.out.print("select index: ");
                    int W_index1 = sc.nextInt();
                    System.out.println(west.getOrbitAt(originalMessage,W_index1));
                }else if(W_method==4){
                    System.out.print("select index: ");
                    int W_index2 = sc.nextInt();
                    west.printOrbitsUpTo(originalMessage,W_index2);
                }else if(W_method==5){
                    west.printAllOrbits(originalMessage);
                }else if(W_method==6){
                    if(originalMessage.length()%2==1){
                        west.printSimilarInputs(originalMessage);
                    }else {
                        west.printSimilarInputs(originalMessage+"A");
                    }
                }
                System.exit(33);
            }else if(chooseNEWS==4) {// South function
                System.out.println("you have chosen South Function");
                System.out.println("Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsUpTo \n 5.printAllOrbits \n 6.printSimilarInputs");
                int S_method = sc.nextInt();
                if(S_method==1){
                    System.out.println(south.getFirstOrbit(originalMessage));
                }else if(S_method==2){
                    System.out.println(south.getLastOrbit(originalMessage));
                }else if(S_method==3){
                    System.out.print("select index: ");
                    int S_index1 = sc.nextInt();
                    System.out.println(south.getOrbitAt(originalMessage,S_index1));
                }else if(S_method==4){
                    System.out.print("select index: ");
                    int S_index2 = sc.nextInt();
                    south.printOrbitsUpTo(originalMessage,S_index2);
                }else if(S_method==5){
                    south.printAllOrbits(originalMessage);
                }else if(S_method==6){
                    if(originalMessage.length()%2==1){
                        south.printSimilarInputs(originalMessage);
                    }else {
                        south.printSimilarInputs(originalMessage+"A");
                    }
                }
                System.exit(44);
            }else {
                System.out.println("option does not exists");
                System.exit(55);
            }

        }else if(myNum==2){ // implementation
            System.out.println("you have chosen Implementation");
            System.out.println("Select option:\n 1.InWard \n 2.OutWard \n 3.RightWard \n 4.RightWardReversed \n 5.LeftWard \n 6.LeftWardReversed");
            int implementNEWS = sc.nextInt();
            char myChar;
            if(implementNEWS==1){// InWard
                System.out.println("you have chosen InWard Implementation");
                System.out.println("Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsUpTo \n 5.printAllOrbits");
                int i_method = sc.nextInt();
                if(i_method==1){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.println(inWard.getFirstOrbit(newMessage,myChar));
                }else if(i_method==2){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.println(inWard.getLastOrbit(newMessage,myChar));
                }else if(i_method==3){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.print("select index: ");
                   int i_index1 = sc.nextInt();
                    System.out.println(inWard.getOrbitAt(newMessage,i_index1,myChar));
                }else if(i_method==4){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.print("select index: ");
                    int i_index2 = sc.nextInt();
                    inWard.printOrbitsUpTo(newMessage,i_index2,myChar);
                }else if(i_method==5){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    inWard.printAllOrbits(newMessage,myChar);
                }

            }else if(implementNEWS==2) {// OutWard
                System.out.println("you have chosen outWard Implementation");
                System.out.println("Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsUpTo \n 5.printAllOrbits");
                int o_method = sc.nextInt();
                if(o_method==1){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.println(outWard.getFirstOrbit(newMessage,myChar));
                }else if(o_method==2){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.println(outWard.getLastOrbit(newMessage,myChar));
                }else if(o_method==3){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.print("select index: ");
                    int o_index1 = sc.nextInt();
                    System.out.println(outWard.getOrbitAt(newMessage,o_index1,myChar));
                }else if(o_method==4){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.print("select index: ");
                    int o_index2 = sc.nextInt();
                    outWard.printOrbitsUpTo(newMessage,o_index2,myChar);
                }else if(o_method==5){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    outWard.printAllOrbits(newMessage,myChar);
                }

            }else if(implementNEWS==3) {// RightWard
                System.out.println("you have chosen RightWard Implementation");
                System.out.println("Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsUpTo \n 5.printAllOrbits");
                int r_method = sc.nextInt();
                if(r_method==1){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.println(rightWard.getFirstOrbit(newMessage,myChar));
                }else if(r_method==2){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.println(rightWard.getLastOrbit(newMessage,myChar));
                }else if(r_method==3){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.print("select index: ");
                    int r_index1 = sc.nextInt();
                    System.out.println(rightWard.getOrbitAt(newMessage,r_index1,myChar));
                }else if(r_method==4){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.print("select index: ");
                    int r_index2 = sc.nextInt();
                    rightWard.printOrbitsUpTo(newMessage,r_index2,myChar);
                }else if(r_method==5){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    rightWard.printAllOrbits(newMessage,myChar);
                }

            }else if(implementNEWS==4) {// RightWardReversed
                System.out.println("you have chosen RightWardReversed Implementation");
                System.out.println("Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsUpTo \n 5.printAllOrbits");
                int rr_method = sc.nextInt();
                if(rr_method==1){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.println(rightWardReversed.getFirstOrbit(newMessage,myChar));
                }else if(rr_method==2){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.println(rightWardReversed.getLastOrbit(newMessage,myChar));
                }else if(rr_method==3){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.print("select index: ");
                    int rr_index1 = sc.nextInt();
                    System.out.println(rightWardReversed.getOrbitAt(newMessage,rr_index1,myChar));
                }else if(rr_method==4){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.print("select index: ");
                    int rr_index2 = sc.nextInt();
                    rightWardReversed.printOrbitsUpTo(newMessage,rr_index2,myChar);
                }else if(rr_method==5){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    rightWardReversed.printAllOrbits(newMessage,myChar);
                }

            }else if(implementNEWS==5) {// LeftWard
                System.out.println("you have chosen LeftWard Implementation");
                System.out.println("Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsUpTo \n 5.printAllOrbits");
                int l_method = sc.nextInt();
                if(l_method==1){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.println(leftWard.getFirstOrbit(newMessage,myChar));
                }else if(l_method==2){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.println(leftWard.getLastOrbit(newMessage,myChar));
                }else if(l_method==3){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.print("select index: ");
                    int l_index1 = sc.nextInt();
                    System.out.println(leftWard.getOrbitAt(newMessage,l_index1,myChar));
                }else if(l_method==4){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.print("select index: ");
                    int l_index2 = sc.nextInt();
                    leftWard.printOrbitsUpTo(newMessage,l_index2,myChar);
                }else if(l_method==5){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    leftWard.printAllOrbits(newMessage,myChar);
                }

            }else if(implementNEWS==6) {// LeftWardReversed
                System.out.println("you have chosen LeftWardReversed Implementation");
                System.out.println("Select option:\n 1.getFirstOrbit \n 2.getLastOrbit \n 3.getOrbitAt \n 4.printOrbitsUpTo \n 5.printAllOrbits");
                int lr_method = sc.nextInt();
                if(lr_method==1){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.println(leftWardReversed.getFirstOrbit(newMessage,myChar));
                }else if(lr_method==2){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.println(leftWardReversed.getLastOrbit(newMessage,myChar));
                }else if(lr_method==3){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.print("select index: ");
                    int lr_index1 = sc.nextInt();
                    System.out.println(leftWardReversed.getOrbitAt(newMessage,lr_index1,myChar));
                }else if(lr_method==4){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    System.out.print("select index: ");
                    int lr_index2 = sc.nextInt();
                    leftWardReversed.printOrbitsUpTo(newMessage,lr_index2,myChar);
                }else if(lr_method==5){
                    System.out.print("Select function: ");
                    myChar = sc.next().toUpperCase().charAt(0);
                    leftWardReversed.printAllOrbits(newMessage,myChar);
                }

            }else{
                System.out.println("option does not exists");
            }

        }else if(myNum==3){
            System.out.println("you have chosen Simple Encryption");

            /** Adadu key
             Any key that is generated using one of the four algorithms or its implementations or that is generated using a modification
             of either of the algorithms or its implementations will hence forth be referred to as The Adadu key.
             the Adadu key changes whenever the message length changes. for example the Adadu key for message of length 6 is statistically
             distinct from message of length 8 though they both share the same seed 'myKey'.
             */
            String myKey = "HalogenFMYSD";
            System.out.println("the seed key: "+myKey);
            // the method 'getAdaduKey' returns the Adadu key generated using the original input key.
            String keyAdadu = myAdaduKey.getAdaduKey(myKey, msgLen, 'E');
            keyAdadu = outWard.getFirstOrbit(keyAdadu, 'S');
            System.out.print("Adadu Key: ");
            System.out.println(keyAdadu);

            // Encryption(using OutWard implementation)
            System.out.println("Encryption: ");
            System.out.println("Diffused text: "+outWard.getFirstOrbit(newMessage, 'E'));
            encryptedMessage = encrypt(outWard.getFirstOrbit(newMessage, 'E'), keyAdadu);
            System.out.println("Encrypted text: "+encryptedMessage);
            System.out.println("Decryption: ");
            // Decryption(using InWard implementation)
            decryptedMessage = inWard.getFirstOrbit(decrypt(encryptedMessage, keyAdadu), 'W') ;
            System.out.println("plaintext: "+decryptedMessage);

            System.exit(874);
        }else{
            System.out.println("option does not exist");
        }

    }// main method

    // method to encrypt diffused text
    public static String encrypt(String diffusedText, String newMyKey) {

        int newLen = diffusedText.length();
        char[] NewEncryptedMessage = new char[newLen];
        for (int i = 0; i < newLen; i++) {
            NewEncryptedMessage[i] = (char) (((((int) diffusedText.charAt(i) + (int) newMyKey.charAt(i)) % 26 + 26) % 26) + 65);
        }
        return String.valueOf(NewEncryptedMessage);
    }// method encrypt
    // method to decrypt diffused text
    public static String decrypt(String newEncryptedMessage, String newMyKey) {

        int oldLen = newEncryptedMessage.length();
        char[] decryptedMessage = new char[oldLen];

        for (int i = 0; i < oldLen; i++) {
            decryptedMessage[i] = (char) (((((int) newEncryptedMessage.charAt(i) - (int) newMyKey.charAt(i)) % 26 + 26) % 26) + 65);
        }
        return String.valueOf(decryptedMessage);
    }// method decrypt

}
