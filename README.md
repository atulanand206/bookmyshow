# Bookmyshow

What is the system?

- User Login
- Select Location
- Filter theatres/movies
- Availability of shows
- Book tickets

### Resources
- User
- Movie
- Theatre
- Screen
- Show
- Seats
- Location

- User
    - name
    - preferred_location
    
- Movie
    - name
    - languages
    - duration
    - release_date
    - format: 2D/3D
    
- Location
    - latLng
    - city
    
- Theatre
    - name
    - location_id
    
- Theatre_Screen
    - theatre_id
    - screen_id
    
- Theatre_Movie
    - theatre_id
    - movie_id
    
- Screen
    - seats
    - type
    - no

- ScreenType: LARGE, IMAX, 3D, 5D, AUDI
  
- Seat
    - no
    - type

- SeatType: GOLD, PLATINUM, SILVER

- ScreenConfig
    - ScreenConfigType[]
    
- ScreenConfigType
    - seat_type
    - no_of_seats
    - price

- ShowSeat
    - seat_id
    - status

- SeatStatus: VACANT, RESERVED, BOOKED

- Show
    - theatre_id
    - screen_id
    - movie_id
    - timings
    - seatmap
    
- Seatmap
    - Map<show_seat, price>
    
- Booking
    - user_id
    - show_id
    - Map<seat, price>
    - status
    
- BookingConfig
    - Map<seat_type, no_of_seats>

- BookingStatus: CREATED, BOOKED
    
### APIs

- Location Svc
    - createLocation(latLng, city)
    - readLocation(location_id)
    - updateLocation(location_id, city)
    - deleteLocation(location_id)
    
- User Svc
    - createUser(name)
    - readUser(user_id)
    - updateUser(user_id, name)
    - deleteUser(user_id)
    - setPreferredLocation(location_city_name)

- Movies Svc
    - createMovie(name, languages, duration, release_year, format)
    - readMovie(movie_id)
    - updateMovie(movie_id, languages, format)
    - deleteMovie(movie_id)
    
- Theatre Svc
    - createTheatre(name, location_id)
    - readTheatre(theatre_id)  
    - updateTheatre(theatre_id, name)
    - addScreen(theatre_id, screen_id)
    - removeScreen(theatre_id, screen_id)
    - deleteTheatre(theatre_id)
    - addMovie(theatre_id, movie_id)
    
- Screen Svc
    - createScreenConfig(config)
    - updateScreenConfig(config)
    - createScreen(screen_type, screen_config)
    - updateScreen(screen_id, screen_config)
    - readScreen(screen_id)
    - deleteScreen(screen_id)

- Show Svc
    - createShow(screen_id, movie_id, timings)
    - readShow(show_id)
    - updateShow(show_id, timings)
    - deleteShow(show_id)
  
- Booking Svc
    - createBooking(user_id, show_id, booking_config)
    - readBooking(booking_id)
    - readBookingsForUser(user_id)