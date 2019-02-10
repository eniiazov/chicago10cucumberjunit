package test;

import cucumber.api.java.it.Ma;
import org.omg.CORBA.OBJ_ADAPTER;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCExample {


    /*
    *
    *
    |   employee_id | first_name | last_name  | salary |
    |           100 | Steven     | King       | 24000  |
    |           101 | Neen       | Kochhar    | 17000  |
    |           102 | Lex        | De Haan    | 17000  |
    *
    * */


    public static void main(String[] args) throws SQLException {

        // ec2-52-14-95-169.us-east-2.compute.amazonaws.com
        // hr
        // hr
        // 1521
        // xe
        String oracleURL = "jdbc:oracle:thin:@ec2-52-14-95-169.us-east-2.compute.amazonaws.com:1521:xe";
        String oracleUsername = "hr";
        String oraclePassword = "hr";
        /*
        * 3 main classes in JDBC
        *
        * 1. Connection
        * 2. Statement
        * 3. ResultSet
        * */

        Connection connection = DriverManager.getConnection(oracleURL, oracleUsername, oraclePassword );
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select employee_id, first_name, last_name from employees");

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<Map<String, Object>> table = new ArrayList<>();

        while(resultSet.next()){
            Map<String, Object> map = new HashMap<>();

            for(int column =1; column<=columnCount; column++){

                map.put(metaData.getColumnName(column), resultSet.getObject(column));

            }
            table.add(map);
        }

        for(Map<String, Object> map: table){

            System.out.println(map);
        }


        resultSet.close();
        statement.close();
        connection.close();



    }

    public static List<Map<String, Object>> expectedResult (){

        /*
        *
        *
        * */
        List<Map<String, Object>> table = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("employee_id", 100);
        map1.put("first_name", "Steven");
        map1.put("last_name", "King");
        map1.put("salary", 24000);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("employee_id", 101);
        map2.put("first_name", "Neen");
        map2.put("last_name", "Kochhar");
        map2.put("salary", 17000);


        Map<String, Object> map3 = new HashMap<>();
        map3.put("employee_id", 102);
        map3.put("first_name", "Lex");
        map3.put("last_name", "De Haan");
        map3.put("salary", 17000);

        table.add(map1);
        table.add(map2);
        table.add(map3);

        return table;

    }
}
