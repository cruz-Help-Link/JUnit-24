package stubs;

import entity.DataWriterReader;
import entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class WriteDataStub implements DataWriterReader {
    private List<Employee> employeeData = new ArrayList<>();

    @Override
    public String writeData(String employees) {
        return "Writing";
    }

    @Override
    public String readData() {
        return "Reading";
    }
}








