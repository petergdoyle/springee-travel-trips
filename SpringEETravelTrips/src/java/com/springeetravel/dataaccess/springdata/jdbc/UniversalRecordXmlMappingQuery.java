/*
 */
package com.springeetravel.dataaccess.springdata.jdbc;

import com.springeetravel.domain.UniversalRecordXml;
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
public class UniversalRecordXmlMappingQuery extends MappingSqlQuery<UniversalRecordXml> {

    public UniversalRecordXmlMappingQuery(DataSource ds, String sql) {
        super(ds, sql);
        super.declareParameter(new SqlParameter("ID", Types.BIGINT));
    }

    @Override
    protected UniversalRecordXml mapRow(ResultSet rs, int i) throws SQLException {
        UniversalRecordXml urx = new UniversalRecordXml();
        urx.setId(rs.getLong("ID"));
        urx.setCreateDate(rs.getTimestamp("CREATE_DATE"));
        urx.setXml(rs.getString("XML"));
        return urx;
    }
}
