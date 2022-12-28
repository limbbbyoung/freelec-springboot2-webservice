package com.jojoldu.book.springboot;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * HelloResponseDtoTest.java
 * Class 해당 테스트 클래스의 목적은 HelloResponseDto의 @Getter, @RequiredArgsConstructor의 기능 테스트이다.
 *          Dto 클래스에 가보면 getter와 생성자를 따로 만들어주지 않음. 롬복의 어노테이션 기능을 활용하여 현재 getter, 생성자를 활용할 수 있음
 *
 * @author Lim BY
 * @since 2022.12.28
 */

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name); // (1), (2)
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

/* 코드 설명
(1) assertThat
 - assertj라는 테스트 검증 라이브러리의 검증 메소드입니다.
 - 검증하고 싶은 대상을 메소드 인자로 받습니다.
 - 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있습니다.

(2) isEqualTo
 - assertj의 동등 비교 메소드입니다.
 - assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공입니다.
*
* */