package com.epam.book.services;

import com.epam.book.exception.ServiceException;
import com.epam.book.model.Book;

public interface BookService {

	Book saveBookDetail(Book book)  throws ServiceException;

	Book getBookDetailById(Long bookId)  throws ServiceException;

	Book updateBook(Book book)  throws ServiceException, Exception;

	void deleteBooks(Long bookId) throws ServiceException;

}
