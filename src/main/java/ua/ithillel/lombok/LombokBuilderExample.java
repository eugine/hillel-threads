package ua.ithillel.lombok;

import lombok.RequiredArgsConstructor;

//@Builder
//@Builder(toBuilder = true)
@RequiredArgsConstructor
public class LombokBuilderExample {
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String gender;
    private final String education;
    private final Address address;

    @RequiredArgsConstructor
    public static class Address {
        private final String address;
        private final String line1;
        private final String line2;
        private final String city;
        private final String region;
        private final String country;
        private final String zipCode;
    }
}
