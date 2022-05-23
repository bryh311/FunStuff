package c66_texttohex;

import java.util.Scanner;

public class texttohex {
    public static void main(String[] args) {
        System.out.print("Type in string to convert: ");
        Scanner keyboard = new Scanner(System.in);
        String str = keyboard.nextLine();
        while(true) {
            System.out.println("Hex/Bin?");
            String input = keyboard.nextLine();
            if(input.toLowerCase().trim().equals("hex")) {
                for(char c: str.toCharArray()) {
                    Integer charInt = (int) c;
                    System.out.print(Integer.toHexString(charInt) + " ");
                }
                break;
            }
            else if(input.toLowerCase().trim().equals("bin")) {
                for(char c: str.toCharArray()) {
                    Integer charInt = (int) c;
                    System.out.print(Integer.toBinaryString(charInt) + " ");
                }
                break;
            }
            else {
                System.out.println("Huh?");
            }

        }

    }
}
