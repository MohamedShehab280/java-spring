package com.eventia.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Section 2: @ComponentScan بيلف على الـ package ده ويلاقي اللي عليه
 * @Component لوحده. إحنا مش بنمرّر أي قايمة بإيدنا.
 */
@Configuration
@ComponentScan(basePackages = "com.eventia")
public class AppConfig {
}
