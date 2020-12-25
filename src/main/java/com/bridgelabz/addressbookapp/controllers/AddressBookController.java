package com.bridgelabz.addressbookapp.controllers;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getAllContacts(){
        List<Contact> contactList = addressBookService.getContactsData();
        ResponseDTO responseDTO = new ResponseDTO("GET REST call to get all contact is successful",contactList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable("contactId") int contactId){
        Contact contact = addressBookService.getContactById(contactId);
        ResponseDTO responseDTO = new ResponseDTO("GET REST Call for contact id "+ contactId +" is successful",contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createContact(@RequestBody ContactDTO contactDTO){
        log.debug("Received request for creating new contact with data:",contactDTO.toString());
        Contact contact = addressBookService.createContact(contactDTO);
        log.debug("New contact is created.");
        ResponseDTO responseDTO = new ResponseDTO("POST REST call for creating contact is successful",contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable("contactId") int contactId,
                                                     @RequestBody ContactDTO contactDTO){
        log.debug("Received request for updating existing contact with data:",contactDTO.toString());
        Contact contact = addressBookService.updateContact(contactId,contactDTO);
        log.debug("Contact is Updated");
        ResponseDTO responseDTO = new ResponseDTO("PUT RETS call for updating contact is successful",contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("contactId") int contactId){
        log.debug("Received request for deleting contact with id:", contactId);
        addressBookService.deleteContact(contactId);
        log.debug("Contact "+ contactId +" deleted.");
        ResponseDTO responseDTO = new ResponseDTO("DELETE REST call for deleting contact is successful","Deleted Id: "+ contactId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
