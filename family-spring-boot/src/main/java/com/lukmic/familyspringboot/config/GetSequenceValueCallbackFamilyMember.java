package com.lukmic.familyspringboot.config;

import com.lukmic.familyspringboot.familyMember.FamilyMember;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class GetSequenceValueCallbackFamilyMember implements BeforeConvertCallback<FamilyMember> {

    private Logger log = LogManager.getLogger(GetSequenceValueCallbackFamilyMember.class);

    private final JdbcTemplate jdbcTemplate;

    public GetSequenceValueCallbackFamilyMember(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public FamilyMember onBeforeConvert(FamilyMember familyMember) {
        if (familyMember.getId() == null) {
            log.info("Get the next value from a database sequence and use it as the primary key");

            Long id = jdbcTemplate.query("SELECT nextval('family_member_id_seq')",
                    rs -> {
                        if (rs.next()) {
                            return rs.getLong(1);
                        } else {
                            throw new SQLException("Unable to retrieve value from sequence family_member_id_seq.");
                        }
                    });
            familyMember.setId(id);
        }
        return familyMember;
    }
}
