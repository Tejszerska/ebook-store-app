package pl.ebookstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ebookstore.app.entities.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
