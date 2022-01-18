package com.ebugtracker.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.crypto.Mac;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long staffId;
    @NotBlank
    @Length(max = 15, min = 1)
    private String staffName;
    @NotBlank
    @Length(max = 10, min = 1)
    private String department;
    @ElementCollection
    Set<Long> assignedTicketIds;
}
