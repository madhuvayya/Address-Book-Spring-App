package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import lombok.Data;

public @Data class Contact {
    private int contactId;
    private String name;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipcode;

    public Contact(int contactId,ContactDTO contactDTO) {
        this.contactId = contactId;
        this.name = contactDTO.name;
        this.phoneNumber = contactDTO.phoneNumber;
        this.address = contactDTO.address;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.zipcode = contactDTO.zipcode;
    }
}
