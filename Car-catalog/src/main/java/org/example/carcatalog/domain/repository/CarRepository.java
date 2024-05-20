package org.example.carcatalog.domain.repository;

import org.example.carcatalog.domain.models.Car;
import org.example.carcatalog.domain.models.CarId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Collectors;

public interface CarRepository extends JpaRepository<Car, CarId> {

    @Query(value = "SELECT * FROM cars WHERE manufacturer  = ?1 OR money_per_day <= ?2", nativeQuery = true)
    List<Car> findByBrandOrMoneyPerDay(String brand, Integer moneyPerDay);

}
