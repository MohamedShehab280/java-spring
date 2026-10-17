package com.eventia.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Section 3: الـ Spring Core الحقيقية.
 *
 * @ComponentScan بيلف على الـ package ده وكل اللي تحته ويلاقي اللي عليه
 * @Component لوحده. من غير basePackages بيبدأ من package الكلاس ده نفسه.
 */
@Configuration
@ComponentScan(basePackages = "com.eventia")
public class AppConfig {
}
