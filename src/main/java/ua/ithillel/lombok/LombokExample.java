package ua.ithillel.lombok;

import lombok.*;

import java.io.IOException;

@Getter
@Setter
@ToString
@EqualsAndHashCode
//@Value
//@NoArgsConstructor
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class LombokExample {
    @Getter(AccessLevel.PACKAGE)
    private String name;
    private int age;



    public static void throwCheckedException() {
//        throw new IOException("test");
    }

}
