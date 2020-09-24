import java.util.Scanner;

public class Vigenere {
    /**
     * This method takes in two parameters:
     * @param message the message you want encrypted
     * @param key the word or 'key' to used to represent the shifts done to message
     * and returns an encrypted String dependent on the two parameters
     */
    public static String encryptVigenere(String message, String key) {
        //Init vars
        String result = "";
        int j = 0;
        int cur_key;
        int[] keys = key.chars().toArray();

        //Loop through message
        for(int i = 0; i < message.length(); i++) {
            //If we can't add one to j (counter) and use it for the array (out of bounds), then reset to start over
            if(j > keys.length - 1) {j = 0;}
            //Gather # of steps to shift
            cur_key = keys[j] % 65;
            
            //If we can shift forward without starting at the beginning of the section, proceed
            if((message.charAt(i) >= 65 && message.charAt(i) <= 90 - cur_key)
            || (message.charAt(i) >= 97 && message.charAt(i) <= 122 - cur_key)) {
                //Append
                result += (char) (message.charAt(i) + cur_key);
                j++;
            } 
            //If we have to shift by starting at the beginning of the section, then proceed as such
            else if((message.charAt(i) >= 90 - cur_key && message.charAt(i) <= 90)
            || (message.charAt(i) >= 122 - cur_key && message.charAt(i) <= 122)) {
                //Append
                result += (char) (message.charAt(i) - (26 - cur_key));
                j++;
            } 
            //Misc. chars (not letters)
            else {
                result += message.charAt(i);
            }
        }
        //Return the new string
        return result;
    }
    
    /**
     * This method accepts two parameters:
     * @param message the potentially encrypted message to be decrypted
     * @param key the key to represent how many shifts to 'undo' to the encrypted message
     * and returns a String dependent on the two paramters accepted
     */
    public static String decryptVigenere(String message, String key) {
        //Init vars
        String result = "";
        int j = 0;
        int cur_key;
        int[] keys = key.chars().toArray();

        //Loop through message
        for(int i = 0; i < message.length(); i++) {
            //If we can move forward in the array, do it. Otherwise, reset counter
            if(j > keys.length - 1) {j = 0;}
            //Gather # of steps to shift
            cur_key = keys[j] % 65;
            
            //Check upper bounds and ability to subtract
            if((message.charAt(i) >= 65 + cur_key && message.charAt(i) <= 90)
            || (message.charAt(i) >= 97 + cur_key && message.charAt(i) <= 122)) {
                //Append
                result += (char) (message.charAt(i) - cur_key);
                j++;
            } 
            //Check lower bounds and shift accordingly
            else if((message.charAt(i) >= 65 && message.charAt(i) <= 65 + cur_key + 1)
            || (message.charAt(i) >= 97 && message.charAt(i) <= 97 + cur_key + 1)) {
                //Append
                result += (char) (message.charAt(i) + (26 - cur_key));
                j++;
            } 
            //Misc. chars
            else {
                result += message.charAt(i);
            }
        }
        //Return the new string
        return result;
    }


    /**
     * Encrypt / Decrypt based off user input
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
