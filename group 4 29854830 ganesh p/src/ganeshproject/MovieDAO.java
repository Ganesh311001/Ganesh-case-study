package ganeshproject;

import java.sql.*;
public class MovieDAO {
	public String add(Movies movie) throws SQLException {
	       String query="Insert into movie values(?,?,?,?,?)";
	       Connection con = Dbconnect.getConnection();
	    
	      PreparedStatement pst = con.prepareStatement(query);
	     // Date date=(Date) movie.getDate();
	      
	      java.sql.Date sqldate = new java.sql.Date(movie.getDate().getTime());
	      
	      Time sqltime= Time.valueOf(movie.getTime());
	      
	      pst.setInt(1,movie.getId());
	      pst.setString(2, movie.getTitle());
	      pst.setString(3, movie.getGenre());
	      pst.setTime(4, sqltime);
	      pst.setDate(5, sqldate);
	   
	       int result=pst.executeUpdate();
	       if(result>0) {
	       return "added";
	       }
	       else {
	         return "not added please try again there is a error on code";
	       }
	     }
	     
	     public void viewDetails(int id) throws SQLException {
	       String query="select title,genre,duration,release_date from movie where movie_id= ?";
	       Connection con = Dbconnect.getConnection();
	     
	      PreparedStatement pst = con.prepareStatement(query);
	      pst.setInt(1, id);
	      
	     ResultSet rs= pst.executeQuery();
	     
	     while(rs.next()) {
	         System.out.println(rs.getString(1));
	       System.out.println(rs.getString(2));
	       System.out.println(rs.getTime(3));
	       System.out.println(rs.getDate(4));
	     }
	     }
	     
	     public void update(Movies movie,int id) throws SQLException {
	       String query="update movie  set movie_id=? , title=?,genre=?,duration=?,release_date=? where movie_id=?";
	       Connection con = Dbconnect.getConnection();
	    
	      PreparedStatement pst = con.prepareStatement(query);
	     // Date date=(Date) movie.getDate();
	      
	      java.sql.Date sqldate = new java.sql.Date(movie.getDate().getTime());
	      
	      Time sqltime= Time.valueOf(movie.getTime());
	      
	      pst.setInt(1,movie.getId());
	      pst.setString(2, movie.getTitle());
	      pst.setString(3, movie.getGenre());
	      pst.setTime(4, sqltime);
	      pst.setDate(5, sqldate);
	      pst.setInt(6, id);
	      
	      int res=pst.executeUpdate();
	      
	      if(res>0) {
	        System.out.println("updated successfully");
	      }
	      else {
	       System.out.println("Not updated try again");
	      }
	     }
	     
	     public void delete(int movieId) throws SQLException {
	       String query="Delete from movie where movie_id=?";
	       Connection con = Dbconnect.getConnection();
	    
	      PreparedStatement pst = con.prepareStatement(query);
	      
	      pst.setInt(1, movieId);
	      int res=pst.executeUpdate();
	      if(res>0) {
	        System.out.println("deleted successfully");
	      }
	      else {
	        System.out.println("Not deleted try again");
	      }
	      
	     }
}
