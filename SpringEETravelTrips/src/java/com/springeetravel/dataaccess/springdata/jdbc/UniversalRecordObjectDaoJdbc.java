/*
 */
package com.springeetravel.dataaccess.springdata.jdbc;

import com.springeetravel.dataaccess.dao.UniversalRecordObjectDao;
import com.springeetravel.dataaccess.exceptions.IllegalOrphanException;
import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.domain.UniversalRecordObject;
import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author peter
 */
@Named("universalRecordObjectDao")
public class UniversalRecordObjectDaoJdbc implements UniversalRecordObjectDao {

    private JdbcTemplate template;
    private UniversalRecordObjectMappingQuery mappingQuery;
    private final String sqlFindById = "select ID, CREATE_DATE, OBJECT_VALUE from UNIVERSAL_RECORDS_OBJECT where ID=?";
    private final String sqlInsert = "insert into UNIVERSAL_RECORDS_OBJECT (ID, CREATE_DATE, OBJECT_VALUE) values (NULL, ?, ?)";
    private final String sqlCount = "select count(*) from UNIVERSAL_RECORDS_OBJECT";

    @Inject
    public void setDataSource(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.mappingQuery = new UniversalRecordObjectMappingQuery(dataSource, sqlFindById);
    }

    @Override
    public void create(UniversalRecordObject universalRecordObject) {

        final byte[] serialisedUr = serialise(universalRecordObject.getUniversalRecord());
        final SqlLobValue sqlLobValue = new SqlLobValue(serialisedUr);
        final Timestamp timestamp = new java.sql.Timestamp(universalRecordObject.getCreateDate().getTime());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                new PreparedStatementCreator() {

                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[]{"ID"});
                        ps.setTimestamp(1, timestamp);
                        ps.setBytes(2, serialisedUr);
                        return ps;
                    }
                }, keyHolder);
        Number key = keyHolder.getKey();
        universalRecordObject.setId(key.longValue());
        universalRecordObject.getUniversalRecord().setId(universalRecordObject.getId());
    }

    @Override
    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(UniversalRecordObject universalRecord) throws IllegalOrphanException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UniversalRecordObject find(Long id) {
        UniversalRecordObject findObject = mappingQuery.findObject(id);
        if (findObject != null) {
            UniversalRecord deserialised = deserialise(findObject.getObjectValue());
            deserialised.setId(findObject.getId());
            findObject.setUniversalRecord(deserialised);
            return findObject;
        }
        return null;
    }

    @Override
    public List<UniversalRecordObject> find() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UniversalRecordObject> find(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getCount() {
        return template.queryForInt(sqlCount);
    }

    public UniversalRecord deserialise(byte[] byteArray) {
        try {
            ObjectInputStream oip = new ObjectInputStream(new ByteArrayInputStream(byteArray));
            UniversalRecord ur = (UniversalRecord) oip.readObject();
            Logger.getLogger(UniversalRecordObjectDaoJdbc.class.getName()).log(Level.INFO, "deserialise UniversalRecord: {0}", ur);
            return ur;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public byte[] serialise(UniversalRecord state) {
        try {
            Logger.getLogger(UniversalRecordObjectDaoJdbc.class.getName()).log(Level.INFO, "serialise UniversalRecord: {0}", state);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(state);
            oos.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
