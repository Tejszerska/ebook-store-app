package pl.ebookstore.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import pl.ebookstore.app.entities.Ebook;
import pl.ebookstore.app.model.dtos.EbookAdminDto;
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
                .map( e  -> new EbookDto(e.getId(), e.getTitle(),e.getAuthors(), e.getCoverUrl(), e.getDescription(),
                        e.getGenre(), e.getSellingPrice(), e.getFormat(), e.getLanguage()))
                .toList();
    }

    public void addEbook(EbookAdminDto ebookAdminDto, MultipartFile file) {
        Ebook ebook = new Ebook(ebookAdminDto.getId(), ebookAdminDto.getTitle(), ebookAdminDto.getAuthors(), ebookAdminDto.getCoverUrl(), ebookAdminDto.getDescription(), ebookAdminDto.getGenre(),ebookAdminDto.getSellingPrice() , ebookAdminDto.getFormat(), ebookAdminDto.getLanguage());
      ebook.setPublisher(ebookAdminDto.getPublisher());
      ebook.setPurchaseCost(ebookAdminDto.getPurchaseCost());
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
