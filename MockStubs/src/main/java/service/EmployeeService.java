package service;

import entity.DataWriterReader;
import entity.Employee;

import java.util.List;

public class EmployeeService {
    private final DataWriterReader dataWriter;

    public EmployeeService(DataWriterReader dataWriter) {
        this.dataWriter = dataWriter;
    }

    public String showEmployee() {
        return dataWriter.readData();
    }
    public void saveEmployee(String employess) {
        dataWriter.writeData(employess);
    }

}







    //    public List<Employee> loadEmployees() {
//        return dataWriter.readEmployeeData();
//    }
//    public void saveEmployees(List<Employee> employees) {
//        dataWriter.writeEmployeeData(employees);
//    }