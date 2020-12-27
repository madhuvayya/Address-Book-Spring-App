package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.ContactData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    List<ContactData> contactList = new ArrayList<>();

    @Override
    public List<ContactData> getContactsData() {
        return contactList;
    }

    @Override
    public ContactData getContactById(int contactId) {
        return contactList.stream()
                .filter(list -> list.getContactId() == contactId)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Contact with id "+ contactId +" is not found."));
    }

    @Override
    public ContactData createContact(ContactDTO contactDTO) {
        ContactData contact = new ContactData(contactDTO);
        contactList.add(contact);
        return addressBookRepository.save(contact);
    }

    @Override
    public ContactData updateContact(int contactId, ContactDTO contactDTO) {
        ContactData contact = this.getContactById(contactId);
        contact = new ContactData(contactDTO);
        contactList.set(contactId-1, contact);
        return contact;
    }

    @Override
    public void deleteContact(int contactId) {
        if (contactId > contactList.size())
            throw new AddressBookException("Contact with id "+ contactId +" is not found.");
        contactList.remove(contactId-1);
    }
}
