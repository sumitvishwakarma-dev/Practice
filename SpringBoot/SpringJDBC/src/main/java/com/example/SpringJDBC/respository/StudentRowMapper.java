package com.example.SpringJDBC.respository;

import com.example.SpringJDBC.model.ResponseDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class StudentRowMapper implements RowMapper<ResponseDTO> {


    @Override
    public ResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setId(rs.getLong("id"));
        responseDTO.setName(rs.getString("name"));
        responseDTO.setEmail(rs.getString("email"));
        responseDTO.setAge(rs.getInt("age"));
        responseDTO.setRollNo(rs.getInt("roll_no"));
        responseDTO.setStream(rs.getString("stream"));
        responseDTO.setSubject(rs.getString("subject"));
        responseDTO.setCreatedAt(rs.getObject("created_at", LocalDateTime.class));
        responseDTO.setUpdatedAt(rs.getObject("updated_at", LocalDateTime.class));

        return responseDTO;
    }
}
