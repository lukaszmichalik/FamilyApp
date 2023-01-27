package com.lukmic.familyspringboot.config;

import com.lukmic.familyspringboot.family.Family;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class GetSequenceValueCallback implements BeforeConvertCallback<Family> {

    private Logger log = LogManager.getLogger(GetSequenceValueCallback.class);

    private final JdbcTemplate jdbcTemplate;

    public GetSequenceValueCallback(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Family onBeforeConvert(Family family) {
        if (family.getId() == null) {
            log.info("Get the next value from a database sequence and use it as the primary key");

            Long id = jdbcTemplate.query("SELECT nextval('family_id_seq')",
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
