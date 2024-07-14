package io.github.lazarodaniel83.imageliteapi.infra.repository;

import io.github.lazarodaniel83.imageliteapi.domain.entity.Image;
import io.github.lazarodaniel83.imageliteapi.domain.enums.ImageExtension;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

    //*
    //
    // @param extension
    // @param query
    //
    // SELECT * FROM IMAGE WHERE 1 = 1 AND EXTENSION 'PNG' AND ( NAME LIKE 'QUERY' OR TAGS LIKE 'QUERY' )
    //
    //
    // *//

    default List<Image> findExtensioAndNameOrTagsLike(ImageExtension extension, String query){
        //SELECT * FROM IMAGE WHERE 1 = 1
        Specification<Image> conjucntion = (root,q, criteriaBuilder) -> criteriaBuilder.conjunction();

        Specification<Image> spec = Specification.where( conjucntion  );

        if(extension != null){
            Specification<Image> extensionEqual = (root,q, cb) ->cb.equal(root.get("extension"), extension);
            spec = spec.and(extensionEqual);
        }

        if(StringUtils.hasText(query)){
            //AND (NAME LIKE 'QUERY OR TAGS LIKE 'QUERY'   )
            Specification<Image> nameLike = (root, q, cb) -> cb.like(cb.upper(root.get("name")),"%"+query.toUpperCase()+ "%");
            Specification<Image> tagsLike = (root, q, cb) -> cb.like(cb.upper(root.get("tags")),"%"+query.toUpperCase()+ "%");

            Specification<Image> nameOrTagsLike = Specification.anyOf(nameLike,tagsLike);

            spec = spec.and(nameOrTagsLike);
        }


        return findAll(spec);
    }
}








