package az.emrah.librarymanagment.controller;

import az.emrah.librarymanagment.model.BookModel;
import az.emrah.librarymanagment.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookModel createBook(@RequestBody BookModel bookModel) {
        return bookService.createBook(bookModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookModel> getAllBooks() {
        return bookService.getAllBooks();
    }
}
