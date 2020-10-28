package com.zelinskiyrk.retrofit.request;

import com.zelinskiyrk.retrofit.response.UserResponse;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class UserCreateRequest {
    @AllArgsConstructor
    public static class Geo{
        private String lat;
        private String lng;
    }

    @AllArgsConstructor
    public static class Address{
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private UserCreateRequest.Geo geo;
    }

    @AllArgsConstructor
    public static class Company{
        private String name;
        private String catchPhrase;
        private String bs;
    }


    private int id;
    private String name;
    private String username;
    private String email;
    private UserCreateRequest.Address address;
    private String phone;
    private String website;
    private UserCreateRequest.Company company;
}
