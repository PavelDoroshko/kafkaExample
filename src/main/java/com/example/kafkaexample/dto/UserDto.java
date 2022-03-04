package com.example.kafkaexample.dto;

import com.example.kafkaexample.model.Address;
import lombok.Data;

@Data
public class UserDto {
    private Long age;
    private String name;
    private Address address;
}
