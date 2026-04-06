#UserController

package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private Map<Long, String> db = new HashMap<>();

    // 取得全部
    @GetMapping
    public Map<Long, String> getAll() {
        return db;
    }

    // 新增
    @PostMapping
    public String create(@RequestParam Long id, @RequestParam String name) {
        db.put(id, name);
        return "created";
    }

    // 取得單一
    @GetMapping("/{id}")
    public String getById(@PathVariable Long id) {
        return db.getOrDefault(id, "not found");
    }

    // 更新
    @PutMapping
    public String update(@RequestParam Long id, @RequestParam String name) {
        db.put(id, name);
        return "updated";
    }

    // 刪除
    @DeleteMapping
    public String delete(@RequestParam Long id) {
        db.remove(id);
        return "deleted";
    }

    // 筆數
    @GetMapping("/count")
    public int count() {
        return db.size();
    }
}
