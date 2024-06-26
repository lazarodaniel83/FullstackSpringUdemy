package io.github.lazarodaniel83.imageliteapi.application.images;

import io.github.lazarodaniel83.imageliteapi.domain.entity.Image;
import io.github.lazarodaniel83.imageliteapi.domain.service.ImageService;
import io.github.lazarodaniel83.imageliteapi.infra.repository.ImageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository repository;

    @Override
    @Transactional
    public Image save(Image image) {
        return repository.save(image);
    }
}
