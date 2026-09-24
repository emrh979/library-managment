package az.emrah.librarymanagment.controller;

import az.emrah.librarymanagment.model.AuthorModel;
import az.emrah.librarymanagment.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorModel createAuthor(@RequestBody AuthorModel authorModel){
        return authorService.createAuthor(authorModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorModel>  getAllAuthors() {
        return authorService.getAllAuthors();
    }

}
