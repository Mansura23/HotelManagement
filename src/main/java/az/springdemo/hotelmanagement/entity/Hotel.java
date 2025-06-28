package az.springdemo.hotelmanagement.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Hotel {

    private Long id;
    @NotBlank
    private String hotelName;
    @NotBlank
    private String location;
    private LocalDateTime createTime;
}
