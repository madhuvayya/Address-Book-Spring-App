package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.ContactDTO;

public class Contact {

    private String name;
    private String phoneNumber;

    public Contact(int contactId, ContactDTO contactDTO) {
        this.name = contactDTO.name;
        this.phoneNumber = contactDTO.phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
