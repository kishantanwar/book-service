package com.epam.book.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.book.exception.ServiceException;
import com.epam.book.model.Book;
import com.epam.book.repositories.BookRepository;


@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book saveBookDetail(Book book) {

		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) throws ServiceException, Exception {

		Book bookId = bookRepository.getOne(book.getId());

		if (bookId != null) {
			return bookRepository.saveAndFlush(book);
		} else {
			throw new Exception("No record found with book Id : "+book.getId());
		}
	}

	@Override
	public Book getBookDetailById(Long bookId) {
		return bookRepository.findById(bookId)
				.orElseThrow(() -> new EntityNotFoundException("No record found with this book Id : " + bookId));
	}

	
	@Override
	public void deleteBooks(Long bookId) throws ServiceException {
		bookRepository.deleteById(bookId);
	}
}