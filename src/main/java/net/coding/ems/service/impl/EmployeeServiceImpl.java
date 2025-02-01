package net.coding.ems.service.impl;

import lombok.AllArgsConstructor;
import net.coding.ems.dto.EmployeeDto;
import net.coding.ems.entity.Employee;
import net.coding.ems.mapper.EmployeeMapper;
import net.coding.ems.repository.EmployeeRepository;
import net.coding.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee =  employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
