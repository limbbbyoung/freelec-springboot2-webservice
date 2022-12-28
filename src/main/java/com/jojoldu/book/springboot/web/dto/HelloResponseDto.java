package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

/**
 * HelloResponseDto.java
 * Class 설명을 작성하세요.
 *
 * @author Lim BY
 * @since 2022.12.28
 */

@Getter // (1)
@RequiredArgsConstructor //(2)
public class HelloResponseDto {

    private final String name;
    private final int amount;
}

/* 코드 설명
(1) @Getter
 - 선언된 모든 필드의 get 메서드를 생성해 줍니다.
(2) @RequiredArgsConstructor
 - 선언된 모든 final 필드가 포함된 생성자를 생성해 줍니다.
 - final이 없는 필드는 생성자에 포함되지 않습니다.
* */



