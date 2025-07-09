package az.springdemo.hotelmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private String customerName;
    private String customerEmail;
    private Date startDate;
    private Date endDate;
    private String status;
    private Date createdAt;
    private Long roomId;
}
