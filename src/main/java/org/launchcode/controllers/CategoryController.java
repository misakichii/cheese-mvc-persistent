package org.launchcode.controllers;


import org.launchcode.models.Category;
import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("title", "Categories");
        return "category/index";
    }

    @RequestMapping(value = "add", method=RequestMethod.GET)
    public String add(Model model) {
        //shorthand code provided
        model.addAttribute(new Category());
        //add title to model (Name,Value)
        model.addAttribute("title", "Add Category");
        return "category/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Category category, Errors errors){
        if(errors.hasErrors()) {
            model.addAttribute("category", new Category());
            model.addAttribute("title", "Add Category");
            return "category/add";
        }else {
            //save the new Category object by calling below (does it work idk)
            categoryDao.save(category);
            return "redirect:/category";
        }
    }
}
