package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

public @Data class ContactDTO {
    public String name;
    public String phoneNumber;

    public ContactDTO(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
