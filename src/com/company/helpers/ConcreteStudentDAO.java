package com.company.helpers;

import com.company.interfaces.StudentDAO;
import com.company.model.StudentPerson;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class ConcreteStudentDAO implements StudentDAO {
    private final Connection connection;

    public ConcreteStudentDAO(Connection connection) {
        this.connection = connection;
        if (connection == null)
            throw new IllegalArgumentException();
    }

    @Override
    public StudentPerson get(String key) {

        var sql =   """
                        SELECT *
                        FROM students
                        WHERE studentId = ?;
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
                var course = resultSet.getString("course");
                var college = resultSet.getString("college");
                var yearLevel = resultSet.getInt("yearLevel");

                var builder = StudentPerson.getStudentBuilder();
                var student = builder.studentId(key)
                        .firstName(firstName)
                        .lastName(lastName)
                        .email(email)
                        .address(address)
                        .contactNumber(contact)
                        .age(age)
                        .birthdate(birthdate.toLocalDate())
                        .gender(gender)
                        .college(college)
                        .course(course)
                        .college(college)
                        .level(yearLevel)
                        .build();

                return (StudentPerson) student;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(StudentPerson object) {
        var sql =   """
                        UPDATE students 
                        SET 
                            firstName = ?,
                            lastName = ?,
                            age = ?,
                            birthdate = ?,
                            gender = ?,
                            address = ?,
                            contact = ?,
                            email = ?,
                            course = ?,
                            college = ?,
                            yearLevel = ?
                        WHERE studentId = ?;        
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
            preparedStatement.setString(9, object.getCourse());
            preparedStatement.setString(10, object.getCollege());
            preparedStatement.setInt(11, object.getYearLevel());
            preparedStatement.setString(12, object.getStudentId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
