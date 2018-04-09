package by.bsac.timetable;

import android.util.Log;

import org.junit.Test;


import by.bsac.timetable.resourc.web.JSONPrarser;

import static junit.framework.Assert.assertEquals;


public class  ExampleUnitTest {

    String json="[{\"idFaculty\":1,\"nameFaculty\":\"Факультет электросвязи\",\"groups\":[{\"idGroup\":4,\"nameGroup\":\"СП442\",\"idFlow\":1,\"idFaculty\":1,\"eduLevel\":1},{\"idGroup\":5,\"nameGroup\":\"ЛК621\",\"idFaculty\":1,\"eduLevel\":2},{\"idGroup\":3,\"nameGroup\":\"СП441\",\"idFlow\":1,\"idFaculty\":1,\"eduLevel\":1},{\"idGroup\":6,\"nameGroup\":\"ПО611\",\"idFaculty\":1,\"eduLevel\":2},{\"idGroup\":7,\"nameGroup\":\"ПО612\",\"idFaculty\":1,\"eduLevel\":2},{\"idGroup\":2,\"nameGroup\":\"СТ442\",\"idFlow\":1,\"idFaculty\":1,\"eduLevel\":1},{\"idGroup\":1,\"nameGroup\":\"СТ441\",\"idFlow\":1,\"idFaculty\":1,\"eduLevel\":1}]},{\"idFaculty\":2,\"nameFaculty\":\"Факультет инжиниринга и технологий связи\",\"groups\":[{\"idGroup\":9,\"nameGroup\":\"ИТ642\",\"idFaculty\":2,\"eduLevel\":1},{\"idGroup\":8,\"nameGroup\":\"ИТ641\",\"idFaculty\":2,\"eduLevel\":1}]},{\"idFaculty\":5,\"nameFaculty\":\"Факультет довузовской подготовки\",\"groups\":[]},{\"idFaculty\":3,\"nameFaculty\":\"Факультет заочного и дистанционного образования\",\"groups\":[]},{\"idFaculty\":4,\"nameFaculty\":\"Факультет повышения квалификации и переподготовки кадров\",\"groups\":[]}]";

    @Test
    public  void Faculty() throws Exception {
      JSONPrarser.parsJSONtoDTOFacylty(json);

    }

