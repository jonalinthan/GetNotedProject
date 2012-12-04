/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaronmeltzer
 */
public class GeneralizedQueries {
    public static void update(String tableName, String valuePair[][],String conditions[][], ConnectionManager cm){
        if(tableName==null || valuePair==null || valuePair.length==0) return;
        cm.loadDriver();
        Connection c = cm.getConnection();
        String statement = "UPDATE"+tableName;
        statement+="SET";
        statement =line(statement, valuePair);
        if(conditions!= null && conditions.length>0) {
           statement = line(statement, conditions);
        }
        
        try {
            Statement stat=c.createStatement();
            stat.executeUpdate(statement);
        } catch (SQLException ex) {
            Logger.getLogger(GeneralizedQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static String line(String statement, String nameValue[][]){
        int i;
        for(i=0; i<nameValue.length; i++) {
            if(nameValue[i]==null || nameValue[i].length<2) {
                return null;
            }
            statement+= nameValue[i][0]+"="+nameValue[i][1];
            if(i!=nameValue.length-1){
             statement+=",";
            }
        }
        return statement;
    }
    
    public static void insert(String table,String[] values, String[] columns){
        if(table==null || values==null || values.length<=0){
            return;
        }
        String statement ="INSERT INTO";
        int i;
         if(columns!=null && columns.length>0){
             statement+=" (";
            for(i=0; i<columns.length; i++){
                statement+=columns[i];
                if(i!=columns.length-1){
                    statement+=", ";
                }
            }
            statement+=")";
        }
        statement+=" VALUES (";
        for(i=0; i<values.length; i++){
            statement+=values[i];
            if(i!=values.length-1){
                statement+=", ";
            }
        }
        statement+=")";
        try {
            ConnectionManager cm = ConnectionManager.getManager();
            cm.loadDriver();
            Connection c = cm.getConnection();
            Statement stat=c.createStatement();
            stat.executeUpdate(statement);
        } catch (SQLException ex) {
            Logger.getLogger(GeneralizedQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
