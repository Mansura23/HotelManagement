package az.springdemo.hotelmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "hotel",schema = "hotels_management")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "hotel_name")
    private String hotelName;
    @NotBlank
    @Column(name = "location")
    private String location;
    @CreationTimestamp
    @Column(name = "Create_at")
    private LocalDateTime createAt;
    @OneToMany(mappedBy = "hotel" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;

}
