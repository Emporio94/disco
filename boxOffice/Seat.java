package boxOffice;

public class Seat {

    private char row;
    private int seatNum;
    private SeatType seatType;
    private boolean isAvailable;

    public Seat(char row, int seatNum, SeatType seatType) {
        // Validate the input parameters
        if (row < 'A' || row > 'Z') {
            throw new IllegalArgumentException("Invalid row: " + row);
        }
        if (seatNum <= 0) {
            throw new IllegalArgumentException("Invalid seat number: " + seatNum);
        }
        this.row = row;
        this.seatNum = seatNum;
        this.seatType = seatType;
        this.isAvailable = true; // Assuming all seats are available initially
    }

        // Getter methods
        public char getRow() {
            return row;
        }
    
        public int getSeatNum() {
            return seatNum;
        }
    
        public SeatType getSeatType() {
            return seatType;
        }
    
        public boolean isAvailable() {
            return isAvailable;
        }
    
        // Setter method for availability
        public void setAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
        }

    // Overriding toString() method
    @Override
    public String toString() {
        return "Seat{" +
               "row=" + row +
               ", seatNum=" + seatNum +
               ", seatType=" + seatType +
               ", isAvailable=" + isAvailable +
               '}';
    }

    // Overriding equals() method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return row == seat.row &&
               seatNum == seat.seatNum &&
               seatType == seat.seatType;
    }

    // Overriding hashCode() method
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + row;
        result = 31 * result + seatNum;
        result = 31 * result + (seatType != null ? seatType.hashCode() : 0);
        return result;
    }
}
