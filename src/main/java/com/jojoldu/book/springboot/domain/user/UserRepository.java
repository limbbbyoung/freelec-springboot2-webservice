package com.jojoldu.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * UserRepository.java
 *
 * @author Lim BY
 * @since 2023.01.06
 */


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email); // (1)

    /* 코드 설명
    * (1) findByEmail
    * 소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지
    * 판단하기 위한 메소드입니다.
    * */
}
