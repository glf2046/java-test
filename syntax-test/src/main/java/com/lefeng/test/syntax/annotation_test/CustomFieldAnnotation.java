package com.lefeng.test.syntax.annotation_test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
public @interface CustomFieldAnnotation {
}
