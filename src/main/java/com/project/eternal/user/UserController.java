package com.project.eternal.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/test")
    public ResponseEntity<Long> userId() {
        Long userId = userService.getUserId("까푸");
        return ResponseEntity.ok(userId);
    }
}
