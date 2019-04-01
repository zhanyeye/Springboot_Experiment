package com.example.experiment_04.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyInterceptor {
    AuthorityType[] value() default AuthorityType.USER;
    public static enum AuthorityType {
        USER, ADMIN, SUPERADMIN;
    }
}
