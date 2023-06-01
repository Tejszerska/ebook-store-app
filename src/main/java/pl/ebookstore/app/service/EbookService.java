package pl.ebookstore.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import pl.ebookstore.app.entities.Ebook;
import pl.ebookstore.app.model.dtos.EbookDto;
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
                .map( e  -> new EbookDto(e.getId(), e.getTitle(), e.getAuthors(), e.getPublisher(), e.getCoverUrl(), e.getDescription(), e.getGenre(), e.getSellingPrice(), e.getPurchaseCost(), e.getFormat(), e.getLanguage()))
                .toList();

    }

    public void addEbook(EbookDto ebookDto, MultipartFile file) {
//        Ebook ebook2 = new Ebook(ebookDto.getId(), ebookDto.getTitle(), ebookDto.getAuthors(), ebookDto.getPublisher(),
//        ebookDto.getCoverUrl(), ebookDto.getDescription(), ebookDto.getGenre(), ebookDto.getSellingPrice(),
//        ebookDto.getFormat(), ebookDto.getLanguage());


        Ebook ebook = new Ebook();
      ebook.setPurchaseCost(ebookDto.getPurchaseCost());
      ebook.setTitle(ebookDto.getTitle());
      ebook.setId(ebookDto.getId());
      ebook.setAuthors(ebookDto.getAuthors());
      ebook.setPublisher(ebookDto.getPublisher());
      ebook.setCoverUrl(ebookDto.getCoverUrl());
      ebook.setDescription(ebookDto.getDescription());
      ebook.setGenre(ebookDto.getGenre());
      ebook.setSellingPrice(ebookDto.getSellingPrice());
      ebook.setFormat(ebookDto.getFormat());
      ebook.setLanguage(ebookDto.getLanguage());
      ebookRepository.save(ebook);
//      ebookRepository.save(ebook2);
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
}
