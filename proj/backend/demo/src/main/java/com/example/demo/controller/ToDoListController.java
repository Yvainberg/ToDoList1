package com.example.demo.controller;

import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.servise.*;
import com.example.demo.models.*;

@RestController
@RequestMapping("todolist")
public class ToDoListController {

    @Autowired
    ToDoListServise ToDoListServise;

    // Get all ToDoList items
    @GetMapping("getAll")
    public ResponseEntity getAll() {
        try {
            List list = ToDoListServise.findAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return null;
        }
    }

    // Create a new ToDoList item
    @PostMapping("create")
    public ResponseEntity<ToDoList> createUser(@RequestBody Map<String, Object> body) {
        try {                       
            ToDoList createdToDoList = ToDoListServise.create(body);
            if (createdToDoList != null) {
                return ResponseEntity.ok(createdToDoList);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Delete a ToDoList item
    @DeleteMapping("delete")
    public void deleteUser(@RequestBody Map<String, Integer> body){
        try {
            ToDoListServise.delete(body);
        } catch (Exception e) {
             System.out.println(e);
        }
    }

    // Update a ToDoList item
    @PutMapping("update")
    public void upDateUser(@RequestBody Map<String,Object> body){
        System.out.println("update controller");
        try {
            ToDoListServise.update(body); 
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Find a ToDoList item by ID
    @PutMapping("findByID")
    public ToDoList  getByID(@RequestBody Map<String, Object> index) {
        try {
            System.out.println("find by id controller");
            return  (ToDoList) ToDoListServise.findByID(index);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // Get the total number of pages for pagination
    @GetMapping("TotalPages")
    public Integer getTotalPages(){
        try {
            System.out.println("TotalPages controller");
            return ToDoListServise.getTotalPages();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    // Get a specific page of ToDoList items
    @PostMapping("getItemPages")
    public List<ToDoList> getItemPages(@RequestBody Map<String, Object> page){
        try {
            System.out.println("getItemPages controller");
            return ToDoListServise.getItemPages(page);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    // Count the number of ToDoList items with a specific start date
    @PostMapping("countByStartDate")
    public Integer countByStartDate(@RequestBody Map<String, Object> startdate){
        try {
            System.out.println("countByStartDate controller");
            return ToDoListServise.countByStartDate(startdate);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
