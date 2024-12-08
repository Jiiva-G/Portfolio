package com.amizhth.entitymodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "contact")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String message;
    private boolean active = true;  // Default active status
}
