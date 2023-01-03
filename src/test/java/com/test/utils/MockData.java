package com.test.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class MockData {

    private Faker faker = new Faker(new Locale("en-GB"));

    public String getFirstName(){ return faker.name().firstName();   }
    public String getSurName(){ return faker.name().lastName();   }
    public String getCity(){ return faker.address().cityName();   }
    public String getCountry(){ return faker.address().country();   }
    public String getMobileNumber(){ return faker.phoneNumber().cellPhone();   }
    public String getEmailAddress(){ return faker.bothify("????##@domesticandgeneral.com");   }

}
