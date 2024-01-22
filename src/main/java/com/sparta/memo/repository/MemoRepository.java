package com.sparta.memo.repository;

import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Component // 해당 클래스를 bean으로 만듦
public interface MemoRepository extends JpaRepository<Memo,Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();
    List<Memo> findAllByContentsContainsOrderByModifiedAtDesc(String keyword);
//    List<Memo> findAllByUsername(String username);
}