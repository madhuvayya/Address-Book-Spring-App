package com.bridgelabz.addressbookapp.dto;

import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public @ToString class ContactDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Name is Invalid")
    public String name;

    @NotNull(message = "Phone number cannot be null.")
    public String phoneNumber;

    public String address;

    public String city;

    public String state;

    public String zipcode;
}
