package az.springdemo.hotelmanagement.controller;

import az.springdemo.hotelmanagement.entity.Hotel;
import az.springdemo.hotelmanagement.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/v1/hotels")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @GetMapping
    public List<Hotel> getHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping(path = "/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    @PostMapping
    public Hotel saveHotel(@Valid @RequestBody Hotel hotel) {
        return hotelService.save(hotel);
    }

    @PutMapping(path = "/{id}")
    public Hotel updateHotel(@Valid @PathVariable Long id, @RequestBody Hotel hotel) {
        return hotelService.update(id, hotel);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.delete(id);

    }


}
