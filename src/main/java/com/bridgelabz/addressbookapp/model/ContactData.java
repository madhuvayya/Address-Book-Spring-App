package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "contacts_data")
public @Data class ContactData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id")
    private int contactId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String address;

    private String city;

    private String state;

    private String zipcode;

    public ContactData() { }

    public ContactData(ContactDTO contactDTO) {
        this.fullName = contactDTO.fullName;
        this.phoneNumber = contactDTO.phoneNumber;
        this.address = contactDTO.address;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.zipcode = contactDTO.zipcode;
    }
}
