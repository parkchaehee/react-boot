package com.khit.book.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khit.book.entity.Book;
import com.khit.book.service.BookService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@RestController
public class BookContoller {

	private final BookService bookService;
	
	//ResponseEntity<?> : body+ header(200, 404)
	//body - String, Object
	// @RequestBody Book book - 입력폼의 데이터(json 형태)
	@PostMapping("/book")
	public ResponseEntity<?> save(@RequestBody Book book) {
		String resultText = bookService.save(book);
		return new ResponseEntity<>(resultText, HttpStatus.OK);
		
	}
	
	//도서목록
	@GetMapping("/book")
	public ResponseEntity<?> bookList(){
		List<Book> bookList = bookService.findAll();
		return new ResponseEntity<>(bookList, HttpStatus.OK);
	}
	//도서상세보기
	@GetMapping("/book/{id}")
	public ResponseEntity<?> bookOne(@PathVariable Long id){
		Book book = bookService.findId(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	//도서삭제 - deleteById()
	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Long id){
		String resultText = bookService.deleteById(id);
		return new ResponseEntity<>(resultText, HttpStatus.OK);
	}
	
	//도서수정
	@PutMapping("/book")
	public ResponseEntity<?> updateBook(@RequestBody Book book){
		String resultText = bookService.update(book);
		return new ResponseEntity<>(resultText, HttpStatus.OK);
	}
	
}
