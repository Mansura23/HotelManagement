package az.springdemo.hotelmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Entity
@Table(name = "booking",schema = "hotels_management")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    @NotBlank
    @Column(name = "customer_name")
    private String customerName;
    @NotBlank
    @Email
    @Column(name = "customer_email")
    private String customerEmail;
    @Column(name = "started_date")
    private Date startDate;
    @Column(name = "ended_date")
    private Date endDate;
    @NotBlank
    @Column(name = "status")
    private String status;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createAt;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
