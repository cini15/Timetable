package by.bsac.timetable.resourc.DTO;


import java.util.Collection;

public class SubjectDTO {
    private short idSubject;
    private String nameSubject;
    private byte idChair;
    private byte eduLevel;
    private String abnameSubject;


    public SubjectDTO() {
    }

    public SubjectDTO(short idSubject, String nameSubject, byte idChair, byte eduLevel, String abnameSubject) {
        this.idSubject = idSubject;
        this.nameSubject = nameSubject;
        this.idChair = idChair;
        this.eduLevel = eduLevel;
        this.abnameSubject = abnameSubject;

    }

    public short getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(short idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public byte getIdChair() {
        return idChair;
    }

    public void setIdChair(byte idChair) {
        this.idChair = idChair;
    }

    public byte getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(byte eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getAbnameSubject() {
        return abnameSubject;
    }

    public void setAbnameSubject(String abnameSubject) {
        this.abnameSubject = abnameSubject;
    }

}
