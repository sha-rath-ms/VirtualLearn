package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.SubCategories;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.SubcategoryRepository;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.SubcategoryTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    public void addSubcategory(SubCategories subCategories) {
        Optional<SubcategoryTable> oldSubcategoris = subcategoryRepository.getByCategory(subCategories.getCategory());
        if (oldSubcategoris.isPresent()) {
            if (oldSubcategoris.get().getSubcategory().contains(subCategories.getSubcategory())) {
                throw new CustomExceptions(ResultInfoConstants.DUPLICATE_SUBCATEGORY);
            }
            String subCategory = oldSubcategoris.get().getSubcategory() + "," + subCategories.getSubcategory();
            SubcategoryTable newSub = subCategories.toSubcategoryTable();
            newSub.setSubcategory(subCategory);
            subcategoryRepository.save(newSub);
        }
        subcategoryRepository.save(subCategories.toSubcategoryTable());
    }
}
