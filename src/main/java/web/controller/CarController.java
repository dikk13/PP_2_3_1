package web.controller;

import model.Car;
import model.ServiceCarImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    public static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("1", 1, 1));
        cars.add(new Car("2", 2, 2));
        cars.add(new Car("3", 3, 3));
        cars.add(new Car("4", 4, 4));
        cars.add(new Car("5", 5, 5));
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(required = false) Integer count, Model model) {
        if (count == null || count >= 5) {
            model.addAttribute("cars", cars);
        } else if (count > 0) {
            model.addAttribute("cars", new ServiceCarImpl().getCars(count));
        }
//        System.out.println(count);
        return "cars";
    }
}
