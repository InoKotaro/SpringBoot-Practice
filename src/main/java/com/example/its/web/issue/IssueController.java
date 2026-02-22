package com.example.its.web.issue;

import com.example.its.domain.issue.IssueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//プレゼンテーション層
//ユーザーと直接やり取りする部分

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
    public String showCreationForm(@ModelAttribute IssueForm form) {
        //@ModelAttribute を使うと
        //model.addAttribute("issueForm", new IssueForm()); と一緒にできる
        return "issues/creationForm";
    }

    // POST /issues
    // @Validated バリデーション指示
    @PostMapping
    public String create(@Validated IssueForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }

        issueService.create(form.getSummary(), form.getDescription());
        //return に"redirect:/issues"を指定すると2重サブミット対策できる（PRGパターン）
        return "redirect:/issues";
    }
}
