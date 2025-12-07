package com.hrservices.hrservicesbackend.Controllers;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @PostMapping
    public Map<String, String> chat(@RequestBody Map<String, String> req) {
        var msg = req.getOrDefault("message", "").toLowerCase();
        String reply =
                msg.contains("leave") ? "You have 12 leave days remaining this year." :
                        msg.contains("salary") ? "Your net salary for this month is ₹53,000." :
                                msg.contains("attendance") ? "You were present 22 days this month." :
                                        "I can help with attendance, payroll, leave, rewards, and tasks. Try: 'Show my attendance'.";
        return Map.of("reply", reply);
    }
}