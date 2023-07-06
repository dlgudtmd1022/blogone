package com.spring.blogone.controller;

import com.spring.blogone.entity.Blog;
import com.spring.blogone.exception.NotFoundBlogIdException;
import com.spring.blogone.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private  BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "blog/list";
    }

    @RequestMapping("/detail/{blogId}")
    public String detail(@PathVariable long blogId, Model model){
        Blog blog = blogService.findById(blogId);

        if(blog == null){
            try {
                throw new NotFoundBlogIdException("없는 blogId로 조회했습니다. 조회번호 : " + blogId);
            } catch(NotFoundBlogIdException e){
                return "blog/NotFoundBlogIdException";
            }
        }

        model.addAttribute("blog", blog);

        return "/blog/detail";
    }

    @GetMapping("/insert")
    public String insert(){
        return "blog/blog-form";
    }

    @PostMapping("/insert")
    public String insert(Blog blog){
        blogService.save(blog);
        return "redirect:/blog/list";
    }

    @PostMapping("/delete")
    public String delete(long blogId){
        blogService.deleteById(blogId);
        return "redirect:/blog/list";
    }

    @PostMapping("/updateform")
    public String update(long blogId, Model model){
        Blog blog = blogService.findById(blogId);
        model.addAttribute("blog", blog);
        return "blog/blog-update-form";
    }

    @PostMapping("update")
    public String update(Blog blog){
            blogService.update(blog);
        return "redirect:blog/detail" + blog.getBlogId();
    }
}