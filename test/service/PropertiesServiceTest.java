package service;

import org.junit.Test;

import static org.junit.Assert.*;

public class PropertiesServiceTest {
    @Test
    public void getURLProperty() throws Exception {
        //given
        String path = "resources/connection.properties";
        String expected = "jdbc:mysql://localhost:3306/new_schema";
        //when
        String actual = PropertiesService.getProperty(path).getProperty("url");
        //then
        assertEquals("test failed", expected, actual);
    }

    @Test
    public void getUserProperty() throws Exception {
        //given
        String path = "resources/connection.properties";
        String expected = "root";
        //when
        String actual = PropertiesService.getProperty(path).getProperty("user");
        //then
        assertEquals("test failed", expected, actual);
    }

    @Test
    public void getPasswordProperty() throws Exception {
        //given
        String path = "resources/connection.properties";
        String expected = "ZinedinZidan16!";
        //when
        String actual = PropertiesService.getProperty(path).getProperty("password");
        //then
        assertEquals("test failed", expected, actual);
    }




}