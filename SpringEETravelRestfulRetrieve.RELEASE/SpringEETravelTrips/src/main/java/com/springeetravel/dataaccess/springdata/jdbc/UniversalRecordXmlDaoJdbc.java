/*
 */
package com.springeetravel.dataaccess.springdata.jdbc;

import com.mysema.query.sql.HSQLDBTemplates;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLQueryImpl;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.types.Constant;
import com.mysema.query.types.Path;
import com.springeetravel.dataaccess.dao.UniversalRecordXmlDao;
import com.springeetravel.dataaccess.exceptions.IllegalOrphanException;
import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import com.springeetravel.dataaccess.support.UniversalRecordXmlMarshaller;
import com.springeetravel.domain.QUniversalRecordXml;
import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.domain.UniversalRecordXml;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import org.springframework.data.jdbc.query.QueryDslJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author peter //
 */
@Named("universalRecordXmlDao")
public class UniversalRecordXmlDaoJdbc implements UniversalRecordXmlDao {

    private JdbcTemplate template;
    private QueryDslJdbcTemplate qryDslTemplate;
    private UniversalRecordXmlMappingQuery mappingQuery;
    private final String sqlFindById = "select ID, CREATE_DATE, XML from UNIVERSAL_RECORDS_XML where ID=?";
    private final String sqlInsert = "insert into UNIVERSAL_RECORDS_XML (ID, CREATE_DATE, XML) values (NULL, ?, ?)";
    private final String sqlCount = "select count(*) from UNIVERSAL_RECORDS_XML";
    @Inject
    @Named("universalRecordXmlMarshaller")
    private UniversalRecordXmlMarshaller universalRecordXmlMarshaller;

    @Inject
    public void setDataSource(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
        mappingQuery = new UniversalRecordXmlMappingQuery(dataSource, sqlFindById);
        qryDslTemplate = new QueryDslJdbcTemplate(dataSource);
    }

    @Override
    public void create(UniversalRecordXml universalRecordxML) {
        final String marshalledUr = universalRecordXmlMarshaller.marshall(universalRecordxML.getUniversalRecord());
        universalRecordxML.setXml(marshalledUr);

        final Timestamp timestamp = new java.sql.Timestamp(universalRecordxML.getCreateDate().getTime());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                new PreparedStatementCreator() {

                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[]{"ID"});
                        ps.setTimestamp(1, timestamp);
                        ps.setString(2, marshalledUr);
                        return ps;
                    }
                }, keyHolder);
        Number key = keyHolder.getKey();
        universalRecordxML.setId(key.longValue());
        universalRecordxML.getUniversalRecord().setId(universalRecordxML.getId());
    }

    @Override
    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(UniversalRecordXml universalRecord) throws IllegalOrphanException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UniversalRecordXml find(Long id) {
        UniversalRecordXml findObject = mappingQuery.findObject(id);
        if (findObject != null) {
            UniversalRecord unmarshal = universalRecordXmlMarshaller.unmarshal(findObject.getXml());
            unmarshal.setId(findObject.getId());
            findObject.setUniversalRecord(unmarshal);
            return findObject;
        }
        return null;
    }

    @Override
    public UniversalRecordXml findById(Long id) {

        SQLTemplates dialect = new HSQLDBTemplates();
        SQLQuery sqlQuery = new SQLQueryImpl(dialect);

        final QUniversalRecordXml qUrx = QUniversalRecordXml.universalRecordXml;
        SQLQuery where = sqlQuery.from(qUrx).where(qUrx.id.eq(id));

        RowMapper<UniversalRecordXml> mapper = new RowMapper<UniversalRecordXml>() {

            @Override
            public UniversalRecordXml mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                UniversalRecordXml urx = new UniversalRecordXml();
                urx.setId(resultSet.getLong(getParameterName(qUrx.id)));
                urx.setCreateDate(resultSet.getTimestamp(getParameterName(qUrx.createDate)));
                urx.setXml(resultSet.getString(getParameterName(qUrx.xml)));
                return urx;
            }
        };
        UniversalRecordXml urx = qryDslTemplate.queryForObject(sqlQuery, mapper, qUrx.id, qUrx.createDate, qUrx.xml);
        if (urx != null) {
            UniversalRecord unmarshal = universalRecordXmlMarshaller.unmarshal(urx.getXml());
            urx.setUniversalRecord(unmarshal);
            urx.getUniversalRecord().setId(urx.getId());
        }
        return urx;
    }

    private String getParameterName(Path<?> path) {
        return (String) ((Constant<?>) path.getMetadata().getExpression()).getConstant();
    }

    @Override
    public List<UniversalRecordXml> find() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UniversalRecordXml> find(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getCount() {
        return template.queryForInt(sqlCount);
    }
}
