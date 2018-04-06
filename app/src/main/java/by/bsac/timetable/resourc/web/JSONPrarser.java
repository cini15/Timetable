package by.bsac.timetable.resourc.web;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

import by.bsac.timetable.resourc.DTO.FacultyDTO;

public class JSONPrarser {

    public static Collection<FacultyDTO> parsJSONtoDTOFacylty(String jsonSrt){
        Collection<FacultyDTO> facultyDTOS=new ArrayList<>();



        JSONArray jsonArray= new JSONArray();
        try {
            jsonArray.length();
            Log.e("JSON_LOG", String.valueOf(jsonArray.length()));


        }catch (Exception e){
            e.printStackTrace();
        }


        return facultyDTOS;
    }

}
