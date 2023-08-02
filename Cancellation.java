import inthasstr.IntHasStr;
// import strhasint.StrHasInt;
import strhasint.StrHasInt;

import java.time.LocalDate;
// import java.util.*;
import java.util.Scanner; //all package

public class Cancellation {
    public static void cancel(int[] bookingId, String[] name, int[] userid, long[] phoneno, LocalDate[] bookedDate,
            LocalDate[] deliveryDate, String[] bookingStatus, double[] bookingAmount) {
        Scanner scan = new Scanner(System.in);
        StrHasInt str = new StrHasInt();
        IntHasStr num = new IntHasStr();

        System.out.print("\nEnter Your Booking ID: ");
        int customerBookingId = num.IntHasStr(); // ask user their booking id
        while (customerBookingId < 2000 || customerBookingId > 2999) { // if booking id is invalid print invalid
                                                                       // meessage
            System.out.println("Invalid Booking Id. Try Again.");
            System.out.print("\nEnter Your Booking ID: ");
            customerBookingId = num.IntHasStr(); // try again
        }

        int index = LoopBookingId.bookingid(bookingId, customerBookingId); // else retun the index value of that booking
                                                                           // id

        if (index >= 0) { // if index greater than 0 ask reason and validation
            System.out.print("\nReason For Cancellation: ");
            String reason = scan.nextLine().trim(); // ask reason
            while (reason.length() <= 5) { // reason must be atleast 5 charecter long
                System.out.println("Reason Must Be In Details.");
                System.out.print("\nReason For Cancellation: "); // and asks again
                reason = scan.nextLine().trim();
            }

            long customerPhoneNumber; // ask phonr number to cancel
            System.out.print("\nEnter Your Phone Number To Confirm Cancellation: ");
            customerPhoneNumber = num.LongHasStr(); // validate phone number
            while (customerPhoneNumber < 60_00_00_00_00l || customerPhoneNumber > 99_99_99_99_99l) { // else ask phone
                                                                                                     // number again
                System.out.println("Incorrect Phone Number.");
                break;
            }
            if (phoneno[index] == customerPhoneNumber) { // check if the phone number enter is on the same index as
                                                         // booking id
                if (bookingStatus[index].equalsIgnoreCase("Delivered.")) { // if the booking status is delivered
                    System.out.println("Can't Cancel Booking Cause It's Delivered."); // print cant cancell cause its
                                                                                      // alreay delivered
                } else { // else sets all value to 0 and null
                    name[index] = null;
                    userid[index] = 0;
                    phoneno[index] = 0;
                    bookingId[index] = 0;
                    bookingStatus[index] = null;
                    bookingAmount[index] = 0;
                    bookedDate[index] = null;
                    deliveryDate[index] = null;
                    System.out.println("\n\n\t\tBooking Cancelled Successfully!.");
                }
            } else { // if the phone number entered by user is not equal to phone number array of
                     // index of the same index as booking is
                System.out.println("Incorrect Phone Number. Cancellation Failed."); // than prints incorrect phone
                                                                                    // number
            }
        } else { // else print incorrect booking id
            System.out.println("\n\n\t\tIncorrect Booking ID. Cancellation Failed.");
        }
    }
}

class LoopBookingId { // loop throught booking id
    public static int bookingid(int[] bookingId, int customerBookingId) {
        // Scanner scan = new Scanner(System.in);
        // StrHasInt str = new StrHasInt();
        // IntHasStr num = new IntHasStr();

        for (int i = 0; i < bookingId.length; i++) {
            if (bookingId[i] == customerBookingId) { // if booking id is equal to the booking id ented by user
                return i; // than returrn index value
            }
        }
        return -1; // else retun -1
    }
}