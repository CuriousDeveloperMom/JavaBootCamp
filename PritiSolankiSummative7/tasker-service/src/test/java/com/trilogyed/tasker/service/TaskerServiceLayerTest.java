package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TaskerServiceLayerTest {

    private TaskerDao taskerDao;
    private TaskerServiceLayer service;
    private RestTemplate restTemplate;
    private DiscoveryClient discoveryClient;

    @Before
    public void setUp() throws Exception {
        setUpTaskerDaoMock();
        service = new TaskerServiceLayer(taskerDao);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveFindTask() {

        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setDescription("This is about Web");
        taskViewModel.setCreateDate(LocalDate.of(2019,12,10));
        taskViewModel.setDueDate(LocalDate.of(2019,12,15));
        taskViewModel.setCategory("General");
        taskViewModel.setAdvertisement("Advertisement");

        taskViewModel = service.newTask(taskViewModel);
        TaskViewModel fromService = service.fetchTask(taskViewModel.getId());
        assertEquals(taskViewModel, fromService);
    }

    @Test
    public void fetchTask() {
    }

    @Test
    public void fetchAllTasks() {
        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setId(1);
        taskViewModel.setDescription("This is about Web");
        taskViewModel.setCreateDate(LocalDate.of(2019,12,10));
        taskViewModel.setDueDate(LocalDate.of(2019,12,15));
        taskViewModel.setCategory("General");
        taskViewModel.setAdvertisement("Advertisement");

        List<TaskViewModel> tshirtsViewModels = service.fetchAllTasks();
        assertEquals(tshirtsViewModels.size(),1);
    }

    @Test
    public void fetchTasksByCategory() {
        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setDescription("This is about Web");
        taskViewModel.setCreateDate(LocalDate.of(2019,12,10));
        taskViewModel.setDueDate(LocalDate.of(2019,12,15));
        taskViewModel.setCategory("General");
        taskViewModel.setAdvertisement("Advertisement");

        taskViewModel = service.newTask(taskViewModel);
        List<TaskViewModel> taskViewModelList = service.fetchTasksByCategory("General");
        assertEquals(taskViewModelList.size(),1);
        //assertEquals(taskViewModelList.get(0), taskViewModel);

    }

    @Test
    public void newTask() {
    }

    @Test
    public void deleteTask() {
    }

    @Test
    public void updateTask() {
    }
    private void setUpTaskerDaoMock(){
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task = new Task();

        task.setId(1);
        task.setDescription("This is about Web");
        task.setCreateDate(LocalDate.of(2019,12,10));
        task.setDueDate(LocalDate.of(2019,12,15));
        task.setCategory("General");

        Task task1 = new Task();

        task1.setDescription("This is about Web");
        task1.setCreateDate(LocalDate.of(2019,12,10));
        task1.setDueDate(LocalDate.of(2019,12,15));
        task1.setCategory("General");


        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        doReturn(task).when(taskerDao).createTask(task1);
        doReturn(task).when(taskerDao).getTask(1);
        doReturn(taskList).when(taskerDao).getAllTasks();
        doReturn(taskList).when(taskerDao).getTasksByCategory(task.getCategory());
    }

}