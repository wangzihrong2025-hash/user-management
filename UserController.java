#UserController

package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private Map<Long, String> db = new HashMap<>();

    @GetMapping
    public Map<Long, String> getAll() {
        return db;
    }

    @PostMapping
    public String create(@RequestParam Long id, @RequestParam String name) {
        db.put(id, name);
        return "created";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        db.remove(id);
        return "deleted";
    }
}
