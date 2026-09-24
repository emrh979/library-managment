package az.emrah.librarymanagment.service;

import az.emrah.librarymanagment.dao.entity.AuthorEntity;
import az.emrah.librarymanagment.dao.repository.AuthorRepository;
import az.emrah.librarymanagment.model.AuthorModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorModel createAuthor(AuthorModel authorModel) {
        AuthorEntity authorEntity = AuthorEntity.builder()
                .id(authorModel.getId())
                .name(authorModel.getName())
                .email(authorModel.getEmail())
                .build();
        AuthorEntity save = authorRepository.save(authorEntity);

        return toModel(save);


    }

    public List<AuthorModel> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(this::toModel)
                .toList();
    }

    private AuthorModel toModel(AuthorEntity authorEntity) {
        return  AuthorModel.builder()
                .id(authorEntity.getId())
                .name(authorEntity.getName())
                .email(authorEntity.getEmail())
                .build();

    }


}
