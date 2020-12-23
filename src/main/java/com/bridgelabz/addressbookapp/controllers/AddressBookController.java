package com.bridgelabz.addressbookapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<String> getAllContacts(){
        return new ResponseEntity<String>("GET REST call for all contact is successful", HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<String> getContactById(@PathVariable("contactId") int contactId){
        return new ResponseEntity<String>("GET REST Call for contact id "+ contactId +" is successful", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createContact(){
        return new ResponseEntity<String>("POST REST call for creating contact is successful", HttpStatus.OK);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<String> updateContact(@PathVariable("contactId") int contactId){
        return new ResponseEntity<String>("PUT RETS call for updating contact is successful", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable("contactId") int contactId){
        return new ResponseEntity<String>("DELETE REST call for deleting contact is successful", HttpStatus.OK);
    }
}
