package com.example.productservice5aug.services.sortingService;

import com.example.productservice5aug.dtos.search.SortingCriteria;

public class SorterFactory {
    public static Sorter getSorterByCriteria(
            SortingCriteria sortingCriteria
    ) {
        return switch (sortingCriteria) {
            case PRICE_HIGH_TO_LOW -> new PriceHighToLowSorter();
            case PRICE_LOW_TO_HIGH -> new PriceLowToHighSorter();
        };
    }
}
