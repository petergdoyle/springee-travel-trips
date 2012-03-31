/*
 */
package com.springeetravel.dataaccess.springdata.jdbc;

import com.springeetravel.domain.UniversalRecordObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.sql.DataSource;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

/**
 *
 * @author peter
 */
public class UniversalRecordObjectMappingQuery extends MappingSqlQuery<UniversalRecordObject> {

    public UniversalRecordObjectMappingQuery(DataSource ds, String sql) {
        super(ds, sql);
        super.declareParameter(new SqlParameter("ID",Types.BIGINT));
    }

    @Override
    protected UniversalRecordObject mapRow(ResultSet rs, int i) throws SQLException {
        UniversalRecordObject uro = new UniversalRecordObject();
        uro.setId(rs.getLong("ID"));
        uro.setCreateDate(rs.getTimestamp("CREATE_DATE"));
        uro.setObjectValue(rs.getBytes("OBJECT_VALUE"));
        return uro;
    }
}
