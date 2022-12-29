package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * PostsSaveRequestDto.java
 * Class 설명을 작성하세요.
 *
 * @author Lim BY
 * @since 2022.12.28
 */

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Entity 클래스를 Request/Response 클래스로 사용해서는 안 됩니다.
    // 왜냐하면 Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스이기 때문입니다.
    // Entity 클래스를 기준으로 테이블이 생성되고, 스키마가 변경됩니다.
    // 따라서 데이터를 주고 받는 DTO 클래스에 Entity 생성자를 생성해줍니다.
    // 결국 중요한 것은 View Layer와 DB Layer의 역할 분리를 철저하게 하는게 좋습니다.
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
