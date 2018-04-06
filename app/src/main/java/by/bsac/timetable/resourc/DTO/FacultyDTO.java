package by.bsac.timetable.resourc.DTO;


import java.util.ArrayList;
import java.util.Collection;


public class FacultyDTO {
    private byte idFaculty;
    private String nameFaculty;
//    @JsonProperty("groups")
    private Collection<GroupDTO> groupsByIdFaculty=new ArrayList<>();

    public FacultyDTO() {
    }

    public FacultyDTO(byte idFaculty, String nameFaculty, Collection<GroupDTO> groupsByIdFaculty) {
        this.idFaculty = idFaculty;
        this.nameFaculty = nameFaculty;
        this.groupsByIdFaculty = groupsByIdFaculty;
    }

    public byte getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(byte idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public Collection<GroupDTO> getGroupsByIdFaculty() {
        return groupsByIdFaculty;
    }

    public void setGroupsByIdFaculty(Collection<GroupDTO> groupsByIdFaculty) {
        this.groupsByIdFaculty = groupsByIdFaculty;
    }
}
