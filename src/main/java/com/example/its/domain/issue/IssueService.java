package com.example.its.domain.issue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@RequiredArgsConstructorはコンストラクタを自動生成してくれる Lombokアノテーション
//public JobController(JobService jobService) {
//        this.jobService = jobService; 省略可
public class IssueService {

    private final IssueRepository issueRepository;

    public List<IssueEntity> findAll() {
        return issueRepository.findAll();
    }
}
