package ua.ithillel.lombok;

import lombok.Builder;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Log4j
@Builder
//@Builder(toBuilder = true)
public class LombokBuilderExample {
    private final String name;
    private final Integer age;
}
