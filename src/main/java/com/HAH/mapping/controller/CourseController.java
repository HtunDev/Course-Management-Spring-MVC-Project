package com.HAH.mapping.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.HAH.mapping.model.dto.Course;
import com.HAH.mapping.model.dto.Level;
import com.HAH.mapping.model.dto.Result;
import com.HAH.mapping.model.dto.Result.Status;
import com.HAH.mapping.model.service.CourseService;

@Controller
@EnableWebMvc
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public void index(Map<String, Object> model) {
		model.put("lists", courseService.getAll());
	}
	
	@GetMapping("/edit")
	public String editCourse() {
		return "course-edit";
	}
	
	@PostMapping
	public String saveCourse(
			@ModelAttribute Course course,
			RedirectAttributes redirect
			) {
		var id = courseService.save(course);
		
		if(course.getId() != id) {
			redirect.addFlashAttribute("result", new Result(Status.Success, "New Course Has Been Created!"));
		}
		
		return "redirect:course/%d".formatted(id);
	}
	
	
	@GetMapping("{id:\\d+}")
	public String findById(@PathVariable int id,ModelMap model) {
		model.put("course", courseService.findById(id));
		return "course-details";
	}
	
	@ModelAttribute
	public void loadLevels(ModelMap model) {
		model.put("levels", Level.values());
	}
	
	@ModelAttribute
	public void loadCourse(Integer id, ModelMap model) {
		if(null != id) {
			model.put("course", courseService.findById(id));
		}
	}


//	This is modelAndView Return 
//	@GetMapping
//	public ModelAndView index() {
//		var mv = new ModelAndView();
//		mv.getModel().put("lists", courseService.getAll());
//		mv.setViewName("course-list");
//		return mv;
//	}

	
//	This is return view only
//	@GetMapping
//	public String index(Map<String, Object> model) {
//		model.put("lists", courseService.getAll());
//		return "course-list";
//	}
}
