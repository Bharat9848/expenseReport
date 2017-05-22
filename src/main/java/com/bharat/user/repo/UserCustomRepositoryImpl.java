package com.bharat.user.repo;

import org.springframework.stereotype.Component;

/**
 * Created by BharatBh on 2/1/2017.
 */
public class UserCustomRepositoryImpl implements UserCustomRepository {
    @Override
    public void customMethod() {
        System.out.println("custom method");
    }
}
