package com.ebugtracker.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long customerId;
    @NotBlank
    @Length(max = 20, min = 1)
    String customerName;
    @ElementCollection
    List<String> messagesReceived;
    @ElementCollection
    Set<Long> ticketsRaised;
}
