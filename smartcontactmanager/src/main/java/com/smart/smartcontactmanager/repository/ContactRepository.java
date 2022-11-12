package com.smart.smartcontactmanager.repository;

import com.smart.smartcontactmanager.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
