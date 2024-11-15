package fit.se.vttblog.backend.mappers;

import fit.se.vttblog.backend.dtos.PostDto;
import fit.se.vttblog.backend.entities.Post;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {
   Post toEntity(PostDto postDto);

   PostDto toDto(Post post);

   @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
   Post partialUpdate(PostDto postDto, @MappingTarget Post post);
}