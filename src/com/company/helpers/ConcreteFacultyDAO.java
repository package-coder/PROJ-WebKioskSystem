package com.company.helpers;

import com.company.interfaces.FacultyDAO;
import com.company.model.FacultyPerson;
import com.company.model.StudentPerson;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class ConcreteFacultyDAO implements FacultyDAO {
    private final Connection connection;

    public ConcreteFacultyDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public FacultyPerson get(String key) {

        var sql =   """
                        SELECT *
                        FROM faculties
                        WHERE facultyId = ?;
                    """;

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, key);

            var resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                var firstName = resultSet.getString("firstName");
                var lastName = resultSet.getString("lastName");
                var age = resultSet.getInt("age");
                var birthdate = resultSet.getDate("birthdate");
                var gender = resultSet.getBoolean("gender");
                var address = resultSet.getString("address");
                var contact = resultSet.getString("contact");
                var email = resultSet.getString("email");
                var department = resultSet.getString("department");
                var degree = resultSet.getString("degree");
                var lastSchool = resultSet.getString("lastSchool");
                var civilStatus = resultSet.getString("civilStatus");

                var builder = FacultyPerson.getFacultyBuilder();
                var faculty = builder.facultyId(key)
                        .firstName(firstName)
                        .lastName(lastName)
                        .email(email)
                        .address(address)
                        .contactNumber(contact)
                        .age(age)
                        .birthdate(birthdate.toLocalDate())
                        .gender(gender)
                        .department(department)
                        .degree(degree)
                        .lastSchool(lastSchool)
                        .civilStatus(civilStatus)
                        .build();

                return (FacultyPerson) faculty;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(FacultyPerson object) {
        var sql =   """
                        UPDATE faculties 
                        SET 
                            firstName = ?,
                            lastName = ?,
                            age = ?,
                            birthdate = ?,
                            gender = ?,
                            address = ?,
                            contact = ?,
                            email = ?,
                            department = ?,
                            degree = ?,
                            lastSchool = ?,
                            civilStatus = ?
                        WHERE facultyId = ?;        
                    """;

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, object.getFirstName());
            preparedStatement.setString(2, object.getLastName());
            preparedStatement.setInt(3, object.getAge());
            preparedStatement.setDate(4, Date.valueOf(object.getBirthDate()));
            preparedStatement.setBoolean(5, object.getGender());
            preparedStatement.setString(6, object.getAddress());
            preparedStatement.setString(7, object.getContact());
            preparedStatement.setString(8, object.getEmail());
            preparedStatement.setString(9, object.getDepartment());
            preparedStatement.setString(10, object.getDegree());
            preparedStatement.setString(11, object.getLastSchool());
            preparedStatement.setString(12, object.getCivilStatus());
            preparedStatement.setString(13, object.getFacultyId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
