package net.coding.ems.service.impl;

import lombok.AllArgsConstructor;
import net.coding.ems.dto.EmployeeDto;
import net.coding.ems.entity.Employee;
import net.coding.ems.exception.ResourceNotFoundException;
import net.coding.ems.mapper.EmployeeMapper;
import net.coding.ems.repository.EmployeeRepository;
import net.coding.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee =  employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
