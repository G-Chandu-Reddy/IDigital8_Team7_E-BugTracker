package com.ebugtracker.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBugRequest {
    @NotBlank
    @Length(min = 1 ,max = 10)
    private String bugPriority;
    @NotBlank
    @Length(min = 1 ,max = 1000)
    private String snippet;
    @NotBlank
    @Length(min = 1 ,max = 15)
    private String relatedDepartment;

}
