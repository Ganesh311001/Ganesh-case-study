create database cinema;

use cinema; 
// showtime table 
create table showtime(
  showtime_id INT  PRIMARY KEY,
    movie_id INT,
    start_time time ,
    end_time time ,
    available_seats INT  ,
    total_seats INT ,
    FOREIGN KEY (movie_id) REFERENCES Movie(movie_id)
);
// Movie Table 
CREATE TABLE Movie (
    movie_id INT  PRIMARY KEY,
    title VARCHAR(255) ,
    genre VARCHAR(255) ,
    duration time ,
    release_date Date
);
// Booking Table
CREATE TABLE Booking (
    booking_id INT  PRIMARY KEY,
    showtime_id INT,
    user_id INT ,
    booking_date DATE ,
    total_tickets INT ,
    total_price int,
    FOREIGN KEY (showtime_id) REFERENCES Showtime(showtime_id),
     FOREIGN KEY (user_id) REFERENCES usertab(user_id)
);
// user table 
CREATE table usertab(
 user_id int primary key,
 username varchar(255),
 useremail varchar(255)
 
 
 );

