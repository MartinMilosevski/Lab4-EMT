package org.example.carcatalog.services;

import org.example.carcatalog.domain.models.Car;
import org.example.carcatalog.domain.models.CarId;
import org.example.carcatalog.services.form.CarForm;

import java.util.List;

public interface CarService {

    Car findById(CarId carId);
    List<Car> findAllCars();
    List<Car> findByBrandOrMoneyPerDay(String Manufacturer,Integer MoneyPerDay);
    void CreateCar(CarForm carform);
    void DeleteCar(CarId carId);

}
