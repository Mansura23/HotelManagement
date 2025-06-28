package az.springdemo.hotelmanagement.service;

import az.springdemo.hotelmanagement.entity.Hotel;
import az.springdemo.hotelmanagement.repostory.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    public List<Hotel> getAllHotels() {
        return hotelRepository.getAllHotels();
    }
    public Hotel getHotelById(Long id) {
        return hotelRepository.getHotel(id);
    }
    public Hotel save(Hotel hotel) {
        return hotelRepository.saveHotel(hotel);
    }
    public Hotel update(Long id,Hotel hotel) {
        return hotelRepository.updateHotel(id, hotel);

    }
    public void delete(Long id) {
        hotelRepository.deleteHotel(id);
    }
}
