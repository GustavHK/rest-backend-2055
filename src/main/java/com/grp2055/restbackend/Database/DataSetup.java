


package com.grp2055.restbackend.Database;

import com.grp2055.restbackend.domain.Booking;
import com.grp2055.restbackend.domain.Room;
import com.grp2055.restbackend.domain.User;
import com.grp2055.restbackend.repositories.BookingRepo;
import com.grp2055.restbackend.repositories.RoomRepo;
import com.grp2055.restbackend.repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

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
        //Manuel Brugeroprettelse

      // User user1 = new User("s180000", "Hans", "Hansen", "123", "ROLE_REG");
      //  userRepo.save(user1);

        //Manuel rumoprettelse
        //Room room = new Room(5);
        // roomRepo.save(room);

        //Manuel bookingoprettelse
       /*         Booking booking = new Booking(userRepo.getOne(1).getId());
                booking.setYear(2019);
                booking.setMonth(12);
                booking.setDay(10);
                booking.setTimeblock(3);
                booking.setRoomId(1);
                bookingRepo.save(booking);*/
    }
}



