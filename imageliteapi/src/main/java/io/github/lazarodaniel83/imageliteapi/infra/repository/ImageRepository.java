package io.github.lazarodaniel83.imageliteapi.infra.repository;

import io.github.lazarodaniel83.imageliteapi.domain.entity.Image;
import io.github.lazarodaniel83.imageliteapi.domain.enums.ImageExtension;
import io.github.lazarodaniel83.imageliteapi.infra.repository.specs.GenericSpecs;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

import static io.github.lazarodaniel83.imageliteapi.infra.repository.specs.ImagesSpecs.*;
import static org.springframework.data.jpa.domain.Specification.*;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {
    default List<Image> findExtensioAndNameOrTagsLike(ImageExtension extension, String query){
        Specification<Image> spec = where(GenericSpecs.conjunction());

        if(extension != null){
            spec = spec.and(extensionEqual(extension));
        }

        if(StringUtils.hasText(query)){
            Specification<Image> nameOrTagsLike = anyOf(nameLike(query),tagsLike(query));
        }


        return findAll(spec);
    }
}








