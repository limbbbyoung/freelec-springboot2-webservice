package com.jojoldu.book.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * BaseTimeEntity.java
 * Class 설명을 작성하세요.
 *
 * @author Lim BY
 * @since 2022.12.29
 */

@Getter
@MappedSuperclass // (1)
@EntityListeners(AuditingEntityListener.class) // (2)
public class BaseTimeEntity {

    @CreatedDate // (3)
    private LocalDateTime createdDate;

    @LastModifiedDate // (4)
    private LocalDateTime modifiedDate;
}

/* 코드 설명
* (1) @MappedSuperclass
*  - JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들(createdDate,
*       modifiedDate)도 칼럼으로 인식하도록 합니다.
*
* (2) @EntityListeners(AuditingEntityListener.class)
*  - BaseTimeEntity 클래스에 Auditing 기능을 포함
*
* (3) @CreatedDate
*  - Entity가 생성되어 저장될 때 시간이 자동 저장됩니다.
*
* (4) @LastModifiedDate
*  - 조회한 Entity의 값을 변경할 때 시간이 자동 저장됩니다.
* */
