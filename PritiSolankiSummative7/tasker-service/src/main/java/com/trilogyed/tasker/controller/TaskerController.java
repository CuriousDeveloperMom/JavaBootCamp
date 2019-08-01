package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.Exception.NotFoundException;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@RefreshScope
@RestController
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    //    Create a new task:
//    ------------------
//    URI: /tasks
//    HTTP Method: POST
//    RequestBody: JSON TaskViewModel information (minus advertisement)
//    ResponseBody: JSON TaskViewModel information (including ID and advertisement)

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TaskViewModel createTask(@RequestBody @Valid TaskViewModel taskViewModel) {

        taskViewModel = service.newTask(taskViewModel);

        return taskViewModel;
    }


//    Find task by ID:
//            ----------------
//    URI: /tasks/{id}
//    HTTP Method: GET
//    RequestBody: None
//    ResponseBody: JSON TaskViewModel information (including ID and advertisement)

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TaskViewModel getTaskById(@PathVariable("id") int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be greater than 0.");
        }

        TaskViewModel taskViewModel = service.fetchTask(id);

        if (taskViewModel == null)
            throw new NotFoundException("Task could not be retrived for id " + id);
        return taskViewModel;
    }


//    Delete task:
//    ------------
//    URI: /tasks/{id}
//    HTTP Method: DELETE
//    RequestBody: None
//    Responsebody: None

    @RequestMapping(value = "/tasks{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable("id") int id) {
        service.deleteTask(id);
    }

    //    Update a task:
//    --------------
//    URI: /tasks
//    HTTP Method: PUT
//    RequestBody: JSON TaskViewModel information (including ID and advertisement)
//    ResponseBody: None

    @RequestMapping(value = "/tasks/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@PathVariable("id") int id, @RequestBody @Valid TaskViewModel taskViewModel) {
        // make sure the Id on the path matches the id of the task object
        if (taskViewModel.getId() == 0)
            taskViewModel.setId(id);
        if (id != taskViewModel.getId()) {
            throw new IllegalArgumentException("Task ID on path must match the ID in the Task object.");
        }
        service.updateTask(taskViewModel);
    }

//    Find all tasks:
//    ---------------
//    URI: /tasks
//    HTTP Method: GET
//    RequestBody: None
//    ResponseBody: JSON List of TaskViewModels (including ID and advertisement)

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> getAllTasks() {
        List<TaskViewModel> taskViewModelList = service.fetchAllTasks();
        if (taskViewModelList != null && taskViewModelList.size() == 0)
            throw new NotFoundException("Tasks could not be retrieved");
        return taskViewModelList;
    }

//    Find tasks by category:
//    -----------------------
//    URI: /tasks/category/{category}
//    HTTP Method: GET
//    RequestBody: None
//    ResponseBody: JSON List of TaskViewModels (including ID and advertisement)

    @RequestMapping(value = "/tasks/category/{category}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> getTaskByCategory(@PathVariable("category") String category) {
        List<TaskViewModel> taskViewModelList = service.fetchTasksByCategory(category);
        if (taskViewModelList != null && taskViewModelList.size() == 0)
            throw new NotFoundException("Task could not be retrieved for category " + category);
        return taskViewModelList;
    }

}
