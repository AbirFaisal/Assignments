import java.util.Scanner;

public class CheckPassword {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the password: ");
        String password = input.nextLine();
        System.out.println(IsValid(password));
    }//end of main

    public static String IsValid(String pass) {
        int digitCount = 0;
        if (pass.length() >= 8) {//checks is password length is less than or equal to 8
            for (char c : pass.toUpperCase().toCharArray()) {//to char array converts string to array
                if ((int) c >= 48 && (int) c <= 57)//ascii decimal value for numbers
                {
                    // This is a digit
                    digitCount++;
                } else if ((int) c >= 65 && (int) c <= 90)//ascii decimal values for capital letters
                {
                    // This is an alphabetical character
                } else {
                    // Other character that are not numbers or letters
                    return "Invalid: password must consist of only letters and digits";
                }
            }//end of for
            if (digitCount < 2)//if there are less than 2 digits
            {
                return "Invalid: password must contain at least 2 digits";
            }
        }//end of outer if
        else {
            return "Invalid: password must have at least 8 characters";
        }//end of outer else
        return "Valid";
    }
}
