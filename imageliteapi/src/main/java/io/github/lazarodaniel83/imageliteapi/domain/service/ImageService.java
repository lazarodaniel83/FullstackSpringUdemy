package io.github.lazarodaniel83.imageliteapi.domain.service;

import io.github.lazarodaniel83.imageliteapi.domain.entity.Image;
import io.github.lazarodaniel83.imageliteapi.domain.enums.ImageExtension;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    Image save(Image image);

    Optional<Image> getById(String id);

    List<Image> search(ImageExtension extension, String query);
}

