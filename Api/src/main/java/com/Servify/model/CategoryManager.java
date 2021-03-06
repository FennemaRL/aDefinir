package com.Servify.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryManager {

    public static final List<CategoryService> CATEGORY_SERVICES = new ArrayList<>();

    static {
        CATEGORY_SERVICES.add(new CategoryService("Electricidad", "https://i.ibb.co/H4Lf2cK/elec-Lista.jpg"));
        CATEGORY_SERVICES.add(new CategoryService("Mecanica", "https://i.ibb.co/X52sdtD/meca-Lista.jpg"));
        CATEGORY_SERVICES.add(new CategoryService("Carpinteria", "https://i.ibb.co/b7tB76s/carp-Lista.jpg"));
        CATEGORY_SERVICES.add(new CategoryService("Plomeria", "https://i.ibb.co/B27vf53/plome-Lista.jpg"));
        CATEGORY_SERVICES.add(new CategoryService("Gas Natural", "https://i.ibb.co/LJ5cD2m/gas.jpg"));

    }

    public static List<CategoryService> categories() {
        return CATEGORY_SERVICES;
    }

    public static ServiceServify createService(String cat) throws NoExistentCategoryError {
        List<CategoryService> matchCategories = categories().stream()
                .filter(categoryService -> categoryService.getCategoryName().equals(cat))
                .collect(Collectors.toList());
        assertExistsCategory(matchCategories);
        return new ServiceServify(matchCategories.get(0));
    }

    private static void assertExistsCategory(List<CategoryService> matchCategories) throws NoExistentCategoryError {
        if (matchCategories.isEmpty()) {
            throw new NoExistentCategoryError();
        }
    }

    public static CategoryService getCategory(String cat) throws InvalidCategoryError {
        List<CategoryService> categoryServices = categories().stream().filter(categoryService -> categoryService.getCategoryName().equals(cat)).collect(Collectors.toList());
        assertNotEmpty(categoryServices,cat);
        return categoryServices.get(0);
    }

    private static void assertNotEmpty(List<CategoryService> categoryServices, String category) throws InvalidCategoryError{
        if (categoryServices.isEmpty()) {
            throw new InvalidCategoryError(category);
        }
    }
}
