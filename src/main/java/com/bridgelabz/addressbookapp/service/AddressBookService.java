package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Override
    public List<Contact> getContactsData() {
        List<Contact> contactList = new ArrayList<>();
        Contact contact = new Contact(1, new ContactDTO("Rajesh","7894561233"));
        contactList.add(contact);
        return contactList;
    }

    @Override
    public Contact getContactById(int contactId) {
        Contact contact = new Contact(contactId, new ContactDTO("Rajesh","7894561233"));
        return contact;
    }

    @Override
    public Contact createContact(ContactDTO contactDTO) {
        Contact contact = new Contact(1, contactDTO);
        return contact;
    }

    @Override
    public Contact updateContact(int contactId, ContactDTO contactDTO) {
        Contact contact = new Contact(contactId, contactDTO);
        return contact;
    }

    @Override
    public void deleteContact(int contactId) { }
}
