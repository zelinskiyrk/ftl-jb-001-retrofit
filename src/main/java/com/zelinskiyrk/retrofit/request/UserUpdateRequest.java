package com.zelinskiyrk.retrofit.request;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class UserUpdateRequest {
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
        private UserUpdateRequest.Geo geo;
    }

    @AllArgsConstructor
    public static class Company{
        private String name;
        private String catchPhrase;
        private String bs;
    }


    private String name;
    private String username;
    private String email;
    private UserUpdateRequest.Address address;
    private String phone;
    private String website;
    private UserUpdateRequest.Company company;
}
