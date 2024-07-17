package ganeshproject;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
public class Newmain {

	public static void main(String[] args) throws ParseException,SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.movie");
		System.out.println("2.showtime");
		System.out.println("3.booking");
		
		System.out.println("Enter the Choice");
		
		int choice=sc.nextInt();
		
		int flag=1;
		switch(choice) {
		case 1:
			managemovie(sc);
			break;
		case 2 :
			manageShowtimes(sc);
			break;
			
		case 3:
			manageBooking(sc);
			break;
		}

	}
	public static void managemovie(Scanner sc) throws ParseException, SQLException {
	    boolean flag=true;
	    Movies movie=new Movies();
	    MovieDAO moviedao=new MovieDAO();
	    while(flag) {
	      System.out.println("1.Add the movie");
	      System.out.println("2.view movie details");
	      System.out.println("3.update the movie");
	      System.out.println("4.delete the movie");
	      System.out.println("5.exit");
	       int ch=sc.nextInt();
	       
	       switch(ch) {
	       case 1:
	         
	         System.out.println("Enter the movie id");
	         int id=sc.nextInt();
	         sc.nextLine();
	         System.out.println("Enter the title");
	         String title=sc.nextLine();
	         System.out.println("enter the genre");
	         String genre=sc.nextLine();
	         
	         LocalTime time;
	         System.out.println("Enter the time: hh:mm:ss");
	         String timeString=sc.next();
	         time=LocalTime.parse(timeString);
	         Date date;
	         System.out.println("Enter the date: dd-mm-yyyy");
	         String dateString=sc.next();
	         SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
	         date= dateFormat.parse(dateString);
	         movie.setId(id);
	         movie.setTitle(title);
	         movie.setGenre(genre);
	         movie.setDate(date);
	         movie.setTime(time);
	         
	         String res=moviedao.add(movie);
	         System.out.println(res);
	         break;
	         
	       case 2:
	         System.out.println("Enter the id of the movie to view details");
	         int movieid=sc.nextInt();
	         
	         moviedao.viewDetails(movieid);
	         break;
	       case 3:
	         System.out.println("provide information for the movie update");
	         System.out.println("Enter the movie id to  update:");
	         int mId=sc.nextInt();
	         System.out.println("Enter the update movie id");
	         int updateId=sc.nextInt();
	         sc.nextLine();
	         System.out.println("Enter the update movie title");
	         String updateTitle=sc.nextLine();
	         System.out.println("enter the genre");
	         String updateGenre=sc.nextLine();
	         Date updatedate;
	         System.out.println("Enter the date: dd-mm-yyyy");
	         String updatedateString=sc.next();
	         SimpleDateFormat dateFormatt=new SimpleDateFormat("dd-mm-yyyy");
	         updatedate=dateFormatt.parse(updatedateString);
	         LocalTime updatetime;
	         System.out.println("Enter the time: hh:mm:ss");
	         String updatetimeString=sc.next();
	         updatetime=LocalTime.parse(updatetimeString);
	         
	         
	         movie.setId(updateId);
	         movie.setTitle(updateTitle);
	         movie.setGenre(updateGenre);
	         movie.setDate(updatedate);
	         movie.setTime(updatetime);
	         
	         moviedao.update(movie,mId);
	         
	         break;
	         
	       case 4:
	         System.out.println("Enter the movie id to delete:");
	         int deleteid=sc.nextInt();
	         moviedao.delete(deleteid);
	         break;
	         
	       case 5:
	         System.out.println("Exited");
	         flag=false;
	         break;
	         
	         
	         
	       
	         
	         
	       }
	      
	      
	    }
	  }
	 private static void manageShowtimes(Scanner sc) throws  ParseException , SQLException{
		    boolean flag=true;
		    Showtimes showtime =new Showtimes();
		    ShowtimeDAO showtimedao=new  ShowtimeDAO();
		    while (flag) {
	        System.out.println("1. Add Showtime");
	        System.out.println("2. View Showtimes");
	        System.out.println("3. Update Showtime");
	        System.out.println("4. Delete Showtime");
	        System.out.print("Enter your choice: ");
	        int co = sc.nextInt();
	         // consume newline 

	        switch (co) {
	            case 1:
	                ;
	                // consume newline
	                System.out.print("Enter showtime ID");
	                int showtimeId=sc.nextInt();
	               
	                System.out.print("Enter movie ID: ");
	                int movieId = sc.nextInt();
	               
	                LocalTime startTime;
	                System.out.print("Enter start time : hh:mm:ss ");
	                String  st=sc.next();
	                startTime=LocalTime.parse(st);
	                // end time
	                
	                LocalTime endTime;
	                System.out.print("Enter end time :  hh:mm:ss ");
	                String et=sc.next();
	                endTime=LocalTime.parse(et);
	                System.out.print("Enter available seats: ");
	                int availableSeats = sc.nextInt();
	                System.out.print("Enter total seats: ");
	                int totalSeats = sc.nextInt();
	                sc.nextLine(); // consume newline
	                
	                showtime.setMovieId(movieId);
	                showtime.setShowtimeId(showtimeId);
	                showtime.setStartTime(startTime);
	                showtime.setEndTime(endTime);
	                showtime.setAvailableSeats(availableSeats);
	                showtime.setTotalSeats(totalSeats);
	                String ans=showtimedao.add(showtime);
	                System.out.println(ans);
	                break;
	           case 2:
	                  System.out.println("Enter the id of  showtime to view all");
	               int showtimeid=sc.nextInt();
	               showtimedao.viewall(showtimeid);
	                break;
	            case 3:
	            	System.out.println("provide information for the movie update");
	                System.out.print("Enter showtime ID to update: ");
	                int showid = sc.nextInt();
	                sc.nextLine(); // consume newline
	                
	                
	                
	                
	                
	                System.out.println("Enter the update movieId");
	                int updatemovieId=sc.nextInt();
	                System.out.println("enter the update starttime");
	                LocalTime updatestarttime;
	                System.out.println("Enter the time: hh:mm:ss");
	                String updatetimeString=sc.next();
	                updatestarttime=LocalTime.parse(updatetimeString);
	                
	                System.out.println("Enter the updateendtime");
	                LocalTime updateendtime;
	                System.out.println("Enter the time: hh:mm:ss");
	                String updatetimeStr=sc.next();
	                updateendtime=LocalTime.parse(updatetimeString);
	                System.out.print("Enter the update available seats");
	                int updateavailableseats=sc.nextInt();
	                System.out.print("Enter the update total seats");
	                int updatetotalseats=sc.nextInt();
	                
	                showtime.setShowtimeId(showid);
	                showtime.setMovieId(updatemovieId);
	                showtime.setStartTime(updatestarttime);
	                showtime.setEndTime(updateendtime);
	                showtime.setAvailableSeats(updateavailableseats);
	                showtime.setTotalSeats(updatetotalseats);
	                
	                showtimedao.update(showtime,showid);
	                
	                break;
	            case 4:
	                System.out.print("Enter showtime ID to delete: ");
	                int showtimeIdToDelete = sc.nextInt();
	                sc.nextLine(); // consume newline
	                showtimedao.delete(showtimeIdToDelete);
	                System.out.println("Showtime deleted successfully.");
	                break;
	            case 5:
	            	System.out.println("EXIT");
	            	flag=false;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	                
	        }
	    }
	 }
	 private static void manageBooking(Scanner sc) throws  ParseException , SQLException{
		    boolean flag=true;
		    Bookings booking =new Bookings();
		    BookingDAO Bookingdao=new  BookingDAO();
		    while (flag) {
		    	
		    
	        System.out.println("1. Add Booking");
	        System.out.println("2. View Booking");
	        System.out.println("3. Update Booking");
	        System.out.println("4. Delete Booking");
	        System.out.print("Enter your choice: ");
	        int cho = sc.nextInt();
	        
	        switch(cho) {
	        case 1: 
	        	System.out.print("Enter Booking  ID");
                int bookingId=sc.nextInt();
               
                System.out.print("Enter showtimeId ID: ");
                int showtimeId = sc.nextInt();
                
                System.out.print("Enter user ID: ");
                int userId = sc.nextInt();
               
                Date bookingdate;
                System.out.println("Enter the date: dd-mm-yyyy");
                String dateString=sc.next();
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
                bookingdate= dateFormat.parse(dateString);
                // end time
                
                
                System.out.print("Enter total tickets : ");
                int totalticket = sc.nextInt();
                System.out.print("Enter total price: ");
                int totalprice = sc.nextInt();
                sc.nextLine(); // consume newline
                
                booking.setBookingId(bookingId);
                booking.setShowtimeId(showtimeId);
                booking.setUserId(userId);
                booking.setBookingDate(bookingdate);
                booking.setTotalTickets(totalticket);
                booking.setTotalPrice(totalprice);
                String ans=Bookingdao.adding(booking);
                System.out.println(ans);
                break;
                
                
	        case 2:
	        	   System.out.println("Enter the id of  booking to view all");
	               int bookingId1=sc.nextInt();
	               Bookingdao.viewall(bookingId1);
	         
	               
	        case 3:      
	        	      System.out.println("provide information for the booking update");
	        	      System.out.println("Enter the booking id to update");
	        	      int bookid=sc.nextInt();
	        	      System.out.println("Enter the update booking id");
	        	      int updatebookid=sc.nextInt();
	                System.out.println("Enter the update showtimeId");
	                int updateshowtimeId=sc.nextInt();
	                System.out.println("Enter the update userId");
	                int updateUserId=sc.nextInt();
	                System.out.println("Enter the booking date");
	                Date updatebookingdate;
	                System.out.println("Enter the date: dd-mm-yyyy");
	                String updatedateString=sc.next();
	                SimpleDateFormat dateFormatt=new SimpleDateFormat("dd-mm-yyyy");
	                updatebookingdate=dateFormatt.parse(updatedateString);
	                System.out.print("Enter the update available seats");
	                int updateTotaltickets=sc.nextInt();
	                System.out.print("Enter the update total seats");
	                int updatetotalprice=sc.nextInt();
	                
	                booking.setBookingId(updatebookid);
	                booking.setShowtimeId(updateshowtimeId);
	                booking.setUserId(updateUserId);
	                booking.setBookingDate(updatebookingdate);
	                booking.setTotalTickets(updateTotaltickets);
	                booking.setTotalPrice(updatetotalprice);
	                
	                Bookingdao.update(booking,bookid);
	                
	        case 4:
	        	System.out.print("Enter booking ID to delete: ");
                int bookingIdToDelete = sc.nextInt();
                sc.nextLine(); // consume newline
                Bookingdao.delete(bookingIdToDelete);
                System.out.println("booking deleted successfully.");
                break;
	        }
	        
	      
		    
		     
       }
	 }
	 
}


