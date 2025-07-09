package az.springdemo.hotelmanagement.service;

import az.springdemo.hotelmanagement.dto.HotelDto;
import az.springdemo.hotelmanagement.entity.Hotel;
import az.springdemo.hotelmanagement.exception.HotelNotFound;
import az.springdemo.hotelmanagement.repostory.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    private static final Logger logger = LoggerFactory.getLogger(HotelService.class);

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;

    }
    public List<HotelDto> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        logger.info("Hotel List: {}", hotels.size());
        List<HotelDto> hotelDtos = new ArrayList<>();
        for (Hotel hotel : hotels) {
            HotelDto hotelDto = new HotelDto();
            BeanUtils.copyProperties(hotel, hotelDto);
            hotelDtos.add(hotelDto);
        }
        return hotelDtos;

    }
    public HotelDto getHotelById(Long id) {
       Optional<Hotel> optional=hotelRepository.findById(id);
        if (optional.isPresent()) {
            Hotel hotel = optional.get();
            HotelDto hotelDto = new HotelDto();
            BeanUtils.copyProperties(hotel, hotelDto);
            return hotelDto;
        }
        throw new HotelNotFound("Hotel Not Found with "+ id);
    }
    public HotelDto createHotel(HotelDto hotelDto) throws Exception {
      Optional<Hotel> optional=hotelRepository.findById(hotelDto.getId());
      if (optional.isPresent()) {
          throw new Exception("Hotel Already Exists");
      }
      Hotel hotel = new Hotel();
      BeanUtils.copyProperties(hotelDto, hotel);
      Hotel savedHotel = hotelRepository.save(hotel);
      return hotelDto;
    }
    public void deleteHotelById(Long id) {
        hotelRepository.deleteById(id);

    }
    public HotelDto updateHotel(HotelDto hotelDto, Long id) {
        Optional<Hotel> optional=hotelRepository.findById(id);
        if (optional.isPresent()) {
            Hotel hotel = optional.get();
            BeanUtils.copyProperties(hotelDto, hotel);
            Hotel savedHotel = hotelRepository.save(hotel);
            return hotelDto;
        }
        throw new HotelNotFound("Hotel Not Found with "+ id);
    }

}
