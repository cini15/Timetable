package by.bsac.timetable.resourc.DTO;


import java.util.Collection;

public class SubjectForDTO {

    private byte id;
    private String name;

    public SubjectForDTO() {
    }

    public SubjectForDTO(byte id, String name) {
        this.id = id;
        this.name = name;

    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
