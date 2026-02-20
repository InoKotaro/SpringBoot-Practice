package com.example.its.web.issue;

import com.example.its.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import com.example.its.domain.issue.IssueEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//コントローラーにはアノテーション必要
@Controller
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    //get issue
    //@GetMapping("/issues") で指定するのがURL直結
    @GetMapping("/issues")
    public String showList(Model model) {
        model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }
}
