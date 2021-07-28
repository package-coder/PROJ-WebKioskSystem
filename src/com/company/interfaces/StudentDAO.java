package com.company.interfaces;

import com.company.model.StudentPerson;

public interface StudentDAO extends GetObjectDAO<StudentPerson, String>, UpdateObjectDAO<StudentPerson> {
}
