package pl.ebookstore.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.ebookstore.app.entities.Ebook;
import pl.ebookstore.app.repository.EbookRepository;


@Service
@RequiredArgsConstructor
public class EbookService {
private EbookRepository ebookRepository;
    void getDataBase() {
        ebookRepository.findAll();
    }


}
