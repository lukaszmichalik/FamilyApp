package com.lukmic.familyapplication.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class GetSequenceValueCallbackFamily implements BeforeConvertCallback<Family> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Family onBeforeConvert(Family family) {
        if (family.getId() == null) {

            Long id = jdbcTemplate.query("SELECT nextval('family_db.family_id_seq')",
                    rs -> {
                        if (rs.next()) {
                            return rs.getLong(1);
                        } else {
                            throw new SQLException("Unable to retrieve value from sequence family_id_seq.");
                        }
                    });
            family.setId(id);
        }
        return family;
    }
}
