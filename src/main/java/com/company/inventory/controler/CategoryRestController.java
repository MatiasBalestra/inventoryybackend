package com.company.inventory.controler;

import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apí/v1")
public class CategoryRestController {

    @Autowired
    private ICategoryService service;

    /**
     * get all the categories
     * @return
     */
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories() {
        ResponseEntity<CategoryResponseRest> response = service.search();
        return response;

    }

    /**
     * get all the categories by id
     * @param id
     * @return
     */

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable long id) {
        ResponseEntity<CategoryResponseRest> response = service.searchById(id);
        return response;

    }

}
