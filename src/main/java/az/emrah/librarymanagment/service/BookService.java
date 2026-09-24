package az.emrah.librarymanagment.service;

import az.emrah.librarymanagment.controller.BookController;
import az.emrah.librarymanagment.dao.entity.AuthorEntity;
import az.emrah.librarymanagment.dao.entity.BookEntity;
import az.emrah.librarymanagment.dao.repository.AuthorRepository;
import az.emrah.librarymanagment.dao.repository.BookRepository;
import az.emrah.librarymanagment.exceptions.ResourceNotFound;
import az.emrah.librarymanagment.model.AuthorModel;
import az.emrah.librarymanagment.model.BookModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.ref.PhantomReference;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookModel createBook(BookModel bookModel){

        AuthorEntity authorEntity = authorRepository.findById(bookModel.getAuthorId()).orElseThrow(() -> new ResourceNotFound("Author not found!"));

        BookEntity bookEntity = BookEntity.builder()
                .id(bookModel.getId())
                .title(bookModel.getTitle())
                .price(bookModel.getPrice())
                .publishedYear(bookModel.getPublishedYear())
                .author(authorEntity)
                .build();
        BookEntity save = bookRepository.save(bookEntity);

        return toModel(save);

    }

    private BookModel toModel(BookEntity bookEntity) {

        AuthorModel authorModel = AuthorModel.builder()
                .id(bookEntity.getAuthor().getId())
                .name(bookEntity.getAuthor().getName())
                .build();

        return BookModel.builder()
                .id(bookEntity.getId())
                .title(bookEntity.getTitle())
                .author(authorModel)
                .publishedYear(bookEntity.getPublishedYear())
                .price(bookEntity.getPrice())
                .build();
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::toModel)
                .toList();
    }

}
