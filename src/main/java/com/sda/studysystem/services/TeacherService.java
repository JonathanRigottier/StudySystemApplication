package com.sda.studysystem.services;

import com.sda.studysystem.exceptions.TeacherNotFoundException;
import com.sda.studysystem.models.Teacher;

import java.util.List;

/**
 * To handle teacher related operations
 *
 * @author Rigottier Jonathan
 */
public interface TeacherService {
    /**
     * To create a new teacher
     * @param teacher Teacher
     */
    void createTeacher(Teacher teacher);

    /**
     * To find a teacher by its ID
     * @param id id of the teacher
     * @return Teacher
     */
    Teacher findTeacherById(Long id) throws TeacherNotFoundException;

    /**
     * To find all teachers
     * @return List of teachers
     */
    List<Teacher> findAllTeachers();

    /**
     * To update an existing teacher
     * @param teacher Teacher
     */
    void updateTeacher(Teacher teacher) throws TeacherNotFoundException;

    /**
     * To delete teacher by its ID
     * @param id id of the teacher
     */
    void deleteTeacherById(Long id) throws TeacherNotFoundException;

    /**
     * To restore a teacher by its ID
     * @param id
     */
    void restoreTeacherById(Long id) throws TeacherNotFoundException;
}
