package com.example.jpaadv.model.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 이걸 상속하는 엔티티에 추상필드들을 컬럼으로 포함
@EntityListeners(AuditingEntityListener.class) // Audit 감사(createdAt, updateAt..)
public abstract class BaseTimeEntity {
    @CreatedBy
    private LocalDateTime createdAt;
    @LastModifiedBy
    private LocalDateTime updatedAt;

}
