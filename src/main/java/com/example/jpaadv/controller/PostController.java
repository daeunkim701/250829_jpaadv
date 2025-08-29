package com.example.jpaadv.controller;

import com.example.jpaadv.model.dto.PostDTO;
import com.example.jpaadv.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor // 의존성주입
@RequestMapping("/posts") // posts -> get, post...
public class PostController {
    private final PostService postService;

    @GetMapping // ("/")
    public String list(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "post/list"; // resources/templates/post/list.html
    }

    @GetMapping("/new") // ("/")
    public String createForm(Model model) {
        model.addAttribute("post", new PostDTO.SaveRequest());
        return "post/form"; // resources/templates/post/form.html
    }

    @PostMapping // ("/")
    public String create(@ModelAttribute("post") PostDTO.SaveRequest dto) {
        postService.save(dto);
        return "redirect:/posts"; // resources/templates/post/list.html
    }
}