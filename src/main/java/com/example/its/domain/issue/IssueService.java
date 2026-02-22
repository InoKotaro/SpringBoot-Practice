package com.example.its.domain.issue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//ビジネスロジック
//システムの頭脳
@Service
@RequiredArgsConstructor
//@RequiredArgsConstructorはコンストラクタを自動生成してくれる Lombokアノテーション
//public JobController(JobService jobService) {
//  this.jobService = jobService; 省略可
public class IssueService {

    private final IssueRepository issueRepository;

    public List<IssueEntity> findAll() {
        return issueRepository.findAll();
    }

    @Transactional
    //@Transactionalを書くとエラーが起きたらロールバックされる
    public void create(String summary, String description) {
        issueRepository.insert(summary, description);
    }
}
