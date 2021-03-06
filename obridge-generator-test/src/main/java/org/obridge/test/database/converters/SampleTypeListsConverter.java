package org.obridge.test.database.converters;

import org.obridge.test.database.objects.*;
import oracle.jdbc.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@Generated("org.obridge.generators.ConverterObjectGenerator")
public final class SampleTypeListsConverter {

    public static final String TYPE_NAME = "SAMPLE_TYPE_LISTS";

    private SampleTypeListsConverter() {
    }

    public static Struct getStruct(SampleTypeLists o, Connection connection) throws SQLException {
    if (o == null) {
        return null;
    }
    List<Object> struct = new ArrayList<Object>();
    struct.add(0, SampleTypeOneConverter.getListArray(o.getList1(), connection, "SAMPLE_TYPE_ONE_LIST")); // LIST1
    struct.add(1, SampleTypeTwoConverter.getListArray(o.getList2(), connection, "SAMPLE_TYPE_TWO_GROUP")); // LIST2
    struct.add(2, SampleTypeTwoConverter.getListArray(o.getList3(), connection, "SAMPLE_TYPE_TWO_LIST")); // LIST3
    struct.add(3, PrimitiveTypeConverter.getListArray(o.getList4(), connection, "SIMPLE_STRING_LIST")); // LIST4
    struct.add(4, PrimitiveTypeConverter.getListArray(o.getList5(), connection, "SIMPLE_NUMBER_LIST")); // LIST5
    struct.add(5, PrimitiveTypeConverter.getListArray(o.getList6(), connection, "SIMPLE_INTEGER_LIST")); // LIST6
    struct.add(6, PrimitiveTypeConverter.getListArray(o.getList7(), connection, "SIMPLE_DATE_LIST")); // LIST7
    return connection.createStruct(TYPE_NAME, struct.toArray());
}

    public static Array getListArray(List<SampleTypeLists> o, Connection c, String typeName) throws SQLException {
    OracleConnection connection = c.unwrap(OracleConnection.class);
    ArrayDescriptor arrayDescriptor = new ArrayDescriptor(typeName, connection);
    if (o == null) {
        return new ARRAY(arrayDescriptor, connection, new Object[0]);
    }
    List<Object> array = new ArrayList<Object>(o.size());
    for (SampleTypeLists e : o) {
        array.add(SampleTypeListsConverter.getStruct(e, connection));
    }
    return new ARRAY(arrayDescriptor, connection, array.toArray());
}

    public static SampleTypeLists getObject(Struct struct) throws SQLException {
    if (struct == null || struct.getAttributes() == null || struct.getAttributes().length == 0) {
        return null;
    }
    SampleTypeLists result = new SampleTypeLists();
    Object[] attr = struct.getAttributes();
    if (attr[0] != null) {
        result.setList1(SampleTypeOneConverter.getObjectList((Array)attr[0])); // LIST1
    }
    if (attr[1] != null) {
        result.setList2(SampleTypeTwoConverter.getObjectList((Array)attr[1])); // LIST2
    }
    if (attr[2] != null) {
        result.setList3(SampleTypeTwoConverter.getObjectList((Array)attr[2])); // LIST3
    }
    if (attr[3] != null) {
        result.setList4(PrimitiveTypeConverter.asList((Array) attr[3], String.class)); // LIST4
    }
    if (attr[4] != null) {
        result.setList5(PrimitiveTypeConverter.asList((Array) attr[4], BigDecimal.class)); // LIST5
    }
    if (attr[5] != null) {
        result.setList6(PrimitiveTypeConverter.asList((Array) attr[5], Integer.class)); // LIST6
    }
    if (attr[6] != null) {
        result.setList7(PrimitiveTypeConverter.asList((Array) attr[6], Date.class)); // LIST7
    }
    return result;
}

    public static List<SampleTypeLists> getObjectList(Array array) throws SQLException {
    List<SampleTypeLists> result = new ArrayList<SampleTypeLists>();
    ResultSet rs = null;
    try {
        rs = array.getResultSet();
        while (rs.next()) {
            result.add(SampleTypeListsConverter.getObject((Struct) rs.getObject(2)));
        }
    } finally {
        if (rs != null) {
            rs.close();
        }
    }
    return result;
}

}
