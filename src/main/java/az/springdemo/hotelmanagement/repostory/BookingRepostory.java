package az.springdemo.hotelmanagement.repostory;

import az.springdemo.hotelmanagement.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepostory  extends JpaRepository<Booking, Long> {



}
