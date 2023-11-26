package data;

import com.github.javafaker.Faker;

public class UserData {
    Faker faker = new Faker();
    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male","Female","Other"),
            mobile = String.valueOf(faker.number().digits(10)),
            subject = faker.options().option("Maths", "Chemistry", "Computer science"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            year = String.valueOf(faker.number().numberBetween(1970, 2005)),
            day = String.valueOf(faker.number().numberBetween(1, 28)),
            address = faker.address().streetAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setCity(state);
            public String setCity(String value) {
            switch (value) {
                case "NCR":
                    return faker.options().option("Delhi", "Gurgaon", "Noida");
                case "Uttar Pradesh":
                    return faker.options().option("Agra", "Lucknow", "Merrut");
                case "Haryana":
                    return faker.options().option("Karnal", "Panipat");
                case "Rajasthan":
                    return faker.options().option("Jaipur", "Jaiselmer");
                default:
                    return "State error";
            }
            }


}
