import strhasint.*;
import inthasstr.*;
import java.time.LocalDate;
import java.util.*;         //all packages

public class Command {
    Scanner scan = new Scanner(System.in);

    public static void command(String[] name, int[] userid, long[] phoneno, LocalDate[] bookedDate,
            LocalDate[] deliveryDate, int bookingId[], double[] bookingAmount, String[] bookingStatus) {

        byte command;
        do {
            StrHasInt str = new StrHasInt();
            IntHasStr num = new IntHasStr();
            System.out.print(
                    "\n1. Register User\n2. Book Gas Cylinder\n3. View Booking Status\n4. View Booking History\n5. Cancel Booking\n6. Exit\nEnter your choice: ");
            command = num.ByteHasStr();

            switch (command) {
                case 1:
                    Registration registration = new Registration();
                    registration.reg(name, userid, phoneno, bookingStatus);
                    break;

                case 2:
                    Booking.book(name, userid, phoneno, bookedDate, deliveryDate, bookingId, bookingAmount,
                            bookingStatus);
                    break;

                case 3:
                    BookingStatus.bookingStatus(bookedDate, deliveryDate, bookingId, bookingAmount, bookingStatus);
                    break;

                case 4:
                    BookingHistory.bookingHistory(bookedDate, deliveryDate, bookingId, userid, bookingAmount,
                            bookingStatus);
                    break;

                case 5:
                    Cancellation.cancel(bookingId, name, userid, phoneno, bookedDate, deliveryDate, bookingStatus, bookingAmount);
                    break;

                case 6:
                    Exit exit = new Exit();
                    exit.exit();
                    break;

                default:
                    System.out.println("INVALID COMMAND! TRY AGAIN!\nChoice Must be Between 1 to 6.");
                    break;
            }
        } while (command != 6);
    }
}