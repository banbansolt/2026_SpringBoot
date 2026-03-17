package kr.ac.kopo.minn.bookmarket.service;

import kr.ac.kopo.minn.bookmarket.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBookList();
}