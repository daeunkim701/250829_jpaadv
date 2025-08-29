package com.example.jpaadv.model.dto;

import com.example.jpaadv.model.entity.Post;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

// Form - jsp에서의 el태그나 thymeleaf에서의 object 기능을 쓸 때 getter setter가 필수인 것처럼
public class PostDTO {
    // nested class
    // form 요청을 받기 위한 class
//    @Getter
//    @Setter
//    @NoArgsConstructor
    @Data
    // 걍 Data로 대체
    public static class SaveRequest {
        private String title; // ID, audit(CreatedAt, UpdatedAt 같은 거 안 넣어줘도 됨 JPA가 다 해줌)
        private String content;
        private String author;

        // DTO -> Entity로 변환하기
        public Post toEntity() {
            return Post.builder()
                    .title(title)
                    .content(content)
                    .author(author) // 순서 바뀌어도 ㄱㅊ
                    .build();
        }
    }
    // 외부로 데이터가 나가기 위한 class -> Record
    public record Response(Long id, String title, String content, String author, LocalDateTime createdAt, LocalDateTime updatedAt) {
        public Response fromEntity(Post post) {
            return new Response(
                    post.getId(),
                    post.getTitle(),
                    post.getContent(),
                    post.getAuthor(),
                    post.getCreatedAt(),
                    post.getUpdatedAt()
            );
        }
    }
}
