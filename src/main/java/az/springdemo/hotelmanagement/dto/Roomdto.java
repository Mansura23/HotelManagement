package az.springdemo.hotelmanagement.dto;

import az.springdemo.hotelmanagement.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roomdto {
    private String roomNumber;
    private Double price;
    private String status;
    private Long hotelId;
}
