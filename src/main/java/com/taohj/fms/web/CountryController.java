package com.taohj.fms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.taohj.fms.model.Country;
import com.taohj.fms.model.User;
import com.taohj.fms.service.CountryService;
import com.taohj.fms.service.UserService;

@Controller
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private UserService userService;

	@RequestMapping("/home")
	public String test() {
		return "country/index";
	}

	@RequestMapping("/person/all")
	@ResponseBody
	public Pagination<User> queryAll(int page, int rows) {
		return userService.selectAll(page, rows);
	}

	@Autowired
	private CountryService countryService;

	private String redirect_list = "redirect:/country/list";

	@RequestMapping("/view/{id}/")
	public ModelAndView view(@PathVariable int id) {
		// cha xun
		ModelAndView model = new ModelAndView("country/view");
		Person person = new Person();
		person.setId(id);
		person.setName("陶慧君");
		person.setAge(12);
		model.addObject("person", person);
		return model;
	}

	@RequestMapping("/person/save")
	@ResponseBody
	public User getPeron(User user) {
		return userService.saveUser(user);
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(Country country) {
		ModelAndView result = new ModelAndView();
		if (country.getId() != null) {
			country = countryService.selectByKey(country.getId());
		}
		result.addObject("country", country);
		return result;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Country country) {
		ModelAndView result = new ModelAndView(redirect_list);
		if (country.getId() != null) {
			countryService.updateAll(country);
		} else {
			countryService.save(country);
		}
		return result;
	}

	@RequestMapping("/delete")
	public String delete(Integer id) {
		countryService.delete(id);
		return redirect_list;
	}

}
