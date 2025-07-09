package az.springdemo.hotelmanagement.controller;

import az.springdemo.hotelmanagement.dto.BookingDto;
import az.springdemo.hotelmanagement.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }
    @GetMapping(path = "{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(bookingService.getBookingById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<BookingDto> createBooking( @Valid @RequestBody BookingDto bookingDto) throws Exception {
        return new ResponseEntity<>(bookingService.saveBooking(bookingDto), HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<BookingDto>  deleteBookingById(@PathVariable Long id) throws Exception {
        bookingService.deleteBookingById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
