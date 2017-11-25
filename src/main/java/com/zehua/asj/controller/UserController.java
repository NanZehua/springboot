package com.zehua.asj.controller;

import com.zehua.asj.bean.User;
import com.zehua.asj.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/index")
//    public String test() {
//        return "Hello World!";
//    }

    @GetMapping("/insertInfo")
    @ResponseBody
    public User insertInfo() {

        User user = new User();
        user.setPhone("123");
        user.setUserHead("123");
        user.setAge(24);
        user.setName("nanzehau");
        return userRepository.save(user);
    }
//    @RequestMapping(value="/get",method = RequestMethod.GET)
//    public List<User> getAllTodos(){
//        return todoRepository.findAll();
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public User createTodo(@Valid @RequestBody User todo){
//        return todoRepository.save(todo);
//    }
//
//    @RequestMapping(value="{id}", method = RequestMethod.GET)
//    public ResponseEntity<User> findOne(@PathVariable("id") Long id){
//        User todo = todoRepository.findOne(id);
//        if(todo == null){
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<User>(todo,HttpStatus.OK);
//    }
//
//    @RequestMapping(value="{id}", method = RequestMethod.PUT)
//    public ResponseEntity<User> updateTodo(@Valid @RequestBody User todo, @PathVariable("id") Long id){
//        User todoDb = todoRepository.findOne(id);
//        if(todoDb == null){
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//        else{
//            todoDb.setTitle(todo.getTitle());
//            todoDb.setCompleted(todo.getCompleted());
//            todoDb = todoRepository.save(todoDb);
//            return new ResponseEntity<User>(todoDb,HttpStatus.OK);
//        }
//    }
//
//    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
//    public void deleteTodo(@PathVariable("id") Long id) {
//        todoRepository.delete(id);
//    }
}
