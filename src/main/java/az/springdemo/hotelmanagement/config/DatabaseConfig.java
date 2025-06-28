package az.springdemo.hotelmanagement.config;

import az.springdemo.hotelmanagement.entity.Hotel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.HashMap;

@Configuration
public class DatabaseConfig {
    @Bean
    public HashMap<Long, Hotel> dataSources() {
        HashMap<Long, Hotel> map = new HashMap<>();
        map.put(1l, new Hotel(1l, "Marriot", "Baku", LocalDate.of(2016, 06, 12)));
        return map;
    }

}
