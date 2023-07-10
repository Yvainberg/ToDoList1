package com.example.demo.servise;

import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date; // Correct import for Date

import jakarta.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.ToDoList;
import com.example.demo.models.ToDoListModel;

@Service
public class ToDoListServise {

    // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    ToDoListModel ToDoListModel;

    // @Autowired
    // ToDoList todolist;

    public List findAll() throws Exception {
        List list = ToDoListModel.findAll();
        return list;
    }

    public ToDoList create(Map<String, Object> jsonBody) throws Exception {
        System.out.println("create servise ###" + jsonBody);
        ToDoList todolist = new ToDoList();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String name = (String) jsonBody.get("name");
        String description = (String) jsonBody.get("description");
        Date startDate = new Date(dateFormat.parse((String) jsonBody.get("startdate")).getTime());
        Date endDate = new Date(dateFormat.parse((String) jsonBody.get("enddate")).getTime());
        Integer categoryId = Integer.parseInt((String) jsonBody.get("category_id"));
      
        // Date startDate = dateFormat.parse(startDateString);
        // Date endDate = dateFormat.parse(endDateString);

        todolist.setName(name);
        todolist.setDescription(description);
        todolist.setStartdate(startDate);
        todolist.setEnddate(endDate);
        todolist.setCategory_id(categoryId);

        System.out.println("======");
        return ToDoListModel.createDoList(todolist);

      
    }

    public void delete(Map<String, Integer> jsonBody) throws Exception {
        Integer id = jsonBody.get("id");
        ToDoListModel.delete(id);
    }

    public void update(Map<String, Object> jsonBody) throws Exception {
        System.out.println("updata servise 1" + jsonBody);

        ToDoList todolist = new ToDoList();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Integer id = (Integer) jsonBody.get("id");
        String name = (String) jsonBody.get("name");
        String description = (String) jsonBody.get("description");
        Date startDate = new Date(dateFormat.parse((String) jsonBody.get("startdate")).getTime());
        Date endDate = new Date(dateFormat.parse((String) jsonBody.get("enddate")).getTime());
        Integer categoryId = Integer.parseInt((String) jsonBody.get("category_id"));

        todolist.setId(id);
        todolist.setName(name);
        todolist.setDescription(description);
        todolist.setStartdate(startDate);
        todolist.setEnddate(endDate);
        todolist.setCategory_id(categoryId);
        System.out.println("updata servise 2");
        ToDoListModel.upData(todolist);

    }

    public ToDoList findByID(Map<String, Object> index) throws Exception {
        System.out.println("findByID servise");
        Integer id = (Integer) index.get("id");
        return ToDoListModel.findByID(id);

    }

    public Integer getTotalPages() throws Exception {
        System.out.println("getTotalPages servise");
        return ToDoListModel.getTotalPages();
    }

    public List<ToDoList> getItemPages(Map<String, Object> page) throws Exception {
        System.out.println("getItemPages servise");
        Integer pages = (Integer) page.get("page");

        return ToDoListModel.getItemPages(pages);
    }

   

    public Integer countByStartDate(Map<String, Object> startdate) throws Exception {
        System.out.println(" countByStartDate servise");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilStartDate = dateFormat.parse((String) startdate.get("startdate"));
        java.sql.Date startDate = new java.sql.Date(utilStartDate.getTime());
        System.out.println("countByStartDate -- " + startDate);
        return ToDoListModel.countByStartDate(startDate);
    }

}
