package br.com.carstore.service;

import br.com.carstore.dao.CarDao;
import br.com.carstore.dto.CarDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<CarDTO> findAll() {

        return carDao.findAll();

    }

    @Override
    public void save(CarDTO carDTO) {

        carDao.save(carDTO);

    }

    @Override
    public void deleteById(String id) {

        carDao.deleteById(id);

    }

    @Override
    public void update(String id, CarDTO carDTO) {

        carDao.update(id, carDTO);

    }

}