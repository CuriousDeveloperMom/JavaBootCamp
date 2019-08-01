package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    protected TaskerDao taskerDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Task> taskList = taskerDao.getAllTasks();

        taskList.stream()
                .forEach(task -> taskerDao.deleteTask(task.getId()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createTask() {
    }

    @Test
    public void getTask() {
    }

    @Test
    public void addGetDeleteTask() {

        Task task = new Task();

        task.setDescription("This is about Web Development");
        task.setCreateDate(LocalDate.of(2012,12,12));
        task.setDueDate(LocalDate.of(2012,12,20));
        task.setCategory("General");

        task = taskerDao.createTask(task);

        Task task1 = taskerDao.getTask(task.getId());
        assertEquals(task, task1);
        taskerDao.deleteTask(task.getId());
        task1 = taskerDao.getTask(task.getId());
        assertNull(task1);
    }

    @Test
    public void getAllTasks() {
        Task task = new Task();

        task.setDescription("This is about Web Development");
        task.setCreateDate(LocalDate.of(2012,12,12));
        task.setDueDate(LocalDate.of(2012,12,20));
        task.setCategory("General");

        taskerDao.createTask(task);

        task = new Task();

        task.setDescription("This is about Web Development");
        task.setCreateDate(LocalDate.of(2012,12,12));
        task.setDueDate(LocalDate.of(2012,12,20));
        task.setCategory("General");

        taskerDao.createTask(task);

        List<Task> taskList = taskerDao.getAllTasks();

        assertEquals(taskList.size(), 2);
    }

    @Test
    public void getTasksByCategory() {
        Task task = new Task();

        task.setDescription("This is about Web Development");
        task.setCreateDate(LocalDate.of(2012,12,12));
        task.setDueDate(LocalDate.of(2012,12,20));
        task.setCategory("General");

        taskerDao.createTask(task);

        task = new Task();

        task.setDescription("This is about Web Designing");
        task.setCreateDate(LocalDate.of(2010,10,12));
        task.setDueDate(LocalDate.of(2010,12,20));
        task.setCategory("General");

        taskerDao.createTask(task);

        task = new Task();

        task.setDescription("This is about Web Development");
        task.setCreateDate(LocalDate.of(2010,10,12));
        task.setDueDate(LocalDate.of(2010,12,20));
        task.setCategory("Class");

        taskerDao.createTask(task);

        List<Task> taskList = taskerDao.getTasksByCategory("General");
        assertEquals(2, taskList.size());

        taskList = taskerDao.getTasksByCategory("Class");
        assertEquals(1, taskList.size());

        taskList = taskerDao.getTasksByCategory("Private");
        assertEquals(0, taskList.size());


    }

    @Test
    public void updateTask() {
        Task task = new Task();

        task.setDescription("This is about Web Development");
        task.setCreateDate(LocalDate.of(2012,12,12));
        task.setDueDate(LocalDate.of(2012,12,20));
        task.setCategory("General");

        task = taskerDao.createTask(task);

        //task = new Task();

        task.setDescription("This is about Building a code");
        task.setCreateDate(LocalDate.of(2010,10,10));
        task.setDueDate(LocalDate.of(2010,12,25));
        task.setCategory("Coding");

        taskerDao.updateTask(task);

        Task task1 = taskerDao.getTask(task.getId());

        assertEquals(task1, task);
    }

    @Test
    public void deleteTask() {
    }
}