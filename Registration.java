import java.util.*;
import inthasstr.IntHasStr;
import strhasint.StrHasInt; /*all packages*/

public class Registration {
    Scanner scan = new Scanner(System.in);

    public void reg(String[] name, int[] userid, long[] phoneno, String[] bookingStatus) {
        Scanner scan = new Scanner(System.in);
        StrHasInt str = new StrHasInt();
        IntHasStr num = new IntHasStr(); // my object for my packages

        Random rand = new Random();
        int randomNumber = rand.nextInt(999) + 1000; // creats random number for user id between 1000 to 1999.

        int randomindex = RandomNoCheck.randomNoCheck(userid, bookingStatus, randomNumber); // checks if that random
                                                                                            // value already exist else
                                                                                            // gets the index value

        System.out.print("\nEnter Your Name: ");
        String customername = str.StrHasInt(); // gets name as user input but this str.StrHasInt() method will check if
                                               // the user enters any integers.

        while (customername.length() < 3) { // this whille loop check if the name has atleast 3 chrecter of string else
                                            // asks the name again
            System.out.println("Name Must Have Atleast 3 charecters Long And Should Not Contain Any Digits or Special Charecters.");
            System.out.print("Enter Your Name: ");
            customername = str.StrHasInt();
        }

        System.out.print("\nEnter Your Address: ");
        String address = scan.nextLine().trim(); // gets address as input
        while (address.length() < 5) { // check if the address has atleast 5 charecters long
            System.out.println("Address Must be atleast 5 charecters long.");
            System.out.print("\nEnter Your Address: ");
            address = scan.nextLine().trim();
            scan.nextLine();
        }

        long phone_no;
        System.out.print("Enter a phone number: ");
        phone_no = num.LongHasStr();
        while (phone_no < 60_00_00_00_00l || phone_no > 99_99_99_99_99l) {
            System.out.println("Invalid Phone Number!");
            System.out.print("Enter a phone number: ");
            phone_no = num.LongHasStr();
        }

        boolean bool = PhoneNoCheck.phoneNoCheck(phone_no, phoneno);
        if (bool == true) {
            userid[randomindex] = randomNumber;
            phoneno[randomindex] = phone_no;
            name[randomindex] = customername;
            System.out.print("\n\n\t\tUser Registration Successful. Your User ID is: " + userid[randomindex] + "\n");
        } else {
            System.out.println("This Phone Number Is Already Registered, Registration Failed!");
        }

    }
}

class RandomNoCheck { // this method checks if the random value created randomly already exist
    public static int randomNoCheck(int[] userid, String[] bookingStatus, int randomNumber) {

        for (int i = 0; i < userid.length; i++) { // this for loop to check that random value already exist
            if (randomNumber == userid[i]) { // this if condition check the already existed random value
                if (bookingStatus[i].equals("Delivered.") || bookingStatus[i] == null) { // this if condition checks if
                                                                                         // that random user id status
                                                                                         // is delivered
                    return i; // if yes return the index value and the other values are updated
                }
            }
        }
        for (int i = 0; i < userid.length; i++) { // if the above for loop doesnt find any existing random value then it
                                                  // will check if any index of user id array is 0 to store that random
                                                  // value
            if (userid[i] == 0) {
                return i;// returns that index value
            }
        }
        return -1; // else return -1 but its not possible because any of the above two loops will
                   // return atleast one index number
    }
}

class PhoneNoCheck {
    public static boolean phoneNoCheck(long phone_no, long[] phoneno) {
        for (int i = 0; i < phoneno.length; i++) {
            if (phoneno[i] == phone_no) {
                return false;
            }
        }
        return true;
    }
}