    String rec="[{\"idRecord\":26,\"weekNumber\":2,\"weekDay\":2,\"subjOrdinalNumber\":2,\"idGroup\":1,\"idSubject\":259,\"idLecturer\":125,\"idSubjectType\":3,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-13\",\"dateTo\":\"2017-12-30\",\"idClassroom\":1,\"cancellationsByIdRecord\":[{\"idCancellation\":1,\"idRecord\":26,\"dateTo\":\"2017-12-30\",\"dateFrom\":\"2017-06-13\"}],\"subjectTypeByIdSubjectType\":{\"id\":3,\"name\":\"Практическая работа\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":1,\"number\":210,\"building\":1}},{\"idRecord\":27,\"weekNumber\":2,\"weekDay\":2,\"subjOrdinalNumber\":2,\"idGroup\":2,\"idSubject\":259,\"idLecturer\":125,\"idSubjectType\":3,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-13\",\"dateTo\":\"2017-12-30\",\"idClassroom\":1,\"cancellationsByIdRecord\":[{\"idCancellation\":2,\"idRecord\":27,\"dateTo\":\"2017-12-30\",\"dateFrom\":\"2017-06-13\"}],\"subjectTypeByIdSubjectType\":{\"id\":3,\"name\":\"Практическая работа\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":1,\"number\":210,\"building\":1}},{\"idRecord\":28,\"weekNumber\":2,\"weekDay\":2,\"subjOrdinalNumber\":2,\"idGroup\":3,\"idSubject\":259,\"idLecturer\":125,\"idSubjectType\":3,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-13\",\"dateTo\":\"2017-12-30\",\"idClassroom\":1,\"cancellationsByIdRecord\":[{\"idCancellation\":3,\"idRecord\":28,\"dateTo\":\"2017-12-30\",\"dateFrom\":\"2017-06-13\"}],\"subjectTypeByIdSubjectType\":{\"id\":3,\"name\":\"Практическая работа\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":1,\"number\":210,\"building\":1}},{\"idRecord\":29,\"weekNumber\":2,\"weekDay\":2,\"subjOrdinalNumber\":2,\"idGroup\":4,\"idSubject\":259,\"idLecturer\":125,\"idSubjectType\":3,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-13\",\"dateTo\":\"2017-12-30\",\"idClassroom\":1,\"cancellationsByIdRecord\":[{\"idCancellation\":4,\"idRecord\":29,\"dateTo\":\"2017-12-30\",\"dateFrom\":\"2017-06-13\"}],\"subjectTypeByIdSubjectType\":{\"id\":3,\"name\":\"Практическая работа\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":1,\"number\":210,\"building\":1}},{\"idRecord\":34,\"weekNumber\":3,\"weekDay\":2,\"subjOrdinalNumber\":4,\"idGroup\":1,\"idSubject\":61,\"idLecturer\":62,\"idSubjectType\":2,\"idSubjectFor\":1,\"dateFrom\":\"2017-06-20\",\"dateTo\":\"2017-06-20\",\"idClassroom\":6,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":2,\"name\":\"Лабораторная работа\"},\"subjectForByIdSubjectFor\":{\"id\":1,\"name\":\"Для всего потока\"},\"classroomByIdClassroom\":{\"idClassroom\":6,\"number\":428,\"building\":1}},{\"idRecord\":40,\"weekNumber\":3,\"weekDay\":2,\"subjOrdinalNumber\":4,\"idGroup\":1,\"idSubject\":73,\"idLecturer\":89,\"idSubjectType\":7,\"idSubjectFor\":2,\"dateFrom\":\"2017-06-20\",\"dateTo\":\"2017-06-20\",\"idClassroom\":1,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":7,\"name\":\"Учебное занятие\"},\"subjectForByIdSubjectFor\":{\"id\":2,\"name\":\"Для всей группы\"},\"classroomByIdClassroom\":{\"idClassroom\":1,\"number\":210,\"building\":1}},{\"idRecord\":6,\"weekNumber\":2,\"weekDay\":2,\"subjOrdinalNumber\":1,\"idGroup\":1,\"idSubject\":8,\"idLecturer\":5,\"idSubjectType\":7,\"idSubjectFor\":3,\"dateFrom\":\"2017-06-13\",\"dateTo\":\"2017-06-13\",\"idClassroom\":3,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":7,\"name\":\"Учебное занятие\"},\"subjectForByIdSubjectFor\":{\"id\":3,\"name\":\"Для первой подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":3,\"number\":418,\"building\":1}},{\"idRecord\":10,\"weekNumber\":3,\"weekDay\":1,\"subjOrdinalNumber\":1,\"idGroup\":1,\"idSubject\":6,\"idLecturer\":6,\"idSubjectType\":3,\"idSubjectFor\":3,\"dateFrom\":\"2017-06-19\",\"dateTo\":\"2017-06-19\",\"idClassroom\":6,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":3,\"name\":\"Практическая работа\"},\"subjectForByIdSubjectFor\":{\"id\":3,\"name\":\"Для первой подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":6,\"number\":428,\"building\":1}},{\"idRecord\":22,\"weekNumber\":2,\"weekDay\":1,\"subjOrdinalNumber\":2,\"idGroup\":1,\"idSubject\":264,\"idLecturer\":150,\"idSubjectType\":5,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-12\",\"dateTo\":\"2017-06-12\",\"idClassroom\":7,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":5,\"name\":\"Зачёт\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":7,\"number\":214,\"building\":1}},{\"idRecord\":23,\"weekNumber\":2,\"weekDay\":1,\"subjOrdinalNumber\":2,\"idGroup\":2,\"idSubject\":264,\"idLecturer\":150,\"idSubjectType\":5,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-12\",\"dateTo\":\"2017-06-12\",\"idClassroom\":7,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":5,\"name\":\"Зачёт\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":7,\"number\":214,\"building\":1}},{\"idRecord\":24,\"weekNumber\":2,\"weekDay\":1,\"subjOrdinalNumber\":2,\"idGroup\":3,\"idSubject\":264,\"idLecturer\":150,\"idSubjectType\":5,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-12\",\"dateTo\":\"2017-06-12\",\"idClassroom\":7,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":5,\"name\":\"Зачёт\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":7,\"number\":214,\"building\":1}},{\"idRecord\":25,\"weekNumber\":2,\"weekDay\":1,\"subjOrdinalNumber\":2,\"idGroup\":4,\"idSubject\":264,\"idLecturer\":150,\"idSubjectType\":5,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-12\",\"dateTo\":\"2017-06-12\",\"idClassroom\":7,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":5,\"name\":\"Зачёт\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":7,\"number\":214,\"building\":1}},{\"idRecord\":30,\"weekNumber\":4,\"weekDay\":2,\"subjOrdinalNumber\":2,\"idGroup\":1,\"idSubject\":259,\"idLecturer\":125,\"idSubjectType\":1,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-13\",\"dateTo\":\"2017-12-30\",\"idClassroom\":1,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":1,\"name\":\"Лекция\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":1,\"number\":210,\"building\":1}},{\"idRecord\":31,\"weekNumber\":4,\"weekDay\":2,\"subjOrdinalNumber\":2,\"idGroup\":2,\"idSubject\":259,\"idLecturer\":125,\"idSubjectType\":1,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-13\",\"dateTo\":\"2017-12-30\",\"idClassroom\":1,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":1,\"name\":\"Лекция\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":1,\"number\":210,\"building\":1}},{\"idRecord\":32,\"weekNumber\":4,\"weekDay\":2,\"subjOrdinalNumber\":2,\"idGroup\":3,\"idSubject\":259,\"idLecturer\":125,\"idSubjectType\":1,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-13\",\"dateTo\":\"2017-12-30\",\"idClassroom\":1,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":1,\"name\":\"Лекция\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":1,\"number\":210,\"building\":1}},{\"idRecord\":33,\"weekNumber\":4,\"weekDay\":2,\"subjOrdinalNumber\":2,\"idGroup\":4,\"idSubject\":259,\"idLecturer\":125,\"idSubjectType\":1,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-13\",\"dateTo\":\"2017-12-30\",\"idClassroom\":1,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":1,\"name\":\"Лекция\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":1,\"number\":210,\"building\":1}},{\"idRecord\":36,\"weekNumber\":2,\"weekDay\":2,\"subjOrdinalNumber\":2,\"idGroup\":1,\"idSubject\":4,\"idLecturer\":4,\"idSubjectType\":3,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-13\",\"dateTo\":\"2017-06-13\",\"idClassroom\":1,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":3,\"name\":\"Практическая работа\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":1,\"number\":210,\"building\":1}},{\"idRecord\":37,\"weekNumber\":2,\"weekDay\":2,\"subjOrdinalNumber\":2,\"idGroup\":2,\"idSubject\":4,\"idLecturer\":4,\"idSubjectType\":3,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-13\",\"dateTo\":\"2017-06-13\",\"idClassroom\":1,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":3,\"name\":\"Практическая работа\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":1,\"number\":210,\"building\":1}},{\"idRecord\":38,\"weekNumber\":2,\"weekDay\":2,\"subjOrdinalNumber\":2,\"idGroup\":3,\"idSubject\":4,\"idLecturer\":4,\"idSubjectType\":3,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-13\",\"dateTo\":\"2017-06-13\",\"idClassroom\":1,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":3,\"name\":\"Практическая работа\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":1,\"number\":210,\"building\":1}},{\"idRecord\":39,\"weekNumber\":2,\"weekDay\":2,\"subjOrdinalNumber\":2,\"idGroup\":4,\"idSubject\":4,\"idLecturer\":4,\"idSubjectType\":3,\"idSubjectFor\":4,\"dateFrom\":\"2017-06-13\",\"dateTo\":\"2017-06-13\",\"idClassroom\":1,\"cancellationsByIdRecord\":[],\"subjectTypeByIdSubjectType\":{\"id\":3,\"name\":\"Практическая работа\"},\"subjectForByIdSubjectFor\":{\"id\":4,\"name\":\"Для второй подгруппы\"},\"classroomByIdClassroom\":{\"idClassroom\":1,\"number\":210,\"building\":1}}]";

