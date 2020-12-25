package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.ContactDTO;

public class Contact {
    private int contactId;
    private String name;
    private String phoneNumber;

    public Contact(int contactId,ContactDTO contactDTO) {
        this.contactId = contactId;
        this.name = contactDTO.name;
        this.phoneNumber = contactDTO.phoneNumber;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
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
