package az.emrah.librarymanagment.dao.repository;


import az.emrah.librarymanagment.dao.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {


}
