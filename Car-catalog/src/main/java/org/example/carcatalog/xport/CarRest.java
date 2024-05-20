package org.example.carcatalog.xport;

import org.example.carcatalog.domain.models.Car;
import org.example.carcatalog.domain.repository.CarRepository;
import org.example.carcatalog.services.CarService;
import org.example.carcatalog.services.form.CarForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarRest {

    private final CarService carService;

    public CarRest(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> GetAllAvailableCars(){
        return carService.findAllCars();
    }

    @GetMapping("/search")
    public List<Car> searchCars(@RequestParam(required = false) String brand,
                                                @RequestParam(required = false) Integer moneyPerDay) {
        if (brand==null || moneyPerDay==null) {
            return carService.findAllCars();
        }
        return carService.findByBrandOrMoneyPerDay(brand, moneyPerDay);
    }

    @PostMapping
    public ResponseEntity<Void> createCar(@RequestBody CarForm car) {
        if (car==null){
            return ResponseEntity.badRequest().build();
        }
        carService.CreateCar(car);
        return ResponseEntity.ok().build();
    }



}
