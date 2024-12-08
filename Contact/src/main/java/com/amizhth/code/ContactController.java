package com.amizhth.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(value = "/save", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO save(@RequestBody ContactDTO contactDTO) {
        return contactService.save(contactDTO);
    }
}
