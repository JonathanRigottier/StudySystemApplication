package com.sda.studysystem.services.implementations;

import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.School;
import com.sda.studysystem.repositories.SchoolRepository;
import com.sda.studysystem.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of School Service
 *
 * @author Vinod John
 */
@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public void createSchool(School school) {
        school.setActive(true);
        schoolRepository.save(school);
    }

    @Override
    public School findSchoolById(Long id) throws SchoolNotFoundException {
        Optional<School> optionalSchool = schoolRepository.findById(id);

        if(optionalSchool.isEmpty()) {
            throw new SchoolNotFoundException(id);
        }

        return optionalSchool.get();
    }

    @Override
    public School findSchoolByName(String name) throws SchoolNotFoundException {
        Optional<School> optionalSchool = schoolRepository.findByName(name);

        if(optionalSchool.isEmpty()) {
            throw new SchoolNotFoundException(name);
        }
        return optionalSchool.get();
    }

    @Override
    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public void updateSchool(School school) throws SchoolNotFoundException {
        if(findSchoolById(school.getId()) != null) {
            schoolRepository.saveAndFlush(school);
        }
    }

    @Override
    public void deleteSchoolById(Long id) throws SchoolNotFoundException {
        School school = findSchoolById(id);
        school.setActive(false);
        schoolRepository.saveAndFlush(school);
    }

    @Override
    public void restoreSchoolById(Long id) throws SchoolNotFoundException {
        School school = findSchoolById(id);
        school.setActive(true);
        schoolRepository.saveAndFlush(school);
    }
}
