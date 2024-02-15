package com.khit.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.khit.book.entity.Book;
import com.khit.book.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {

	private final BookRepository bookRepository;

	public String save(Book book) {
		bookRepository.save(book);
		return "도서등록완료";
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findId(Long id) {
		//찾는 아이디가 없을때 예외 처리
		return bookRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("찾는 데이터가 없습니다."));
		
		
	}

	public String deleteById(Long id) {
		bookRepository.deleteById(id);
		return "OK"; //리엑트 if(res =="OK") 삭제
	}

	public String update(Book book) {
		//수정된 데이터를 저장
		bookRepository.save(book);
		return "수정완료";
	}
}
