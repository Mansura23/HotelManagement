package az.springdemo.hotelmanagement.repostory;

import az.springdemo.hotelmanagement.entity.Hotel;
import az.springdemo.hotelmanagement.exception.HotelNotFound;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class HotelRepository {
    private final HashMap<Long, Hotel> dataSources;

    public HotelRepository(HashMap<Long, Hotel> dataSources) {
        this.dataSources = dataSources;
    }


    public List<Hotel> getAllHotels() {
        for (Hotel hotel : dataSources.values()) {
            if (hotel == null) {
                throw new HotelNotFound("Hotel not found");
            }
        }
        return new ArrayList<Hotel>(dataSources.values());
    }

    public Hotel getHotel(Long id) {
        if (!dataSources.containsKey(id)) {
            throw new HotelNotFound("Hotel not found");
        }
        return dataSources.get(id);
    }

    public Hotel saveHotel(Hotel hotel) {
        return dataSources.put(hotel.getId(), hotel);
    }

    public Hotel updateHotel(Long id, Hotel hotel) {
        if (dataSources.containsKey(id)) {
            dataSources.put(id, hotel);
            return hotel;
        }
        throw new HotelNotFound("Hotel not found");

    }

    public void deleteHotel(Long id) {
        Hotel deletedHotel = getHotel(id);
        if (deletedHotel != null) {
            dataSources.remove(deletedHotel.getId());
        }
    }

}
