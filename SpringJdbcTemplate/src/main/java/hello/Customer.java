package hello;

import lombok.AllArgsConstructor;
import lombok.Data;

public @Data @AllArgsConstructor class Customer {
    private long id;
    private String firstName, lastName;
}

