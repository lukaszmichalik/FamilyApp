package com.lukmic.familymemberapplication.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class GetSequenceValueCallbackFamilyMember implements BeforeConvertCallback<FamilyMember> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public FamilyMember onBeforeConvert(FamilyMember familyMember) {

        if (familyMember.getId() == null) {

            Long id = jdbcTemplate.query("SELECT nextval('family_member_db.family_member_id_seq')",
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
