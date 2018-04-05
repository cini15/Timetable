package by.bsac.timetable.resourc.faculty;

import java.util.ArrayList;

/**
 * Created by пк on 01.07.2017.
 */

public class Facultets {
    private ArrayList<Faculty> facultets;

    public Facultets() {
        this.facultets = new ArrayList<>();
    }

    public void setFacultets(Faculty faculty){
        facultets.add(faculty);
    }

    public String[] getAllNameFacultets(){
        String nameFacultets[]=new String[facultets.size()];
        for (int i=0;i<facultets.size();i++){
            nameFacultets[i]=facultets.get(i).getName_faculty();
        }
        return nameFacultets;
    }
    public int getFacultetByName(String nameFaculty){
        int id = -1;
        for(int i=0;i<facultets.size();i++){
            if(facultets.get(i).getName_faculty().equals(nameFaculty)) {
                id = facultets.get(i).getId_faculty();
                break;
            }
        }
        return id;
    }
}
