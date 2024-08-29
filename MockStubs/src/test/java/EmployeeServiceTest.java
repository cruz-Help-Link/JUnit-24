import entity.Employee;
import org.junit.Test;
import service.EmployeeService;
import stubs.WriteDataStub;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class EmployeeServiceTest {

    @Test
    public void testSaveAndLoadEmployees() {
        // Create a stub for DataWriter
        WriteDataStub dataStub = new WriteDataStub();

        // Create an instance of EmployeeService with the stub
        EmployeeService employeeService = new EmployeeService(dataStub);
        employeeService.saveEmployee("First");

        String printData = employeeService.showEmployee();

        assertEquals("Reading", printData.toString());
    }

}







