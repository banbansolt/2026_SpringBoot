package kr.ac.kopo.minn.bookmarket.controller;


import kr.ac.kopo.minn.bookmarket.domain.Book;
import kr.ac.kopo.minn.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/books") // 클래스 전체의 기본 주소를 /books로 설정 (권장)
public class BookController {

    @Autowired
    private BookService bookService;

    // 접속 주소: http://localhost:8080/books
    @GetMapping // 클래스 수준의 /books 주소를 그대로 사용
    public String requestBookList(Model model){
        List<Book> listOfBooks = bookService.getAllBookList();
        model.addAttribute("bookList", listOfBooks);
        return "books";
    }

    // 접속 주소: http://localhost:8080/books/book?id=isbn1001
    @GetMapping("/book")
    public String requestBookById(@RequestParam("id") String bookId, Model model){
        Book book = bookService.getBookById(bookId);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/{category}")
    public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
        List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
        model.addAttribute("bookList", booksByCategory);
        return "books";
    }

//    localhost:8080/BookMarket/books/filter/bookFilter;publisher=길벗캠퍼스;category=IT전문서,IT교육교재
    @GetMapping("/filter/{bookFilter}")
    public String requestBooksByFilter(@MatrixVariable(pathVar = "bookFilter") Map<String, List<String>> bookFilter, Model model){
        Set<Book> bookByFilter = bookService.getBookListByFilter(bookFilter);
        model.addAttribute("bookList",bookByFilter);
        return "books";
    }

    // 접속 주소: http://localhost:8080/books/all
    @GetMapping("/all")
    public ModelAndView requestAllBooks(){
        ModelAndView modelAndView = new ModelAndView();
        List<Book> list = bookService.getAllBookList();
        modelAndView.addObject("bookList", list);
        modelAndView.setViewName("books");
        return modelAndView;
    }
}