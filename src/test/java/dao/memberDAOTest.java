package dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class memberDAO_Test {

    MemberDAO dao = new MemberDAO();

    @Test
    void getConnection() {
        assertNotNull(dao.getConnection());
    }

    @Test
    void idDupCheck() {
        String existID = "super";
        String notExistID = "notUser";

        assertEquals(dao.idDupCheck(existID), 0);
        assertEquals(dao.idDupCheck(notExistID), 1);
    }
}