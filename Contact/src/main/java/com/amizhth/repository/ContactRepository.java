package com.amizhth.repository;

import com.amizhth.entitymodel.ContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amizhth.entitymodel.ContactModel;
@Repository
public interface ContactRepository extends JpaRepository<ContactModel, Long> {

    ContactModel findByIdAndActive(long id, boolean active);
}
