package com.SimpleInMemDbWebflux.model;

import lombok.*;

@Data
@ToString
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private long id;
    private String name;
}
