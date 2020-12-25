package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public @Data class ContactDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Name is Invalid")
    public String name;

    @NotNull(message = "Phone number cannot be null.")
    public String phoneNumber;

    public ContactDTO(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
