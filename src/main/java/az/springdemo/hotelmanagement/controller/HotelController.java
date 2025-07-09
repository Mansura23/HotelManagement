package az.springdemo.hotelmanagement.controller;

import az.springdemo.hotelmanagement.dto.HotelDto;
import az.springdemo.hotelmanagement.service.HotelService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/hotels")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
   public ResponseEntity<List<HotelDto>> getAllHotels() {
        List<HotelDto> hotelDtos = hotelService.getAllHotels();
        return new ResponseEntity<>(hotelDtos, HttpStatus.OK);
    }

   @GetMapping("{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long id) {
        HotelDto hotelDto = hotelService.getHotelById(id);
        return new ResponseEntity<>(hotelDto, HttpStatus.OK);
   }
   @PostMapping
   @SneakyThrows
    public ResponseEntity<HotelDto> createHotel(@RequestBody @Valid HotelDto hotelDto) {
        hotelDto = hotelService.createHotel(hotelDto);
        return new ResponseEntity<>(hotelDto, HttpStatus.OK);
   }
   @DeleteMapping("{id}")
    public void deleteHotelById(@PathVariable Long id) {
        hotelService.deleteHotelById(id);
   }
   @PutMapping("{id}")
    public ResponseEntity<HotelDto> updateHotelById(@PathVariable Long id, @RequestBody @Valid HotelDto hotelDto) {
        hotelDto=hotelService.updateHotel(hotelDto, id);
        return new ResponseEntity<>(hotelDto, HttpStatus.OK);
   }




}
