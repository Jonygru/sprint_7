package org.example.courier;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.courier.Courier;

public class CourierGenerator {
    public Courier generic(){
        return new Courier(RandomStringUtils.randomAlphabetic(3,8), "12345", "oleg");
    }
}
