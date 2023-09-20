/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package assignmentone;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



/**
 *
 * @author Kuhle Langa
 */
public class StudentTest {
@Test
    public void TestSaveStudent() {
        Student student = new Student();
        student.saveStudent("John Doe", 18);
        assertEquals(1, student.getStudentList().size()); 
    }
    
    @Test
    public void TestSearchStudent() {
        Student student = new Student();
        student.saveStudent("Alice Smith", 20); 
        Student foundStudent = student.searchStudent(1); 
        assertNotNull(foundStudent);
        assertEquals("Alice Smith", foundStudent.getStudentName());
        assertEquals(20, foundStudent.getStudentAge());
    }
    
    @Test
    public void TestSearchStudent_StudentNotFound() {
        Student student = new Student();
        Student foundStudent = student.searchStudent(1); 
        assertNull(foundStudent);
    }
    
    @Test
    public void TestDeleteStudent() {
        Student student = new Student();
        student.saveStudent("Bob Johnson", 19);
        boolean isDeleted = student.deleteStudent(1);
        assertTrue(isDeleted);
        assertEquals(0, student.getStudentList().size());
    }
    
}
