package by.bsac.timetable.resourc.web;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import by.bsac.timetable.resourc.DTO.ChairDTO;
import by.bsac.timetable.resourc.DTO.FacultyDTO;
import by.bsac.timetable.resourc.DTO.GroupDTO;
import by.bsac.timetable.resourc.DTO.RecordDTO;

public class JSONPrarser {

    public static Collection<FacultyDTO> parsJSONtoDTOFacylty(String jsonSrt){

        Gson gson= new Gson();
        Type faculty= new TypeToken<List<FacultyDTO>>(){}.getType();
        Collection<FacultyDTO> facultyDTOS=new ArrayList<>();
        try {
            facultyDTOS = gson.fromJson(jsonSrt,faculty);


        }catch (Exception e){
            e.printStackTrace();
        }


        return facultyDTOS;
    }

    public static Collection<RecordDTO> parsJSONtoDTORecord(String jsonSrt){
        Collection<RecordDTO> recordDTOS=new ArrayList<>();
        Gson gson= new Gson();
        Type record= new TypeToken<List<RecordDTO>>(){}.getType();
        try {
            recordDTOS = gson.fromJson(jsonSrt,record);


        }catch (Exception e){
            e.printStackTrace();
        }

        return recordDTOS;
    }

    public static Collection<ChairDTO> parsJSONtoDTOChair(String jsonSrt){
        Collection<ChairDTO> chairDTOS=new ArrayList<>();
        Gson gson= new Gson();
        Type chair= new TypeToken<List<ChairDTO>>(){}.getType();
        try {
            chairDTOS = gson.fromJson(jsonSrt,chair);


        }catch (Exception e){
            e.printStackTrace();
        }

        return chairDTOS;
    }

}
