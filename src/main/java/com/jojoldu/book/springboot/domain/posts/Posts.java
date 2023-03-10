package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Posts.java
 * Class 게시판 Domain
 *
 * @author Lim BY
 * @since 2022.12.28
 */

@Getter // (6)
@NoArgsConstructor // (5)
@Entity // (1)
public class Posts extends BaseTimeEntity{

    @Id // (2)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // (3)
    private Long id;

    @Column(length = 500, nullable = false) // (4)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // (7)
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

/* 코드 설명
** 필자는 어노테이션 순서를 "주요 어노테이션을 클래스에 가깝게" 둡니다.
*
* (1) @Entity
*  - 테이블과 링크될 클래스임을 나타냅니다.
*  - 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭합니다. ex) SalesManager.java -> sales_manager table
*
* (2) @Id
*  - 해당 테이블의 PK 필드를 나타냅니다.
*
* (3) @GeneratedValue
*  - PK의 생성 규칙을 나타냅니다.
*  - 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 됩니다.
*
* (4) @Column
*  - 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됩니다.
*  - 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용합니다.
*  - 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex.title), 타입을 TEXT로 변경하고 싶거나(ex.content)등의 경우에 사용됩니다.
*
* (5) @NoArgsConstructor
*  - 기본 생성자 자동 추가
*  - public Posts() {} 와 같은 효과
*
* (6) @Getter
*  - 클래스 내 모든 필드의 Getter 메소드를 자동생성
*
* (7) @Builder
*  - 해당 클래스의 빌더 패턴 클래스를 생성
*  - 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
* */