//change
import java.util.*;

public class NumericConversion {

    public static long hexStringDecode(String hex){

        String list = "0123456789ABCDEF"; // How to deal with the letters in hex without using an array

        if(hex.charAt(1) == 'x') {
            hex = hex.substring(2);
        } // Takes care of the 0x prefix

        hex = hex.toUpperCase(); // Takes care of lowercase letters

        long result = 0;
        int ex = hex.length() - 1; // Keeps track of 16^x multiplier

        for (int i = 0; i < hex.length(); i++)
        {
            char digit = hex.charAt(i); // Reads character one at a time
            int value = list.indexOf(digit); // Converts character to integer value by relating it to its character position in the list String
            result += Math.pow(16, ex) * value;
            ex--;
        }

        return result; // returns a long integer type representing the hex's decimal value
    }

    public static short binaryStringDecode(String binary){

        if(binary.charAt(1) == 'b') {
            binary = binary.substring(2);
        } // Takes care of the 0b prefix

        short result = 0;
        int r = 0;

        for (int i = binary.length() - 1; i >= 0; i--)
        {
            char digit = binary.charAt(i); // Reads character one at a time
            result += Math.pow(2, r) * ((short) digit - 48);
            r++;
        }

        return result; // returns a short integer type representing the binary's decimal value
    }

    public static String binaryToHex (String binary){
        String list = "ABCDEF"; // How to deal with the letters in hex without using an array

        int decimal = binaryStringDecode(binary); // Convert to decimal form

        String nHex = "";

        int r;

        while(decimal != 0)
        {
            r = decimal % 16;
            if(r >= 10){
                char digit = list.charAt(r - 10);
                nHex = digit + nHex;
            } // Deals with if current character is a letter
            else
            {
                nHex = r + nHex;
            } // Deals with if current character is a letter
            decimal /= 16;
        }

        return nHex; // returns a String type representing the binary's hex value
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //To collect inputs

        int option;
        String num;

        while(true) {

            System.out.println("Decoding Menu\n-------------\n1. Decode hexadecimal\n2. Decode binary\n3. Convert binary to hexadecimal\n4. Quit ");
            System.out.print("\nPlease enter an option: ");
            option = sc.nextInt(); // Menu and user option selection

            if (option == 4)
            {
                System.out.println("Goodbye!");
                break;
            } // To exit

            System.out.print("Please enter the numeric string to convert: ");

            if(option == 1) {
                num = sc.next();
                System.out.println("Result: " + hexStringDecode(num) + "\n");
            }
            else if(option == 2){
                num = sc.next();
                System.out.println("Result: " + binaryStringDecode(num) + "\n");
            }
            else if(option == 3){
                num = sc.next();
                System.out.println("Result: " + binaryToHex(num) + "\n");
            }
            else{
                break;
            } // If something other than an option is selected program quits
        }

    }
}
