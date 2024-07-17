package ganeshproject;
import java.sql.*;
public class ShowtimeDAO {
       public String add(Showtimes showtime) throws SQLException{
	        String query = "INSERT INTO showtime values (?, ?, ?, ?, ?, ?)";
	        Connection con = Dbconnect.getConnection();
	        PreparedStatement pstmt = con.prepareStatement(query);
	         Time sqltime=Time.valueOf(showtime.getStartTime());
	         Time sqltime1=Time.valueOf(showtime.getEndTime());
	            pstmt.setInt(1, showtime.getShowtimeId());
	            pstmt.setInt(2, showtime.getMovieId());
	            pstmt.setTime(3, sqltime );
	            pstmt.setTime(4, sqltime1);
	            pstmt.setInt(5, showtime.getAvailableSeats());
	            pstmt.setInt(6, showtime.getTotalSeats());
	            
	            int res=pstmt.executeUpdate();
	            if(res>0) {
	            	return "added on the app";
	            	
	            	
	            	
	            	
	            }
	            else {
	            	return "Nothing";
	            	
	            }
	            
	            
	            
	       }
       public void viewall(int showtimeid) throws SQLException {
    	   String query ="select movie_id,start_time,end_time,available_seats,total_seats from showtime where showtime_id= ? ";
    	   Connection con=Dbconnect.getConnection();
    	   PreparedStatement pstmt=con.prepareStatement(query);
    	   pstmt.setInt(1, showtimeid);
    	   ResultSet rs= pstmt.executeQuery();
    	   while(rs.next()) {
    		   System.out.println(rs.getInt(1));
    		   System.out.println(rs.getTime(2));
    		   System.out.println(rs.getTime(3));
    		   System.out.println(rs.getInt(4));
    		   System.out.println(rs.getInt(5));
    	   }
    	   
      }
       public void update(Showtimes showtime,int showtimeid) throws SQLException{
           String sql = "UPDATE Showtime SET movie_id = ?, start_time = ?, end_time = ?, available_seats = ?, total_seats = ? WHERE showtime_id = ?";
           Connection conn = Dbconnect.getConnection();
           PreparedStatement pstmt = conn.prepareStatement(sql);
           Time sqltime=Time.valueOf(showtime.getStartTime());
	         Time sqltime1=Time.valueOf(showtime.getEndTime());
               pstmt.setInt(1, showtime.getMovieId());
               pstmt.setTime(2,sqltime  );
               pstmt.setTime(3, sqltime1);
               pstmt.setInt(4,showtime.getAvailableSeats());
               pstmt.setInt(5,showtime.getTotalSeats() );
               pstmt.setInt(6, showtimeid );
              
               
               int res=pstmt.executeUpdate();
               if(res>0) {
            	   System.out.print("Updated done");
               }
               else {
            	   System.out.print("Not Updated ");
               }
       }
	public void delete(int showtimeId) throws SQLException{
		String query="Delete from showtime where showtime_id=?";
	    Connection conn = Dbconnect.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, showtimeId);
        int res=pstmt.executeUpdate();
        if(res>0) {
        	System.out.print("deleted done ");
        }
        else {
        	System.out.print("not deleted");
        }
	}

}
