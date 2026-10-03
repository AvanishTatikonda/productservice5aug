package com.example.productservice5aug.dtos.search;

import com.example.productservice5aug.dtos.CreateProductResponseDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class SearchResponseDto {

    private Page<CreateProductResponseDto> productsPage;
}