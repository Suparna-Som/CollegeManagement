package com.ifanow.CollegeManagement.Controller;

import com.google.gson.Gson;
import com.ifanow.CollegeManagement.Models.AttendenceInsertModel;
import com.ifanow.CollegeManagement.Models.AttendenceModel;
import com.ifanow.CollegeManagement.Services.AttendenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class AttendenceController {
    @Autowired
    AttendenceServices attendenceServices;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/attendence/insert",method= RequestMethod.POST)
    public String AttendenceInsert(@RequestBody String attendModel) throws IOException {
        System.out.println(attendModel);
        //Declaration
        Gson gson=new Gson();
        AttendenceInsertModel attendenceInsertModel=gson.fromJson(attendModel,AttendenceInsertModel.class);
        int sid = attendenceInsertModel.getStudentId();
        String sName = attendenceInsertModel.getStudentName();
        String department = attendenceInsertModel.getDepartment();
        String loginTime = attendenceInsertModel.getLoginTime();
        String logoutTime = attendenceInsertModel.getLogoutTime();
        //System.out.println();
        float attendencePercentage=attendenceServices.attendencePercentage(sid);
        //Constant Intiallization
        int count = attendenceServices.insertAttendence(sid,sName,department,loginTime,logoutTime,attendencePercentage);
        return "Successfully Insert..";
    }
    //Select Statement
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/attendence",method = RequestMethod.GET)
    @ResponseBody
    public String attendenceHome() throws IOException {
        //Declaration
        Gson gson=new Gson();
        String listModel = gson.toJson(attendenceServices.selectAttendence());
        return listModel;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/attendence/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public int attendenceDelete(@RequestParam("studentId") int sId) throws IOException {
        int deletedRow=0;
        deletedRow=attendenceServices.Delete(sId);
        return deletedRow;


    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/attendence/update",method = RequestMethod.PUT)
    @ResponseBody
    public String attendenceUpdate(@RequestParam("srNo") int srNo,@RequestParam("studentName") String sName,
                                   @RequestParam("department")String department,@RequestParam("loginTime")
                                           String loginTime,@RequestParam("logoutTime") String logoutTime) throws IOException {
        //float attendencePercentage=attendence.attendencePercentage(sid);
        //Constant Intiallization
        int updatedRow=0;
        updatedRow=attendenceServices.attendenceUpdate(srNo,sName,department,loginTime,logoutTime);
        return "Updated Rows="+String.valueOf(updatedRow);


    }
}
