package pl.ebookstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ebookstore.app.entities.Ebook;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface EbookRepository extends JpaRepository<Ebook, Long> {

}
