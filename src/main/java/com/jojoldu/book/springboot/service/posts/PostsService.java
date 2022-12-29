package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PostsService.java
 * Class 설명을 작성하세요.
 *
 * @author Lim BY
 * @since 2022.12.28
 */

@RequiredArgsConstructor // @Autowired보다 생성자를 통한 Bean 객체 생성이 좋다. @RequiredArgsConstructor는
                            // final이 선언된 모든 필드를 인자값으로 하는 생성자를 롬복의 @RequiredArgsConstructor가 대신 생성해줌
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) { // 여기서 신기한 것은 update에는 쿼리를 날리는 부분이 없습니다.
        // 이게 가능한 이유는 JPA의 영속성 컨텍스트 때문입니다.
        // * 영속성 컨텍스트란?
        // 엔티티를 영구 저장하는 환경입니다. 일종의 논리적 개념이라고 보시면 되며,
        // JPA의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐로 갈립니다.
        // 트랜잭션 안에서 데이터베이스에서 데이터를 가져오면 해당 데이터는 영속성 컨텍스트가 유지된 상태입니다.
        // 이 상태에서 해당 데이터의 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영
        // 이 개념이 Dirty Checking(더티 체킹)이라고 합니다.

        // 여기에서 Dirty란 상태의 변화가 생긴 정도로 이해하시면 됩니다.
        // 즉, Dirty Checking이란 상태 변경 검사 입니다.
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
