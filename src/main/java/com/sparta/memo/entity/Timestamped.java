package com.sparta.memo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) //자동으로 시간이 추가됨
public abstract class Timestamped { // 이것 자체를 객체로 생성할 일은 없기 때문에

    @CreatedDate
    @Column(updatable = false) // 업데이트가 안 되게 수정
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate // 조회한 엔티티 값을 변경할때
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifiedAt;

//    DATE : 2023 - 01- 01
//    TIME : 20:21:14
//    TIMESTAMP : 2023 - 01- 01 20:21:13.99999
}