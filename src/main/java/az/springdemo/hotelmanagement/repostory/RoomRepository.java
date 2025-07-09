package az.springdemo.hotelmanagement.repostory;

import az.springdemo.hotelmanagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoomRepository  extends JpaRepository<Room, Long> {

}
