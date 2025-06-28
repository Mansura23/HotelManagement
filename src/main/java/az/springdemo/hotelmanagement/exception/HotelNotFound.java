package az.springdemo.hotelmanagement.exception;

public class HotelNotFound extends RuntimeException {
    public HotelNotFound(String message) {
        super(message);
    }
}
