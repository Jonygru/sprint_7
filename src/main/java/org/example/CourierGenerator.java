package org.example;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {
    public Courier generic(){
        return new Courier(RandomStringUtils.randomAlphabetic(3,8), "12345", "oleg");
    }
}
