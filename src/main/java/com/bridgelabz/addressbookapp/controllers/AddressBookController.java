package com.bridgelabz.addressbookapp.controllers;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
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
        Contact contact = addressBookService.createContact(contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("POST REST call for creating contact is successful",contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable("contactId") int contactId,
                                                     @RequestBody ContactDTO contactDTO){
        Contact contact = addressBookService.updateContact(contactId,contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("PUT RETS call for updating contact is successful",contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("contactId") int contactId){
        addressBookService.deleteContact(contactId);
        ResponseDTO responseDTO = new ResponseDTO("DELETE REST call for deleting contact is successful","Deleted Id: "+ contactId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
