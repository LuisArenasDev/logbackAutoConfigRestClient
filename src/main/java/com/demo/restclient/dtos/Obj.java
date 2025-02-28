package com.demo.restclient.dtos;

import lombok.Data;

@Data
public class Obj {
        String firstName;
        String lastName;

        public Obj(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

}

