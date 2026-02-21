package com.example.its.web.issue;

import com.example.its.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//コントローラーにはアノテーション必要
@Controller
@RequestMapping("/issues") // ベースURLを /issues に設定が必要
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    // GET /issues
    @GetMapping
    public String showList(Model model) {
        model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }

    // GET /issues/creationForm
    @GetMapping("/creationForm") // パスを明確に指定
    public String showCreationForm() {
        return "issues/creationForm";
    }

    // POST /issues
    @PostMapping
    public String create(IssueForm form, Model model) {
        return showList(model);
    }
}
