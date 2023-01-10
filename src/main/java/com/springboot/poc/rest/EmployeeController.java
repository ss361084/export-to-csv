package com.springboot.poc.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.poc.entity.Address;
import com.springboot.poc.entity.Employee;
import com.springboot.poc.service.AddressService;
import com.springboot.poc.service.EmployeeService;

@Controller
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AddressService addressService;

    @GetMapping("employee-page")
    public String createEmployeePage(Model model) {
        log.info("Rest request to Create Employee Page");
        model.addAttribute("employee",new Employee());
        return "CreateEmployee";
    }
    
    @GetMapping("employees/{id}")
    public String editEmployeePage(@RequestParam Long id) throws Exception {
    	if(id == null) {
    		throw new Exception("Invalid Request");
    	}
		return null;
    }
    
    @PostMapping("create-employee")
    public ModelAndView createEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes attributes) throws Exception {
    	log.info("Rest request to Create Employee");
    	ModelAndView mv = new ModelAndView("redirect:employee-page");
    	if(bindingResult.hasErrors()) {
    		attributes.addFlashAttribute("error", true);
    		attributes.addFlashAttribute("errorMsg", "Something InValid...Please try again!!");
    		
    		return mv;
    	}
    	if(employee.getId() != null) {
    		throw new Exception("invalid request");
    	}
    	try {
    		Optional<Address> addressObj = addressService.getAddressByCityAndPincode(employee.getAddress().getCity(), employee.getAddress().getPincode());
        	Address address = null;
        	if(addressObj.isEmpty()) {
        		address = addressService.save(employee.getAddress());
        	} else {
        		address = addressObj.get();
        	}
        	employee.setAddress(address);
        	employee = employeeService.save(employee);
    	} catch (Exception e) {
    		attributes.addFlashAttribute("error", true);
    		attributes.addFlashAttribute("errorMsg", "Please Try Again");
		}
    	if(employee.getId() != null)
    		attributes.addFlashAttribute("success", true);
    	return mv;
    }
    
    @SuppressWarnings("unchecked")
	@GetMapping(value = "employees", produces = {"application/json"})
    @ResponseBody
    public String getAllEployees() {
    	log.debug("Rest request to get All Employees");
    	JSONArray array = new JSONArray();
    	employeeService.getAllEmployee().stream()
    	.forEach(emp -> {
    		JSONObject object = new JSONObject();
    		object.put("id", emp.getId());
    		object.put("name", emp.getName());
    		object.put("city", emp.getAddress().getCity());
    		object.put("pincode", emp.getAddress().getPincode());
    		array.add(object);
    	});
    	return array.toJSONString();
    }
}
