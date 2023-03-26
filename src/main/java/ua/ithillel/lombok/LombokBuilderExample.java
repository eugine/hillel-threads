package ua.ithillel.lombok;

import lombok.Builder;

@Builder
//@Builder(toBuilder = true)
public class LombokBuilderExample {
    private final String name;
    private final Integer age;
}
