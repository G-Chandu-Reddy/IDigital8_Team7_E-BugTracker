package com.ebugtracker.admin.entity;

import com.ebugtracker.admin.constants.BugPriority;
import com.ebugtracker.admin.constants.BugStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketNo;
    @Enumerated(EnumType.STRING)
    private BugPriority bugPriority;
    @NotBlank
    @Length(max = 1000, min = 1)
    private String snippet;
    private String remedy;
    @Enumerated(EnumType.STRING)
    private BugStatus bugStatus;
    @NotBlank
    @Length(max = 15, min = 1)
    private String relatedDepartment;

}
