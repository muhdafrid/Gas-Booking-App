import java.time.LocalDate; // importing all neccessary packages

public class Main {     //main class
    public static void main(String[] args) {
        String name[] = new String[1000];
        int userid[] = new int[1000];
        long phoneno[] = new long[1000];
        LocalDate[] bookedDate = new LocalDate[1000];
        LocalDate[] deliveryDate = new LocalDate[1000];
        int bookingId[] = new int[1000];
        double[] bookingAmount = new double[1000];
        String[] bookingStatus = new String[1000]; // all array values.

        System.out.println("\n\t\t\tWelocme To Gas Booking Application!\n\t\t\tChoose Your Choice!");
        Command.command(name, userid, phoneno, bookedDate, deliveryDate, bookingId, bookingAmount, bookingStatus);  //sendind all array on command method as arguments
    }

    public int i;
}