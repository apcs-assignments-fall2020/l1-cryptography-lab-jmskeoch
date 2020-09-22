import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
        String result = "";

        //Loop through all characters in the inputted String
        for(int i = 0; i < message.length(); i++) {
            //Check and adjust uppercase section
            if(message.charAt(i) >= 65 && message.charAt(i) <= 87) {
                result += (char) (message.charAt(i) + 3);
            } 
            else if(message.charAt(i) >= 88 && message.charAt(i) <= 90) {
                result += (char) (message.charAt(i) - 23);
            }
            //Check and adjust uppercase section
            else if(message.charAt(i) >= 97 && message.charAt(i) <= 119) {
                result += (char) (message.charAt(i)  + 3);
            }
            else if(message.charAt(i) >= 120 && message.charAt(i) <= 122) {
                result += (char) (message.charAt(i) -  23);
            }
            //Check for any characters not in range of letters
            else {
                result += message.charAt(i);
            }
        }
        return result;
    }


    public static String decryptCaesar(String message) {
        String result = "";

        for(int i = 0; i < message.length(); i++) {
            //Check and adjust uppercase section
            if(message.charAt(i) >= 68 && message.charAt(i) <= 90) {
                result += (char) (message.charAt(i) - 3);
            } 
            else if(message.charAt(i) >= 65 && message.charAt(i) <= 67) {
                result += (char) (message.charAt(i) + 23);
            }
            //Check and adjust lowercase section
            else if(message.charAt(i) >= 100 && message.charAt(i) <= 122) {
                result += (char) (message.charAt(i)  - 3);
            }
            else if(message.charAt(i) >= 97 && message.charAt(i) <= 99) {
                result += (char) (message.charAt(i) +  23);
            }
            //Check for any characters not in range of letters
            else {
                result += message.charAt(i);
            }
        }
        return result;
    }


    public static String encryptCaesarKey(String message, int key) {
        String result = "";
        key %= 26;

        for(int i = 0; i < message.length(); i++) {
            //Check and adjust uppercase section
            if(message.charAt(i) >= 65 && message.charAt(i) <= (90 - key)) {
                result += (char) (message.charAt(i) + key);
            }
            else if(message.charAt(i) >= (90 - key + 1) && message.charAt(i) <= 90) {
                result += (char) (message.charAt(i) - (26 - key));
            }
            //Check and  adjust lowercase section
            else if(message.charAt(i) >= 97 && message.charAt(i) <= (122 - key)) {
                result += (char) (message.charAt(i) + key);
            }
            else if(message.charAt(i) > (122 - key + 1) && message.charAt(i) <= 122) {
                result += (char) (message.charAt(i) - (26 - key));
            }
            //Check for misc. 
            else {
                result += message.charAt(i);
            }
        }
        return result;
    }


    public static String decryptCaesarKey(String message, int key) {
        String result = "";
        key %= 26;

        for(int i = 0; i < message.length(); i++) {
            //Check and adjust uppercase section
            if(message.charAt(i) >= (65 + key) && message.charAt(i) <= 90) {
                result += (char) (message.charAt(i) - key);
            }
            else if(message.charAt(i) >= 65 && message.charAt(i) <= (65 + key + 1)) {
                result += (char) (message.charAt(i) + (26 - key));
            }
            //Check and  adjust lowercase section
            else if(message.charAt(i) >= (97 + key) && message.charAt(i) <= 122) {
                result += (char) (message.charAt(i) - key);
            }
            else if(message.charAt(i) > 97 && message.charAt(i) <= (97 + key + 1)) {
                result += (char) (message.charAt(i) + (26 - key));
            }
            //Check for misc. 
            else {
                result += message.charAt(i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Gather command
        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        //Command = encrypt
        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            int inputKey = scan.nextInt();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesarKey(message, inputKey));
        }

        //Command = decrypt
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message:  ");
            int inputKey = scan.nextInt();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesarKey(message, inputKey));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
