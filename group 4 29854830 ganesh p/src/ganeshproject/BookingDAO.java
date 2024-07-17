package ganeshproject;

import java.sql.*;

public class BookingDAO {

	 public String adding(Bookings booking) throws SQLException{
	        String query = "INSERT INTO booking values (?, ?, ?, ?, ?, ?)";
	        Connection con = Dbconnect.getConnection();
	        PreparedStatement pstmt = con.prepareStatement(query);
	         java.sql.Date sqldate=new java.sql.Date(booking.getBookingDate().getTime());
	         
	         pstmt.setInt(1, booking.getBookingId());
	            pstmt.setInt(2, booking.getShowtimeId());
	            pstmt.setInt(3, booking.getUserId());
	            pstmt.setDate(4, sqldate);
	            pstmt.setInt(5, booking.getTotalTickets());
	            pstmt.setInt(6,  booking.getTotalPrice());
	            
	            int res=pstmt.executeUpdate();
	            if(res>0) {
	            	return "added on the app";
	            	
	            }
	            else {
	            	return "Nothing";
	            	
	            }
	            
	            
	            
	       }
	 public void viewall(int bookingId1) throws SQLException {
  	   String query ="select showtime_id,user_id,booking_date,total_tickets,total_price from booking where booking_id= ? ";
  	   Connection con=Dbconnect.getConnection();
  	   PreparedStatement pstmt=con.prepareStatement(query);
  	   pstmt.setInt(1, bookingId1);
  	   ResultSet rs= pstmt.executeQuery();
  	   while(rs.next()) {
  		   System.out.println(rs.getInt(1));
  
  		   System.out.println(rs.getInt(2));
  		  
  		   System.out.println(rs.getDate(3));
  		   System.out.println(rs.getInt(4));
  		    System.out.println(rs.getInt(5));
  	   }
  	   
    }
	 public void update(Bookings booking,int bookid) throws SQLException{
         String sql = "UPDATE booking SET booking_id = ?, showtime_id = ?, user_id = ?, booking_date = ?, total_tickets = ?, total_price=? WHERE booking_id= ?";
         Connection conn = Dbconnect.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         java.sql.Date sqldate=new java.sql.Date(booking.getBookingDate().getTime());
             pstmt.setInt(1, booking.getBookingId());
             pstmt.setInt(2,booking.getShowtimeId() );
             pstmt.setInt(3, booking.getUserId());
             pstmt.setDate(4,sqldate);
             pstmt.setInt(5,booking.getTotalTickets() );
             pstmt.setInt(6, booking.getTotalPrice() );
             pstmt.setInt(7, bookid);
            
             
             int res=pstmt.executeUpdate();
             if(res>0) {
          	   System.out.print("Updated done");
             }
             else {
          	   System.out.print("Not Updated ");
             }
     }
	 public void delete(int bookingId) throws SQLException{
			String query="Delete from booking where booking_id=?";
		    Connection conn = Dbconnect.getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, bookingId);
	        int res=pstmt.executeUpdate();
	        if(res>0) {
	        	System.out.print("deleted done ");
	        }
	        else {
	        	System.out.print("not deleted");
	        }
		}

}
