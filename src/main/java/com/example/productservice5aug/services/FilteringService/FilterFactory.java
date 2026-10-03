package com.example.productservice5aug.services.FilteringService;

public class FilterFactory {

    public static Filter getFilterFromKey(String key) {
        return switch (key) {
            case "ram" -> new RamFilter();
            case "brand" ->new BrandFilter();
            case null, default -> null;
        };
    }
}