package com.example.reg.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.example.reg.entity.ClassRoom;

public class Excelview extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> req,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");

        @SuppressWarnings("unchecked")
        List<ClassRoom> listClassRoom = (List<ClassRoom>) req.get("Student");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("User Detail");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);


        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("StudentID");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("FirstName");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("LastName");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("SubjectID");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("SubjectName");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("SectionName");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("ProfessorFirstName");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("ProfessorLastName");
        header.getCell(7).setCellStyle(style);


        int rowCount = 1;

        for (ClassRoom classroom : listClassRoom) {
            Row userRow = sheet.createRow(rowCount++);
            userRow.createCell(0).setCellValue(classroom.getClassRoomStudent().getStuId());
            userRow.createCell(1).setCellValue(classroom.getClassRoomStudent().getFnameStu());
            userRow.createCell(2).setCellValue(classroom.getClassRoomStudent().getLnameStu());
            userRow.createCell(3).setCellValue(classroom.getClassRoomSubject().getSubjectId());
            userRow.createCell(4).setCellValue(classroom.getClassRoomSubject().getSubjectName());
            userRow.createCell(5).setCellValue(classroom.getClassRoomsection().getSectionName());
            userRow.createCell(6).setCellValue(classroom.getClassRoomProfessor().getFname());
            userRow.createCell(7).setCellValue(classroom.getClassRoomProfessor().getLname());

        }

    }

}
