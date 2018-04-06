package by.bsac.timetable;


import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import by.bsac.timetable.resourc.web.JSONPrarser;

@RunWith(AndroidJUnit4.class)

public class JSONTest {
    String json="[{\"idFaculty\":1,\"nameFaculty\":\"Факультет электросвязи\",\"groups\":[{\"idGroup\":4,\"nameGroup\":\"СП442\",\"idFlow\":1,\"idFaculty\":1,\"eduLevel\":1},{\"idGroup\":5,\"nameGroup\":\"ЛК621\",\"idFaculty\":1,\"eduLevel\":2},{\"idGroup\":3,\"nameGroup\":\"СП441\",\"idFlow\":1,\"idFaculty\":1,\"eduLevel\":1},{\"idGroup\":6,\"nameGroup\":\"ПО611\",\"idFaculty\":1,\"eduLevel\":2},{\"idGroup\":7,\"nameGroup\":\"ПО612\",\"idFaculty\":1,\"eduLevel\":2},{\"idGroup\":2,\"nameGroup\":\"СТ442\",\"idFlow\":1,\"idFaculty\":1,\"eduLevel\":1},{\"idGroup\":1,\"nameGroup\":\"СТ441\",\"idFlow\":1,\"idFaculty\":1,\"eduLevel\":1}]},{\"idFaculty\":2,\"nameFaculty\":\"Факультет инжиниринга и технологий связи\",\"groups\":[{\"idGroup\":9,\"nameGroup\":\"ИТ642\",\"idFaculty\":2,\"eduLevel\":1},{\"idGroup\":8,\"nameGroup\":\"ИТ641\",\"idFaculty\":2,\"eduLevel\":1}]},{\"idFaculty\":5,\"nameFaculty\":\"Факультет довузовской подготовки\",\"groups\":[]},{\"idFaculty\":3,\"nameFaculty\":\"Факультет заочного и дистанционного образования\",\"groups\":[]},{\"idFaculty\":4,\"nameFaculty\":\"Факультет повышения квалификации и переподготовки кадров\",\"groups\":[]}]";

    @Test
    public  void main() {
        JSONPrarser.parsJSONtoDTOFacylty(json);
        System.out.println("12431412412321");
    }
}
