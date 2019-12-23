package com.example.airbnb;

import com.example.airbnb.service.CategoryHouseService;
import com.example.airbnb.service.CategoryRoomService;
import com.example.airbnb.service.impl.CategoryHouseImpl;
import com.example.airbnb.service.impl.CategoryRoomImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirbnbApplication {

    @Bean
    public CategoryRoomService categoryRoomService(){
        return new CategoryRoomImpl();
    }
    @Bean
    public CategoryHouseService categoryHouseService(){
        return new CategoryHouseImpl();
    }
    public static void main(String[] args) {
        SpringApplication.run(AirbnbApplication.class, args);
    }

}
