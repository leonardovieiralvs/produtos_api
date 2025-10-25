package com.springboot.produtos.api.mapper;

import com.springboot.produtos.api.model.Produto;
import com.springboot.produtos.api.model.dto.ProdutoPutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ProdutoMapper {

    public static final ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    public abstract Produto toProduto(ProdutoPutDto produtoDto);

    @Mapping(target = "id", ignore = true)
    public abstract void updateFromDto(ProdutoPutDto produtoDto, @MappingTarget Produto produto);
}
