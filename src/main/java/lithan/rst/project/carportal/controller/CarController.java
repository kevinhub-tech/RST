package lithan.rst.project.carportal.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lithan.rst.project.carportal.entities.Car;
import lithan.rst.project.carportal.entities.User;
import lithan.rst.project.carportal.services.CarService;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class CarController {

    private static Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @RequestMapping(value="/",  method= RequestMethod.GET)
    public String handleRootRequest(Model model) {
        return "redirect:cars";
    }

    @RequestMapping(value="cars",  method= RequestMethod.GET)
    public String viewCars(Model model) {
        List<Car> cars = carService.getAllCars();
        if(!CollectionUtils.isEmpty(cars)) {
            model.addAttribute("cars", cars);
        }
        return "view_cars";
    }
    
    @RequestMapping(value="/new_car")
	public String newUserForm(Map<String, Object> model) {
    	System.out.println("To show add new car page");
		Car car = new Car();
		model.put("car", car);
		return "new_car";
	}

    @RequestMapping(value="cars",  method = {RequestMethod.POST, RequestMethod.PUT})
    public String saveCar(@RequestParam(value="id", required = false) Long id,
                            @RequestParam("make") String make,
                            @RequestParam("model") String car_model,
                            @RequestParam("registeration") String registeration,
                            @RequestParam("price") String price,
                            @RequestParam(value="category_id", required=false) Integer category_id,
                            @RequestParam(value="category_name", required=false) String categoryName,
                            Model model) {
    	
    	System.out.println("Save & Update new car");
    	
    	Car car = new Car();
        car.setId(id != null ? id: 0);
        car.setMake(make);
        car.setModel(car_model);
        car.setRegisteration(registeration);
        car.setPrice(price);

        logger.debug("Car make:{}, model: {}", car.getMake(),car.getModel(),car.getRegisteration(),car.getPrice());
        
        Car savedCar = carService.saveCar(car);
        		
        model.addAttribute("cars", carService.getAllCars());
        
        return "view_cars";
    }
    

    
	@RequestMapping("/car_detail")
	public ModelAndView viewCar(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("car_detail");
		Car car = carService.get(id);
		mav.addObject("car", car);
		return mav;
	}
	
    
	@RequestMapping("/edit")
	public ModelAndView editCarForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_car");
		Car car = carService.get(id);
		mav.addObject("car", car);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteCar(@RequestParam long id) {
		carService.delete(id);
		return "redirect:/cars";		
	}
	
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Car> result = carService.search(keyword);
		ModelAndView mav = new ModelAndView("search_car_results");
		mav.addObject("keyword", keyword);
		mav.addObject("search_cars", result);
		return mav;		
	}	

    
    
}
