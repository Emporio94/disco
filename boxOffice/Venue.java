package boxOffice;

import java.util.ArrayList;
import java.util.List;

import boxOffice.Seat;

public class Venue {

    private List<Seat> seats;

    public Venue() {
        seats = new ArrayList<>();
        // Initialize the venue with some seats (example: 10 rows, 10 seats each)
        for (char row = 'A'; row <= 'J'; row++) {
            for (int seatNum = 1; seatNum <= 10; seatNum++) {
                seats.add(new Seat(row, seatNum, SeatType.STANDARD)); // Assuming all seats are standard type
            }
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    // Method to get a seat by row and number
    public Seat getSeat(char row, int seatNum) {
        for (Seat seat : seats) {
            if (seat.getRow() == row && seat.getSeatNum() == seatNum) {
                return seat;
            }
        }
        return null; // Return null if no such seat is found
    }

    // Method to print details of all seats
    public void printDetails() {
        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }

    /* 
    Running test 
    
    public static void main(String[] args) {
        // Create a new venue
        Venue myVenue = new Venue();

        // Test getting a seat and printing its details
        Seat testSeat = myVenue.getSeat('A', 1);
        if (testSeat != null) {
            System.out.println("Retrieved Seat: " + testSeat);
        } else {
            System.out.println("Seat not found.");
        }

        // Test printing details of all seats in the venue
        System.out.println("Printing all seat details:");
        //myVenue.printDetails();
    }
    */

}
