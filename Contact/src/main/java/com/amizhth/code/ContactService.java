package com.amizhth.code;

import com.amizhth.entitymodel.ContactModel;
import com.amizhth.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactDTO save(ContactDTO contactDTO) {
        // Map ContactDTO to ContactModel
        ContactModel contactModel = ContactModel.builder()
                .name(contactDTO.getName())
                .email(contactDTO.getEmail())
                .message(contactDTO.getMessage())
                .build();

        // Save the ContactModel entity
        contactRepository.save(contactModel);

        // Return the same ContactDTO after saving (You may modify this as needed)
        contactDTO.setResponseMessage("Contact saved successfully!");
        return contactDTO;
    }
}
