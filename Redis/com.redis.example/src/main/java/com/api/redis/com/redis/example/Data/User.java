package com.api.redis.com.redis.example.Data;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {

    private String userId;
    private String name;
    private String age;
    private String email;

}
