package com.sda.studysystem.services;

import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.School;

import java.util.List;
import java.util.Optional;

/**
 * To handle school related operations
 *
 * @author Vinod John
 */
public interface SchoolService {
    /**
     * To create a new school
     * @param school School
     */
    void createSchool(School school);

    /**
     * To find a school by its ID
     * @param id id of the school
     * @return School
     */
    School findSchoolById(Long id) throws SchoolNotFoundException;

    /**
     * To find a school by its ID
     * @param name name of the school
     * @return School
     */
    School findSchoolByName(String name) throws SchoolNotFoundException;

    /**
     * To find all schools
     * @return List of schools
     */
    List<School> findAllSchools();

    /**
     * To update an existing school
     * @param school School
     */
    void updateSchool(School school) throws SchoolNotFoundException;

    /**
     * To delete school by its ID
     * @param id id of the school
     */
    void deleteSchoolById(Long id) throws SchoolNotFoundException;

    /**
     * To restore a school by its ID
     * @param id
    */
    void restoreSchoolById(Long id) throws SchoolNotFoundException;
}
