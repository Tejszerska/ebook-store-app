package pl.ebookstore.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.ebookstore.app.entities.Ebook;
import pl.ebookstore.app.model.dtos.EbookDto;
import pl.ebookstore.app.model.enums.Format;
import pl.ebookstore.app.model.enums.Genre;
import pl.ebookstore.app.model.enums.Language;
import pl.ebookstore.app.repository.EbookRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class EbookService {
    private final EbookRepository ebookRepository;

    public List<EbookDto> getEbooks() {
        return ebookRepository.findAll().stream()
                .map(e -> new EbookDto(e.getId(), e.getTitle(), e.getAuthors(), e.getPublisher(), e.getCoverUrl(), e.getDescription(), e.getGenre().toString(), e.getSellingPrice(), e.getPurchaseCost(), e.getFormat().toString(), e.getLanguage().toString()))
                .toList();

    }

    public void addEbook(EbookDto ebookDto, MultipartFile file) {
        Ebook ebook = new Ebook();
        ebook.setPurchaseCost(ebookDto.getPurchaseCost());
        ebook.setTitle(ebookDto.getTitle());
        ebook.setId(ebookDto.getId());
        ebook.setAuthors(ebookDto.getAuthors());
        ebook.setPublisher(ebookDto.getPublisher());
        ebook.setCoverUrl(ebookDto.getCoverUrl());
        ebook.setDescription(ebookDto.getDescription());
        ebook.setGenre(Genre.valueOf(ebookDto.getGenre()));
        ebook.setSellingPrice(ebookDto.getSellingPrice());
        ebook.setFormat(Format.valueOf(ebookDto.getFormat()));
        ebook.setLanguage(Language.valueOf(ebookDto.getLanguage()));
        ebookRepository.save(ebook);
        coverUpload(file);


    }

    private void coverUpload(MultipartFile file) {
        Path uploads = Paths.get("./uploads");
        try {
            Files.copy(file.getInputStream(), uploads.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public EbookDto getEbookById(Long ebookId) {
        Ebook ebook = ebookRepository.findById(ebookId).orElseThrow(() -> new IllegalArgumentException(ebookId + ": there is no ebook with that ID in the database."));
        return new EbookDto(ebook.getId(), ebook.getTitle(), ebook.getAuthors(), ebook.getPublisher(), ebook.getCoverUrl(), ebook.getDescription(), ebook.getGenre().toString(), ebook.getSellingPrice(), ebook.getPurchaseCost(), ebook.getFormat().toString(), ebook.getLanguage().toString());
    }
}
