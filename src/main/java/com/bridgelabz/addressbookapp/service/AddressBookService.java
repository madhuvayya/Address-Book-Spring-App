package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.ContactData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<ContactData> getContactsData() {
        return addressBookRepository.findAll();
    }

    @Override
    public ContactData getContactById(int contactId) {
        return addressBookRepository
                .findById(contactId)
                .orElseThrow( () -> new AddressBookException("Contact with contactId" + contactId
                        + " does not exists...!!!"));
    }

    @Override
    public ContactData createContact(ContactDTO contactDTO) {
        ContactData contact = new ContactData(contactDTO);
        return addressBookRepository.save(contact);
    }

    @Override
    public ContactData updateContact(int contactId, ContactDTO contactDTO) {
        ContactData contact = this.getContactById(contactId);
        contact.updateContactData(contactDTO);
        return addressBookRepository.save(contact);
    }

    @Override
    public void deleteContact(int contactId) {
        ContactData contactData = this.getContactById(contactId);
        addressBookRepository.delete(contactData);
    }
}
