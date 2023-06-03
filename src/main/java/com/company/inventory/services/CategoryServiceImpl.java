package com.company.inventory.services;

import com.company.inventory.dao.ICategoryDao;
import com.company.inventory.model.Category;

import com.company.inventory.response.CategoryResponseRest;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryDao categoryDao;

    public CategoryServiceImpl(ICategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<CategoryResponseRest> search() {

        CategoryResponseRest response = new CategoryResponseRest();

        try {
            List<Category> category = (List<Category>) categoryDao.findAll();
            response.getCategoryResponse().setCategory(category);
            response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta nok", "00", "Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
