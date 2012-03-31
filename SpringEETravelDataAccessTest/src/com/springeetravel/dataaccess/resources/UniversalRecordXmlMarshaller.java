/*
 */
package com.springeetravel.dataaccess.resources;

import com.springeetravel.dataaccess.springdata.jdbc.UniversalRecordXmlDaoJdbc;
import com.springeetravel.domain.UniversalRecord;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.io.IOUtils;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

/**
 *
 * @author peter
 */
@Named("universalRecordXmlMarshaller")
public class UniversalRecordXmlMarshaller {

    @Inject
    private Marshaller marshaller;
    @Inject
    private Unmarshaller unmarshaller;

    public UniversalRecord unmarshal(String xml) {
        try {
            Logger.getLogger(UniversalRecordXmlMarshaller.class.getName()).log(Level.INFO, "unmarshalled UniversalRecord: {0}", xml);
            InputStream in = IOUtils.toInputStream(xml);
            Source source = new StreamSource(in);
            Object unmarshal = unmarshaller.unmarshal(source);
            return (UniversalRecord) unmarshal;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String marshall(UniversalRecord state) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            StreamResult result = new StreamResult(bos);
            marshaller.marshal(state, result);
            String xml = new String(bos.toByteArray());
            Logger.getLogger(UniversalRecordXmlMarshaller.class.getName()).log(Level.INFO, "marshalled UniversalRecord: {0}", xml);
            return xml;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
