package de.telran.employee.repository;

import de.telran.employee.dto.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class EmployeeRepository {

    Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);

    private int lastId = 0;

    private final Map<Integer, EmployeeDto> employeeRepository
            = new HashMap<>();

    @PostConstruct
    public void init() {
        EmployeeDto employee1 = new EmployeeDto();
        employee1.setFirstName("Vasya");
        employee1.setLastName("Pupkin");
        employee1.setBirthDate("01.01.1980");
        employee1.setPosition(1);
        createEmployee(employee1);
        logger.info("employee1 ", employee1);

        EmployeeDto employee2 = new EmployeeDto();
        employee2.setFirstName("Petya");
        employee2.setLastName("Vaskin");
        employee2.setBirthDate("01.12.1981");
        employee2.setPosition(2);
        createEmployee(employee2);
        logger.info("employee2 ", employee2);
    }

    public List<EmployeeDto> getAllEmployees() {
        return new ArrayList<>(employeeRepository.values());
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        employeeDto.setId(generateNewId());
        employeeRepository.put(employeeDto.getId(), employeeDto);
        return employeeDto;
    }

    public EmployeeDto getById(Integer id) {
        return employeeRepository.get(id);
    }

    private int generateNewId() {
        return ++lastId;
    }
}