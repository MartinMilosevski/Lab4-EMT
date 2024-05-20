package org.example.carcatalog.services.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.carcatalog.domain.models.Car;
import org.example.carcatalog.domain.models.CarId;
import org.example.carcatalog.domain.repository.CarRepository;
import org.example.carcatalog.services.CarService;
import org.example.carcatalog.services.form.CarForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.lang.model.element.Name;
import java.util.List;


@Transactional
@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car findById(CarId carId) {
        return carRepository.findById(carId).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findByBrandOrMoneyPerDay(String Manufacturer, Integer MoneyPerDay) {
       return carRepository.findByBrandOrMoneyPerDay(Manufacturer,MoneyPerDay);
    }

    @Override
    public void CreateCar(CarForm carform) {
        carRepository.save(new Car(carform.getName(), carform.getBrand(),carform.getMoney()));
    }

    @Override
    public void DeleteCar(CarId carId) {
        carRepository.deleteById(carId);
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody CarForm carForm) {
        if (carForm==null){
            return ResponseEntity.badRequest().build();
        }
        carRepository.save(new Car(carForm.getName(), carForm.getBrand(),carForm.getMoney()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Car> deleteCar(@PathVariable CarId carId) {
        if (carId==null){
            return ResponseEntity.badRequest().build();
        }
        carRepository.deleteById(carId);
        return ResponseEntity.ok().build();
    }

}
