package com.bridgelabz.addressbookapp.dto;

import com.bridgelabz.addressbookapp.annotations.Address;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public @ToString class ContactDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Name is Invalid")
    public String fullName;

    @Pattern(regexp = "^([+])?(91)?[6-9]{1}[0-9]{9,11}$", message = "Entered invalid phone number")
    public String phoneNumber;

    @NotBlank(message = "Address can't be empty")
    @Address(message = "Address is not valid.")
    public String address;

    @NotBlank(message = "City can't be empty")
    public String city;

    @NotBlank(message = "State can't be empty")
    public String state;

    @NotBlank(message = "State can't be empty")
    public String zipcode;
}
