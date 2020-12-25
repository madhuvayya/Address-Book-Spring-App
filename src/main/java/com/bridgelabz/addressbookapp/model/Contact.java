package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import lombok.Data;

public @Data class Contact {
    private int contactId;
    private String name;
    private String phoneNumber;

    public Contact(int contactId,ContactDTO contactDTO) {
        this.contactId = contactId;
        this.name = contactDTO.name;
        this.phoneNumber = contactDTO.phoneNumber;
    }
}
