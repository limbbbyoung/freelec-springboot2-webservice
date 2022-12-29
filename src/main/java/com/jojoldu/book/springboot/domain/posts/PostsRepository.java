package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostsRepository.java
 * Class 설명을 작성하세요.
 *
 * @author Lim BY
 * @since 2022.12.28
 */

public interface PostsRepository extends JpaRepository<Posts, Long> { // 보통 ibatis나 Mybatis 등에서 Dao라고 불리는 DB Layer 접근자입니다.
                                                                        // Entity 클래스와 기본 Entity Repository는 함께 위치
                                                                        // 기본 Repository 없이는 제대로 역할을 할 수가 없습니다.

}
