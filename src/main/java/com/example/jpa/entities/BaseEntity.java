package com.example.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Data
@MappedSuperclass // 여러 Entity 가 공유하는 속성을 모으기 위한 상위 Entity 임을 나타내는 어노테이션
@EntityListeners(AuditingEntityListener.class) // Entity 의 변화를 지켜볼 클래스 정의
public class BaseEntity {
    // 생성일
    @CreatedDate
    @Column(updatable = false)
    private Instant createdAt;

    // 수정일
    @LastModifiedDate
    @Column(unique = true)
    private Instant updateAt;
}
