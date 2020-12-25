package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    List<Contact> contactList = new ArrayList<>();

    @Override
    public List<Contact> getContactsData() {
        return contactList;
    }

    @Override
    public Contact getContactById(int contactId) {
        return contactList.get(contactId-1);
    }

    @Override
    public Contact createContact(ContactDTO contactDTO) {
        Contact contact = new Contact(contactList.size()+1, contactDTO);
        contactList.add(contact);
        return contact;
    }

    @Override
    public Contact updateContact(int contactId, ContactDTO contactDTO) {
        Contact contact = this.getContactById(contactId);
        contact.setName(contactDTO.name);
        contact.setPhoneNumber(contactDTO.phoneNumber);
        contactList.set(contactId-1, contact);
        return contact;
    }

    @Override
    public void deleteContact(int contactId) {
        contactList.remove(contactId-1);
    }
}
