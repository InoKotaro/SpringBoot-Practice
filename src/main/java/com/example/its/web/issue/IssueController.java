package com.example.its.web.issue;

import org.springframework.ui.Model;
import com.example.its.domain.issue.IssueEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//コントローラーにはアノテーション必要
@Controller
public class IssueController {

    //get issue
//@GetMapping("/issues") で指定するのがURL直結
    @GetMapping("/issues")
    public String showList(Model model) {
        List<IssueEntity> issueList = List.of(
                new IssueEntity(1, "概要", "説明１"),
                new IssueEntity(2, "概要", "説明２"),
                new IssueEntity(3, "概要", "説明３")

        );

        model.addAttribute("issueList", issueList);
        return "issues/list";
    }
}
