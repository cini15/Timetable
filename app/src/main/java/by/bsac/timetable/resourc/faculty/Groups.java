package by.bsac.timetable.resourc.faculty;

import java.util.ArrayList;

/**
 * Created by пк on 01.07.2017.
 */

public class Groups {
    private ArrayList<Group> groups;

    public Groups() {
        this.groups = new ArrayList<Group>();
    }

    public void setGroups(Group group){
        this.groups.add(group);
    }
    public String[] getAllNameGroups(){
        String[] name_groups =new String[groups.size()];

        for (int i = 0; i<groups.size();i++){
            name_groups[i]=groups.get(i).getName_group();
        }
        return name_groups;
    }

    public int getGroupByName(String group_name){
        int id=-1;
        for (int i = 0; i<groups.size();i++){
            if(groups.get(i).getName_group().equals(group_name)){
                id=groups.get(i).getId_group();
                break;
            }

        }
        return id;
    }
}
