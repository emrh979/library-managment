package az.emrah.librarymanagment.model;

import az.emrah.librarymanagment.dao.entity.AuthorEntity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookModel {

    private Long id;

    private String title;

    private BigDecimal price;

    private int publishedYear;

    private Long authorId;

    private AuthorModel author;

}
