package boxOffice;

import java.util.ArrayList;
import java.util.List;

public class Event {

    private String name;
    private Venue venue;
    private List<Seat> reservedSeats;

    public Event(String name, Venue venue) {
        this.name = name;
        this.venue = venue;
        this.reservedSeats = new ArrayList<>();
    }

    // Method to reserve adjacent seats of a given type
    public boolean reserveSeats(int numOfSeats, SeatType seatType) {
        
      
        int foundSeats = 0;
        List<Seat> seatsToReserve = new ArrayList<>();

        for (Seat seat : venue.getSeats()) {
            if (seat.getSeatType() == seatType && seat.isAvailable()) {
                seatsToReserve.add(seat);
                foundSeats++;
                if (foundSeats == numOfSeats) {
                    // Reserve these seats
                    for (Seat seatToReserve : seatsToReserve) {
                        seatToReserve.setAvailable(false);
                        reservedSeats.add(seatToReserve);
                    }
                    return true; // Successful reservation
                }
            } else {
                // Reset the search if a sequence is broken
                seatsToReserve.clear();
                foundSeats = 0;
            }
        }
        return false; // If there is not enough adjacent seats 
    }

    // Method to return a seat and make it available again
    public void returnSeat(Seat seat) {
        if (reservedSeats.contains(seat)) {
            seat.setAvailable(true);
            reservedSeats.remove(seat);
        }
    }

    
    public static void main(String[] args) {
        // Create a venue
        Venue myVenue = new Venue();

        // Create an event at this venue
        Event myEvent = new Event("Concert", myVenue);

        // Attempt to reserve some seats
        System.out.println("Attempting to reserve 3 seats of Deluxe type...");
        boolean reservationResult = myEvent.reserveSeats(3, SeatType.DELUXE);
        if (reservationResult) {
            System.out.println("Seats successfully reserved.");
        } else {
            System.out.println("Unable to reserve seats.");
        }

        // Print the details of all seats to see which are reserved
        System.out.println("Venue seat details after reservation:");
        myVenue.printDetails();

        // Return one of the reserved seats
        Seat seatToReturn = myVenue.getSeat('A', 1); 
        if (seatToReturn != null) {
            myEvent.returnSeat(seatToReturn);
            System.out.println("Returned Seat: " + seatToReturn);
        } else {
            System.out.println("Seat not found.");
        }

        // Print the details of all seats again to see the updated status
        System.out.println("Venue seat details after returning a seat:");
        myVenue.printDetails();
    }

}
