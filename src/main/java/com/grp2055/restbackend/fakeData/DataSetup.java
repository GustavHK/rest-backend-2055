package com.grp2055.restbackend.fakeData;

import com.grp2055.restbackend.models.Booking;
import com.grp2055.restbackend.models.Room;
import com.grp2055.restbackend.models.User;
import com.grp2055.restbackend.repositories.BookingRepo;
import com.grp2055.restbackend.repositories.RoomRepo;
import com.grp2055.restbackend.repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Klasse til at lave falsk data så SQL forbindelse ikke behøves endnu



@Component
public class DataSetup implements CommandLineRunner {

            private final BookingRepo bookingRepo;
            private final RoomRepo roomRepo;
            private final UserRepo userRepo;

            public DataSetup(BookingRepo bookingRepo, RoomRepo roomRepo, UserRepo userRepo) {
                this.bookingRepo = bookingRepo;
                this.roomRepo = roomRepo;
                this.userRepo = userRepo;
            }


            @Override
            public void run(String... args) throws Exception {

                Booking booking1 = new Booking(1,1,1);
                bookingRepo.save(booking1);
                Booking booking2 = new Booking(2,2,4);
                bookingRepo.save(booking2);
                Booking booking3 = new Booking(3,3,2);
                bookingRepo.save(booking3);



                Room room1 = new Room(1);
                room1.setSize(5);
                roomRepo.save(room1);

                Room room2 = new Room(5);
                room2.setSize(3);
                roomRepo.save(room2);

                Room room3 = new Room(10);
                room3.setSize(10);
                roomRepo.save(room3);


                User user1 = new User(true,249);
                user1.setBookingId(1);
                userRepo.save(user1);
    }
}
