package com.ifanow.CollegeManagement.Controller;

import com.google.gson.Gson;
import com.ifanow.CollegeManagement.Models.LibraryModel;
import com.ifanow.CollegeManagement.Services.LibraryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api")

public class LibraryController {
    @Autowired
    LibraryServices libraryServices;


    @CrossOrigin("http://localhost:4200")
    @PostMapping("/storeLibraryDetails")
    public int saveLibraryDetails(@RequestParam int studentId, @RequestParam String studentName, @RequestParam String bookName, @RequestParam String issueDate, @RequestParam String returnDate, @RequestParam int numberOfBook, @RequestParam String librarian){
        int storeLibraryDetail=0;
        storeLibraryDetail = libraryServices.saveLibraryDetails(studentId,studentName,bookName,issueDate,returnDate,numberOfBook,librarian);
        return storeLibraryDetail;
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/showLibraryDetails")
    public String showLibrayDetails()
    {
        Gson libraryModeljson=new Gson();
        String libraryjsonObj =libraryModeljson.toJson(libraryServices.showAllLibraryDetail());
        System.out.println(libraryjsonObj);
        return libraryjsonObj;
    }
    @CrossOrigin("http://localhost:4200")
    @PutMapping("/updateLibraryDetails")
    public int updateLibraryDetails(@RequestParam int srNo,@RequestParam String bookName){
        int updatedRow = 0;
        updatedRow = libraryServices.updateLibraryDetail(srNo,bookName);
        return updatedRow;
    }
    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/deleteLibraryDetails")
    public int deleteLibraryDetail(@RequestParam int srNo) throws IOException {
        //int studentId=3;
        int deletedRow=0;
        deletedRow=libraryServices.deleteLibraryDetail(srNo);
        return deletedRow;
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/totalLibraryDetails")
    public int totalLibrrayDetail(){
        int count = 0;
        count = libraryServices.LibraryDetails();
        return count;
    }
}
