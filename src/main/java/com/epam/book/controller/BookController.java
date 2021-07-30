package com.epam.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.book.exception.ServiceException;
import com.epam.book.model.Book;
import com.epam.book.services.BookService;
import com.epam.book.utils.API_JSONInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/books")
@Api(value ="Book Registration")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Book registered Successfully"),
			@ApiResponse(code = 401, message = "You are not authorized to registered the book"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 400, message = "Bad Request")
	})
	@ApiOperation(value = "Register Book", notes=API_JSONInput.API_BOOK_CREATE)
	@PostMapping()
	public Book createBookDetail(@RequestBody Book book)  throws ServiceException {
		
		return bookService.saveBookDetail(book);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully updated Book details"),
			@ApiResponse(code = 401, message = "You are not authorized to updated Book"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 400, message = "Bad Request")
	})
	@ApiOperation(value = "Update Book Detail"/* , notes= APIJSONInput.API_BOOK_CREATE */)
	@PutMapping(value="/{bookId}")
	public Book updateBook(@PathVariable("bookId") Long bookId, @RequestBody Book book) throws ServiceException, Exception {
		
		book.setId(bookId);
		return bookService.updateBook(book);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Book registered Successfully"),
			@ApiResponse(code = 401, message = "You are not authorized to registered the book"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 400, message = "Bad Request")
	})
	@ApiOperation(value ="Get book detail")
	@GetMapping("/{bookId}")
	public Book getBookDetail(@PathVariable("bookId") Long bookId)  throws ServiceException {
		
		return bookService.getBookDetailById(bookId);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully delete book detail(s)"),
			@ApiResponse(code = 401, message = "You are not authorized to delete book details"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 400, message = "Bad Request")
	})
	@ApiOperation(value ="delete book(s) profile")
	@DeleteMapping("/{bookId}")
	public void deleteBooks(@PathVariable("bookId") Long bookId) throws ServiceException {

		bookService.deleteBooks(bookId) ;
	}
}