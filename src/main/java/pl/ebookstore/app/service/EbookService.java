package pl.ebookstore.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pl.ebookstore.app.model.dtos.EbookDto;
import pl.ebookstore.app.repository.EbookRepository;

import java.util.List;



@Service
@RequiredArgsConstructor
public class EbookService {
private final EbookRepository ebookRepository;

    public List<EbookDto> getEbooks() {
        return ebookRepository.findAll().stream()
                .map( e  -> new EbookDto(e.getId(), e.getTitle(),e.getAuthors(), e.getCoverUrl(), e.getDescription(),
                        e.getGenre(), e.getSellingPrice(), e.getFormat(), e.getLanguage()))
                .toList();
    }
}
