/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketbus;
import java.sql.*; 
import java.util.*;

/**
 *
 * @author whiz
 */
public class Database {
    StringBuffer sb = new StringBuffer();
    Scanner sc = new Scanner(System.in);
    String sql = "";
     boolean hasil;
    
    public boolean insert(String table, String[] data){
        sql = sb.append("INSERT INTO `"+table+"` VALUES(").toString();
        for(int i = 0; i < data.length ; i++){
            sql = sb.append("?").toString();
            if(i+1 != data.length){
                sql = sb.append(",").toString();
            } else {
                sql = sb.append(",?").toString();
            }
        }
        sql = sb.append(");").toString();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");   
            String urlValue = getUrlValue();
            
            Connection conn = DriverManager.getConnection(urlValue);
            PreparedStatement pStatement = null;
            
            pStatement = conn.prepareStatement(sql);
            
            for(int i = 0; i < data.length ; i++){
                pStatement.setString(i+1,data[i]);
                if(i+1 == data.length){
                    pStatement.setString(i+2,"1");
                }
            }
            int intBaris = pStatement.executeUpdate();
            if(intBaris > 0){
               hasil = true;
            } else {
               hasil = false;
            }
             
            pStatement.close();
            conn.close();
        } catch(SQLException e)
        {
            //System.out.println(e);
            if(table == "t_bus"){
                System.out.println("Kode Bus sudah ada!");
            }
            hasil = false;
        } catch (ClassNotFoundException e) {
            hasil = false;
        }
        
        return hasil;
    }
    
    public List<Map<String, Object>> select(String table,String where){
        
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        Map<String, Object> row = null;
        
        if(where == ""){
            sql="SELECT * FROM `"+table+"` WHERE `aktif`=1;";        
        } else {
            sql="SELECT * FROM `"+table+"` WHERE `aktif`=1 AND "+where+";";
        }
        
        try
        {
            String urlValue = getUrlValue();
            
            Connection conn = DriverManager.getConnection(urlValue);
            PreparedStatement pStatement = null;
            
            pStatement = conn.prepareStatement(sql);
            
            ResultSet rs = pStatement.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            Integer columnCount = metaData.getColumnCount();

            while (rs.next()) {
                row = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), rs.getObject(i));
            }
            resultList.add(row);
        }
            pStatement.close();
            conn.close();
        } catch(SQLException e)
        {
            System.out.println("Gagal Mengambil Data = "+e);
            sc.nextLine();
        } 
        
        return resultList;
    }
    
    public boolean update(String table,String[] col, String[] data,String where){
        sql = sb.append("UPDATE `"+table+"` SET ").toString();
        for(int i = 1; i < col.length ; i++){
            sql = sb.append(col[i-1]+"=?").toString();
            if(i+1 != col.length){
                sql = sb.append(",").toString();
            } else {
                sql = sb.append(","+col[i]+"=?").toString();
            }
        }
        
        sql = sb.append(where+";").toString();
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");   
            String urlValue = getUrlValue();
            
            Connection conn = DriverManager.getConnection(urlValue);
            PreparedStatement pStatement = null;
            
            pStatement = conn.prepareStatement(sql);
            
            for(int i = 0; i < data.length ; i++){
                pStatement.setString(i+1,data[i]);
            }
            if(pStatement.executeUpdate()>0){
                hasil = true;
            } else {
                hasil = false;
            }
            
            pStatement.close();
            conn.close();
        } catch(SQLException e)
        {
            if(table == "t_bus"){
                System.out.println("Kode Bus sudah ada!");
            }
            hasil = false;
        } 
// catch (ClassNotFoundException e) {
//            hasil = false;
//        }
        
        return hasil;
    }
    
    public boolean delete(String table,String where){
        sql = "UPDATE `"+table+"` SET `aktif`=0 WHERE aktif=1 AND "+where;
        
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");   
            String urlValue = getUrlValue();
            
            Connection conn = DriverManager.getConnection(urlValue);
            PreparedStatement pStatement = null;
            
            pStatement = conn.prepareStatement(sql);
            
            if(pStatement.executeUpdate()>0){
                hasil = true;
            } else {
                hasil = false;
            }
            
            pStatement.close();
            conn.close();
        } catch(SQLException e)
        {
            hasil = false;
        } 
// catch (ClassNotFoundException e) {
//            hasil = false;
//        }
        
        return hasil;
    }
    
    public String getUrlValue(){
        String user="root";
        String pwd="";
        String host="localhost";
        String db="tiketBus";
        
        return "jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pwd;
    }
}
