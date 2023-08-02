import strhasint.*;
import inthasstr.*;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException; //all packages

public class Booking {

    public static void book(String[] name, int[] userid, long[] phoneno, LocalDate[] bookedDate,
            LocalDate[] deliveryDate, int[] bookingId, double[] bookingAmount, String[] bookingStatus) { // all
                                                                                                         // nessecary
                                                                                                         // arguments
                                                                                                         // passed in
                                                                                                         // book method
        StrHasInt str = new StrHasInt();
        IntHasStr num = new IntHasStr(); // objects for my packages
        Scanner scan = new Scanner(System.in);
        LocalDate dateToday = LocalDate.now(); // gets today date
        Random random = new Random();

        System.out.print("Enter Your ID: ");
        int id = num.IntHasStr(); // asks user id

        int index = loop.intuserid(userid, id, bookingId); // checks if that user id exist and returns the index of that
                                                           // user id
        if (index >= 0) { // if index greater than 0
            System.out.println("Booking Date: " + dateToday);
            bookedDate[index] = dateToday; // booking date is todays date

            System.out.print("\nEnter the payment amount: ");
            double customerBookingAmount = num.DoubleHasStr(); // payment amount
            while (customerBookingAmount < 100 || customerBookingAmount > 950) { // payemnt amount must be ateast 100 to
                                                                                 // 950 maximum
                System.out.println("Minimum Payment is 100. Maximum is 950.");
                System.out.print("\nEnter the payment amount:");
                customerBookingAmount = num.DoubleHasStr();
            }
            bookingAmount[index] = customerBookingAmount; // stores that payment amount in the amount array

            LocalDate date = DateTimeParseExceptionHandleing.dateTimeParseExceptionHandleing(); // ask customers
                                                                                                // preferred delivery
                                                                                                // date
            long daysBetween = ChronoUnit.DAYS.between(dateToday, date); // check the difference between today date and
                                                                         // preferred delivery date store in integer

            while (daysBetween < 0) { // if the day difference is negative ask delivery date again
                System.out.println("preferred delivery date Can't Be In Past.");
                date = DateTimeParseExceptionHandleing.dateTimeParseExceptionHandleing();
                daysBetween = ChronoUnit.DAYS.between(dateToday, date);
            }

            if (daysBetween >= 10) { // if the day difference is more than 10 store the customers delivery date as
                                     // delivery date
                deliveryDate[index] = date;
            } else { // else create a random day with random object of minimum 3 days after booking
                     // date
                int daysplus = random.nextInt(3) + 3;
                LocalDate futuredate = dateToday.plusDays(daysplus);
                deliveryDate[index] = futuredate;
            }

            bookingId[index] = BookingIdLoop.bookingIdLoop(bookingId, bookingStatus); // create a random booking id 0f
                                                                                      // between 2000 to 2999

            bookingStatus[index] = "In Process."; // sets booking status as in process

            System.out.print("\n\n\t\tBooking successful. Your Booking ID is: " + bookingId[index] + "\n"); // output
                                                                                                            // booking
                                                                                                            // successfull

        } else if (index == -2) { // else if the index is -2 prints the booking is alreay in process
            System.out.println(
                    "Booking Is Already In Process, Wait Until The Current Gas To Deliver. to Book Another Gas.");
        } else if (index == -1) { // else prints user id not exist
            System.out.println("\n\n\t\tCan't Found Your User ID!.");
        }
    }
}

class loop { // loop through the user id array
    public static int intuserid(int[] userid, int id, int[] bookingId) {
        for (int i = 0; i < userid.length; i++) {
            if (userid[i] == id) { // check if the userid array matches with the user id entered by user
                if (bookingId[i] == 0) { // in that userid array index check if the booking id array index is 0 or not
                    return i; // if yes returns the that userid array index
                } else { // if the userid array index in booking array index is not 0 then return -2
                    return -2;
                }
            }
        }
        return -1; // else return -1
    }
}

class DateTimeParseExceptionHandleing { // datetime exception handelling class
    public static LocalDate dateTimeParseExceptionHandleing() { // date time exception handeling method
        Scanner scan = new Scanner(System.in);
        System.out.print("\nYour preferred delivery date (dd/mm/yyyy): ");
        String dateinput = scan.nextLine().trim(); // ask user to enter preferred delivery date
        LocalDate date; // create a empty date variable of LocalDate
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try { // tries to format the entered date in a givven date format
            date = LocalDate.parse(dateinput, dateFormatter);
            return date; // return date
        } catch (DateTimeParseException e) { // else catch exception error print error message and recusrion is used
            System.out.println("\nInvalid Date Format, Please Enter In dd/mm/yyyy Format.");
        }
        return dateTimeParseExceptionHandleing(); // recursion
    }
}

class BookingIdLoop { // booking id class
    public static int bookingIdLoop(int[] bookingId, String[] bookingStatus) { // booking id method
        Random random = new Random();
        int randomBookingId = random.nextInt(999) + 2000; // create random number of booking id between 2000 to 2999
        for (int i = 0; i < bookingId.length; i++) {
            if (randomBookingId == bookingId[i]) { // check if that booking id already exist in the array
                if (bookingStatus[i].equalsIgnoreCase("Delivered.")) { // if exist check if the booking status is
                                                                       // delivered
                    return randomBookingId; // if deliveried retuns that booking id
                } else {
                    return bookingIdLoop(bookingId, bookingStatus); // else recusrion to create another booking id
                }
            }
        }
        return randomBookingId; // else return booking id
    }
}