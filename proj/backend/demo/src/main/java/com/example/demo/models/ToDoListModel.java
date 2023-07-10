package com.example.demo.models;

import java.sql.Date;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;



@Transactional
interface Repository_ToDoList extends JpaRepository<ToDoList, Integer> {

    @Query(value = "SELECT COUNT(*) FROM my_table", nativeQuery = true)
    Integer getTotalItemCount();

    @Query(value = "SELECT * FROM my_table  LIMIT 5 OFFSET ((?1 - 1) * 5)", nativeQuery = true)
    List<ToDoList> getItemPages(Integer page);
    
    @Query(value = "SELECT COUNT (*) FROM my_table WHERE startdate =?1", nativeQuery = true)
    Integer countByStartDate(Date startDate);

}


@Service
public class ToDoListModel {
    @Autowired
    Repository_ToDoList repository_ToDoList;

    public ToDoList createDoList(ToDoList ToDoList)throws Exception {
        try {
            System.out.println("create to do list");
            return repository_ToDoList.save(ToDoList);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<ToDoList> findAll()throws Exception {
        try {
            return repository_ToDoList.findAll();
        } catch (Exception e) {
             throw e;
        }
    }

    public void delete(Integer id) throws Exception {
        try {
            repository_ToDoList.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void upData(ToDoList ToDoList) throws Exception {
        try {
            System.out.println("up data model");
            repository_ToDoList.save(ToDoList);
        } catch (Exception e) {
            throw e;
        }
    }

    public ToDoList findByID(Integer x) throws Exception {
        try {
            System.out.println("findByID modle");
            return repository_ToDoList.findById(x).get();
        } catch (Exception e) {
            System.out.println("eroor by find by id " + e);
            throw e;
        }
    }

    // calculates the total number of pages needed for pagination based on the total
    // item count and a specified number of items per page
    public Integer getTotalPages() throws Exception {
        try {
            System.out.println("Total pages model");
            Integer totalItems = repository_ToDoList.getTotalItemCount();
            return (int) Math.ceil(totalItems / 5.0);
        } catch (Exception e) {
            System.out.println("Error by total pages: " + e);
            throw e;
        }
    }

    public List<ToDoList> getItemPages(Integer page) throws Exception {
        try {
            System.out.println("getItemPages model  "+ page);
            return repository_ToDoList.getItemPages(page);
        } catch (Exception e) {
            System.out.println("Error by getItemPages: " + e);
            throw e;
        }
    }

    public Integer countByStartDate(Date startDate)throws Exception{
        try {
            return repository_ToDoList.countByStartDate(startDate);
        } catch (Exception e) {
             System.out.println("Error by countByStartDate: " + e);
            throw e;
    }
    }

   
    

   


}
