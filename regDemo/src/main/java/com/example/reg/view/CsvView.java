package com.example.reg.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.example.reg.entity.ClassRoom;

public class CsvView extends AbstractCsvView {


    @Override
    protected void buildCsvDocument(Map<String, Object> req, HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "attachment; filename=\"my-csv-file.csv\"");

        List<ClassRoom> listClassRoom = (List<ClassRoom>) req.get("Student");
        String[] header = {"StudentID", "FirstName", "LastName", "SubjectID", "SubjectName", "SectionName", "ProfessorFirstName", "ProfessorLastName"};
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        csvWriter.writeHeader(header);

        for (ClassRoom classRoom : listClassRoom) {
            csvWriter.write(classRoom, header);
        }
        csvWriter.close();


    }

}