    @Test
    public void Records(){
        JSONPrarser.parsJSONtoDTORecord(rec);

    }
    String chair="[\n" +
        "  {\n" +
        "    \"idChair\": 12,\n" +
        "    \"nameChair\": \"Военная кафедра\",\n" +
        "    \"lecturers\": [\n" +
        "      {\n" +
        "        \"idLecturer\": 307,\n" +
        "        \"nameLecturer\": \"Мачихо И.О.\",\n" +
        "        \"idChair\": 12\n" +
        "      }\n" +
        "    ],\n" +
        "    \"subjects\": [\n" +
        "      {\n" +
        "        \"idSubject\": 305,\n" +
        "        \"nameSubject\": \"Военная подготовка\",\n" +
        "        \"idChair\": 12,\n" +
        "        \"eduLevel\": 2,\n" +
        "        \"abnameSubject\": \"ВП\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"idSubject\": 307,\n" +
        "        \"nameSubject\": \"\",\n" +
        "        \"idChair\": 12,\n" +
        "        \"eduLevel\": 1,\n" +
        "        \"abnameSubject\": \"??\"\n" +
        "      },\n" +
        "      {\n" +
        "        \"idSubject\": 308,\n" +
        "        \"nameSubject\": \"Военная  подготовка\",\n" +
        "        \"idChair\": 12,\n" +
        "        \"eduLevel\": 1,\n" +
        "        \"abnameSubject\": \"Военная подготовка\"\n" +
        "      }\n" +
        "    ]\n" +
        "  }]";

    @Test
    public void Chair(){
        JSONPrarser.parsJSONtoDTOChair(chair);
    }
}
