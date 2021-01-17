package com.bridgelabz.addressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AddressBookApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(AddressBookApplication.class, args);
        log.info("AddressBook App started in {} Environment",
                context.getEnvironment().getProperty("environment"));
    }

}
