package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Transactional
public class TodoController {

	@Autowired
	private TodoItemRepo todoRepo;
	
	@GetMapping
	public ResponseEntity<List<TodoItem>> tasks(){
		List<TodoItem> items = todoRepo.findAll();
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TodoItem> add(@Valid @RequestBody TodoItem item) {
		TodoItem new_item = todoRepo.save(item);
		return new ResponseEntity<>(new_item, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<TodoItem> update(@Valid @RequestBody TodoItem item) {
		TodoItem new_item = todoRepo.save(item);
		return new ResponseEntity<>(new_item, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		todoRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
