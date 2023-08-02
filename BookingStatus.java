import strhasint.*;
import inthasstr.*;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.*;//all package

public class BookingStatus {
    public static void bookingStatus(LocalDate[] bookedDate, LocalDate[] deliveryDate, int[] bookingId,
            double[] bookingAmount, String[] bookingStatus) {
        Scanner scan = new Scanner(System.in);
        StrHasInt str = new StrHasInt();
        IntHasStr num = new IntHasStr();

        System.out.print("\nEnter Your Booking Id: ");
        int customerBookingId = num.IntHasStr(); // ask user to enter booking id
        int index = LoopCustomerBookingId.loopBookingId(bookingId, customerBookingId); // returns the index value of
                                                                                       // that booking id entered by
                                                                                       // user

        if (index >= 0) { // if index is greater than 0 print booking status
            LocalDate bookingDate = bookedDate[index];
            LocalDate deliveringDate = deliveryDate[index];
            if (deliveringDate == null) { // delivery date is null print status cancelled because we deleted it in
                                          // cancellation.java
                System.out.println("Booking Status: Cancelled");
            } else { // else print status
                long daysBetween = ChronoUnit.DAYS.between(bookingDate, deliveringDate); // checks the difference
                                                                                         // between toadays date and
                                                                                         // delivery date
                if (daysBetween > 0) { // if difference if greater than 0 print in process
                    bookingStatus[index] = "In Process.";
                    System.out.println("Booking Status: " + bookingStatus[index]);
                    System.out.println("Expected Delivery Date (yyyy/mm/dd): " + deliveryDate[index]);
                    System.out.println("Your Payment Amount During Delivery: " + (950 - bookingAmount[index]));
                } else if (daysBetween == 0) { // else if differnce is 0 than prints delivering today
                    bookingStatus[index] = "Delivering Today.";
                    System.out.println("Booking Status: " + bookingStatus[index]);
                    System.out.println("Your Payment Amount During Delivery: " + (950 - bookingAmount[index]));
                } else { // else returrn delivered
                    bookingStatus[index] = "Delivered.";
                    System.out.println("Booking Status: " + bookingStatus[index]);
                }
            }

        } else { // if index less than 0 print invalid booking id
            if (customerBookingId < 2000 || customerBookingId > 2999) { // if booking is valid but not exist print
                                                                        // invalid booking id
                System.out.println("Invalid Booking ID.");
            } else { // else print invalid booking id or booking might have been cancelled
                System.out.println("Invalid Booking ID Or Booking Might Have Been Cancelled.");
            }
        }
    }
}

class LoopCustomerBookingId { // loop through booking id class
    public static int loopBookingId(int[] bookingId, int customerBookingId) {
        for (int i = 0; i < bookingId.length; i++) {
            if (bookingId[i] == customerBookingId) { // if the booking id entered by user matches the booking id array
                                                     // returns index og that booking id
                return i; // return index
            }
        }
        return -1; // else return -1
    }
}