package az.springdemo.hotelmanagement.service;

import az.springdemo.hotelmanagement.dto.BookingDto;
import az.springdemo.hotelmanagement.entity.Booking;
import az.springdemo.hotelmanagement.entity.Room;
import az.springdemo.hotelmanagement.repostory.BookingRepostory;
import az.springdemo.hotelmanagement.repostory.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final BookingRepostory bookingRepostory;
    private final RoomRepository roomRepository;
    public BookingService(BookingRepostory bookingRepostory, RoomRepository roomRepository) {
        this.bookingRepostory = bookingRepostory;
        this.roomRepository = roomRepository;
    }
    public List<BookingDto> getAllBookings() {
        return bookingRepostory.findAll().stream()
                .map(this::maptoBookingDto)
                .collect(Collectors.toList());
    }
    public BookingDto getBookingById(Long id) throws  Exception {
        Optional<Booking> booking = bookingRepostory.findById(id);
        if (booking.isPresent()) {
            return maptoBookingDto(booking.get());
        }
        throw new Exception("Booking not found");

    }

    public BookingDto saveBooking(BookingDto bookingDto) throws Exception {
       Optional<Room> optional=roomRepository.findById(bookingDto.getRoomId());
       if(optional.isPresent()) {
           Room room = optional.get();
           Booking booking = new Booking();
           BeanUtils.copyProperties(bookingDto, booking);
           booking.setRoom(room);
           bookingRepostory.save(booking);
           return maptoBookingDto(booking);
       }
       throw  new Exception("Room not found");

    }
    public void deleteBookingById(Long id) throws  Exception {
       Optional<Booking> optional = bookingRepostory.findById(id);
        if(optional.isPresent()) {
            Booking booking = optional.get();
            bookingRepostory.delete(booking);
        }
        throw  new Exception("Booking not found");

    }
    public BookingDto maptoBookingDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setCustomerName(booking.getCustomerName());
        bookingDto.setCustomerEmail(booking.getCustomerEmail());
        bookingDto.setStartDate(booking.getStartDate());
        bookingDto.setEndDate(booking.getEndDate());
        bookingDto.setStatus(booking.getStatus());
        bookingDto.setCreatedAt(booking.getCreateAt());
        bookingDto.setRoomId(booking.getRoom().getId());

        return bookingDto;

    }
}
