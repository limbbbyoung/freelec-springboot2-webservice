package com.jojoldu.book.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * JpaConfig.java.
 *
 * @author Lim BY
 * @since 2023.01.11
 */

@Configuration
@EnableJpaAuditing // JPA Auditing 활성화
public class JpaConfig { }
