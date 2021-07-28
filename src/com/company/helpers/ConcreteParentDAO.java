package com.company.helpers;

import com.company.interfaces.ParentDAO;
import com.company.model.ParentPerson;
import com.company.model.StudentPerson;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConcreteParentDAO implements ParentDAO {
    private final Connection connection;

    public ConcreteParentDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ParentPerson get(String key) {

        var sql =   """
                        SELECT *
                        FROM parents
                        WHERE parentId = ?;
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
                var occupation = resultSet.getString("occupation");
                var degree = resultSet.getString("degree");
                var lastSchool = resultSet.getString("lastSchool");
                var civilStatus = resultSet.getString("civilStatus");
                var children = resultSet.getBytes("children");

                var builder = ParentPerson.getParentBuilder();
                var parent = builder.parentId(key)
                        .firstName(firstName)
                        .lastName(lastName)
                        .email(email)
                        .address(address)
                        .contactNumber(contact)
                        .age(age)
                        .birthdate(birthdate.toLocalDate())
                        .gender(gender)
                        .occupation(occupation)
                        .degree(degree)
                        .lastSchool(lastSchool)
                        .civilStatus(civilStatus)
                        .build();

                //TODO children's id = convert and assign (byte[] to list<string>)

                return (ParentPerson) parent;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(ParentPerson object) {
        var sql =   """
                        UPDATE parents 
                        SET 
                            firstName = ?,
                            lastName = ?,
                            age = ?,
                            birthdate = ?,
                            gender = ?,
                            address = ?,
                            contact = ?,
                            email = ?,
                            occupation = ?,
                            degree = ?,
                            lastSchool = ?,
                            civilStatus = ?
                        WHERE parentId = ?;        
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
            preparedStatement.setString(9, object.getOccupation());
            preparedStatement.setString(10, object.getDegree());
            preparedStatement.setString(11, object.getLastSchool());
            preparedStatement.setString(12, object.getCivilStatus());
            preparedStatement.setString(13, object.getParentId());

            /*
            TODO convert list of children's id to byte array;
            preparedStatement.setBytes(12, object.getChildrenId());
             */

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
