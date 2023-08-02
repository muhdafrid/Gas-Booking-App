import strhasint.*;
import inthasstr.*;
import java.time.LocalDate;
import java.util.*; //all packages

public class BookingHistory { // booking history class
    public static void bookingHistory(LocalDate[] bookedDate, LocalDate[] deliveryDate, int[] bookingId, int[] userid,
            double[] bookingAmount, String[] bookingStatus) {
        Scanner scan = new Scanner(System.in);
        StrHasInt str = new StrHasInt();
        IntHasStr num = new IntHasStr();

        System.out.print("\nEnter Your User ID: ");
        int customerUserId = num.IntHasStr(); // gets user id
        while (customerUserId < 0) { // if user id less than 0 print invalid user id and ask user id again
            System.out.print("\nInvalid USER ID.");
            System.out.print("\nTry Again: ");
            customerUserId = num.IntHasStr();
        }

        int index = LoopCustomerUserID.loopCustomerUserID(userid, customerUserId); // returns the index value of the
                                                                                   // that user id entered by user in
                                                                                   // user id array
        if (index >= 0) { // if user id index is greater than 0 print the status
            System.out.println("Booking History: ");
            System.out.println("Booking ID: " + bookingId[index]);
            System.out.println("Delivery Date: " + deliveryDate[index]);
            System.out.println("Your Payment Amount: " + bookingAmount[index]);
            System.out.println("Status: " + bookingStatus[index]);
        } else { // else print invalid or cancelled message
            System.out.println("Invalid User ID or Booking Might Have Been Cancelled.");
        }
    }
}

class LoopCustomerUserID { // loop through userid array class
    public static int loopCustomerUserID(int[] userid, int customerUserId) {
        for (int i = 0; i < userid.length; i++) { // loops through user id array
            if (userid[i] == customerUserId) { // user id equals the user id entered by user
                return i; // returns index value of the user id
            }
        }
        return -1; // else retun -1
    }
}