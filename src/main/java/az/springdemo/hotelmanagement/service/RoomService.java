package az.springdemo.hotelmanagement.service;

import az.springdemo.hotelmanagement.dto.Roomdto;
import az.springdemo.hotelmanagement.entity.Hotel;
import az.springdemo.hotelmanagement.entity.Room;
import az.springdemo.hotelmanagement.repostory.HotelRepository;
import az.springdemo.hotelmanagement.repostory.RoomRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;


    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }
   public List<Roomdto> getAllRooms(Long hotelId) {
        return roomRepository.findAll().stream()
                .filter(p ->p.getHotel().getId().equals(hotelId))
                .map(this::maptoDto)
                .collect(Collectors.toList());
   }
   public Roomdto getRoomById(Long roomId) throws Exception {
       Optional<Room> optional = roomRepository.findById(roomId);
       if (optional.isPresent()) {
           return maptoDto(optional.get());
       }
       throw new Exception("Not found");

   }
   public Roomdto createRoom(Roomdto dtoRoom) throws Exception {
       Hotel hotel=hotelRepository.findById(dtoRoom.getHotelId()).orElseThrow(() -> new Exception("Not found"));
       Room room=new Room();
       BeanUtils.copyProperties(dtoRoom,room);
       room.setHotel(hotel);
       return maptoDto(roomRepository.save(room));

   }
   public Roomdto updateRoom(Long roomId, Roomdto dtoRoom) throws Exception {
        Optional<Room> optional = roomRepository.findById(roomId);
        Optional<Hotel> optionalHotel=hotelRepository.findById(dtoRoom.getHotelId());
        if (optional.isPresent() && optionalHotel.isPresent()) {
            Room room=optional.get();
            Hotel hotel=optionalHotel.get();
            BeanUtils.copyProperties(dtoRoom,room);
            room.setHotel(hotel);
            return maptoDto(roomRepository.save(room));
        }
        throw new Exception("Not found");

   }
   public void deleteRoom(Long roomId) throws Exception {
        Room room=roomRepository.findById(roomId).orElseThrow(() -> new Exception("Not found"));
        roomRepository.delete(room);
   }

   public Roomdto maptoDto(Room room) {
        Roomdto roomDto = new Roomdto();
        roomDto.setRoomNumber(room.getRoomNumber());
        roomDto.setPrice(room.getPrice());
        roomDto.setStatus(room.getStatus());
        roomDto.setHotelId(room.getHotel().getId());
        return roomDto;

   }


}
