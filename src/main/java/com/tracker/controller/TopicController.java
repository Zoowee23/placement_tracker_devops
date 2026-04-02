package com.tracker.controller;

import com.tracker.entity.Topic;
import com.tracker.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    /**
     * GET /  — show the main page with all topics and an empty form
     */
    @GetMapping
    public String index(Model model) {
        model.addAttribute("topics", topicService.getAllTopics());
        model.addAttribute("newTopic", new Topic()); // blank form object
        return "index"; // resolves to templates/index.html
    }

    /**
     * POST /add  — handle form submission to add a new topic
     */
    @PostMapping("/add")
    public String addTopic(@Valid @ModelAttribute("newTopic") Topic topic,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            // Re-render the page with validation errors
            model.addAttribute("topics", topicService.getAllTopics());
            return "index";
        }
        topicService.addTopic(topic);
        return "redirect:/"; // PRG pattern to avoid duplicate submissions
    }

    /**
     * GET /complete/{id}  — mark a topic as completed
     */
    @GetMapping("/complete/{id}")
    public String completeTopic(@PathVariable Long id) {
        topicService.markCompleted(id);
        return "redirect:/";
    }

    /**
     * GET /delete/{id}  — delete a topic
     */
    @GetMapping("/delete/{id}")
    public String deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return "redirect:/";
    }
}
