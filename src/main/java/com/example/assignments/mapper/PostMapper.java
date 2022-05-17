package com.example.assignments.mapper;


import com.example.assignments.dto.PostDTO;
import com.example.assignments.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mappings({
            @Mapping(target = "post", source = "post")
    })
    PostDTO toDTO (Post post);

    @Mappings({
            @Mapping(target = "post", source = "post")
    })
    Post fromDTO (PostDTO postDTO);
}
