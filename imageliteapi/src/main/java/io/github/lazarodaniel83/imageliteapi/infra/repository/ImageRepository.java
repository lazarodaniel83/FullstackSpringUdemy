package io.github.lazarodaniel83.imageliteapi.infra.repository;

import io.github.lazarodaniel83.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {

}
