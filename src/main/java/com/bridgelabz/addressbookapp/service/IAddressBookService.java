package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.ContactData;

import java.util.List;

public interface IAddressBookService {

    List<ContactData> getContactsData();

    ContactData getContactById(int contactId);

    ContactData createContact(ContactDTO contactDTO);

    ContactData updateContact(int contactId, ContactDTO contactDTO);

    void deleteContact(int contactId);
}
