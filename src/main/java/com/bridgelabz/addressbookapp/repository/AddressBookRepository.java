package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.ContactData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<ContactData, Integer> {
}
