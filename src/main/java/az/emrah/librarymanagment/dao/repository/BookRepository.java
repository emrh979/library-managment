package az.emrah.librarymanagment.dao.repository;

import az.emrah.librarymanagment.dao.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
