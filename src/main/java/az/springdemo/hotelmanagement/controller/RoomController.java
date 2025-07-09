package az.springdemo.hotelmanagement.controller;

import az.springdemo.hotelmanagement.dto.Roomdto;
import az.springdemo.hotelmanagement.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @GetMapping()
    public ResponseEntity<List<Roomdto>> getAllRooms( @RequestParam("hotelId") Long hotelId) {
        return new ResponseEntity<>(roomService.getAllRooms(hotelId), HttpStatus.OK);
    }
    @GetMapping(path = "{id}")
    public ResponseEntity<Roomdto> getRoomById(@Valid @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(roomService.getRoomById(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Roomdto> createRoom(@Valid @RequestBody Roomdto room) throws Exception {
        return new ResponseEntity<>(roomService.createRoom(room), HttpStatus.OK);
    }
    @PutMapping(path = "{id}")
    public ResponseEntity<Roomdto> updateRoom(@PathVariable Long id,@Valid @RequestBody Roomdto dtoRoom) throws Exception {
        return  new ResponseEntity<>(roomService.updateRoom(id, dtoRoom), HttpStatus.OK);
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Roomdto> deleteRoom(@PathVariable Long id) throws Exception {
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
