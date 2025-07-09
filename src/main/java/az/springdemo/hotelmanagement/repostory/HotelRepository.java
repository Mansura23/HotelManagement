package az.springdemo.hotelmanagement.repostory;

import az.springdemo.hotelmanagement.entity.Hotel;
import az.springdemo.hotelmanagement.exception.HotelNotFound;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public interface HotelRepository  extends JpaRepository<Hotel, Long> {




}
