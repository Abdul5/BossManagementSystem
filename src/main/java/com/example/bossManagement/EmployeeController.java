package com.example.bossManagement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();
    private List<Boss> bosses = new ArrayList<>();

    //POST : add an employee
    @PostMapping("/employees")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return ResponseEntity.ok("Employee added Successfully.");
    }
    //POST: Add a boss
    @PostMapping("/bosses")
    public ResponseEntity<String> addBoss(@RequestBody Boss boss) {
        bosses.add(boss);
        return ResponseEntity.ok("Boss added Successfully.");
    }
    //PUT: Update boss salaries
    @PutMapping("/bosses/salaries")
    public ResponseEntity<String> updateBossSalaries(@RequestParam int increment,@RequestParam int minRating) {
        for(Boss boss : bosses) {
            if(boss.getRating() > minRating) {
                boss.setSalary(boss.getSalary() + increment);
            }
        }
        return ResponseEntity.ok("Boss salaries updated Successfully.");
    }
    //GET: Get employees based on age and rating
    @GetMapping("/employees/filter")
    public ResponseEntity<List<Employee>> filterEmployees(@RequestParam int age,@RequestParam int minRating) {
        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.getAge() < age && e.getRating() > minRating)
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredEmployees);
    }
    //GET: Count employees based on bossRating and employee rating
    @GetMapping("/employees/count")
    public ResponseEntity<Integer> countEmployees(@RequestParam int minBossRating, @RequestParam int minEmployeeRating) {
        long count = employees.stream()
                .filter(e -> e.getRating() > minEmployeeRating && getBossRating(e.getBossId()) > minBossRating)
                .count();
        return ResponseEntity.ok(Math.toIntExact(count));
    }

    //Helper method to get boss rating based on bossId
    private int getBossRating(int bossId) {
        for(Boss boss : bosses) {
            if (boss.getId() == bossId) {
                return boss.getRating();
            }
        }
        return 0;
    }

}
