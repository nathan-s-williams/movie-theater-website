This README document is for the Final Project for CS 4336.0U1.
MovieTheater fulfills the Final project for CS 4336.0U1.

Dependencies:
This project uses the following libraries
-JSF 2.3
-Java EE 8 API Library
-Primefaces 10.0
-JDK 1.8

The purpose of the project to create web application that will simulate purchasing tickets from
a movie theater.

Web Application Flowchart:
From the index.xhtml, there will be an input text to search for zipcodes and at the bottom of the webpage,  there will be a section for customers to view all of the movies. Once a zipcode is entered, the customer will be forwarded to the Theaters.xhtml where they are shown the theaters available at that zipcode and given the option to chose a theater. They are then forwarded to Movies.xhtml where they are given the options to chose a movie at that theater.
Once the customer clicks "Showtimes" next to a movie they want to watch, they will be sent to 
Showtimes.xhtml. Showtimes.xhtml allows the user to chose a showtimes they would like. They are sent to the SelectSeat.xhtml once they click "Seating" next to a showtimes they desire.
SelectSeat.xhtml shows displays the seatings available. Once the customer chooses the seatings they would like to purchase, they are forwarded to Payment.xhtml. In the Payment.xhtml, the customer enters some information about their payment and is sent to the Receipt.xhtml page where they are shown their purchase information.


resources/CSS:
-index.css: This css file contains the styling for the index.xhtml page. The tags styled include
body, title-background, title, top-nav, top-nav a, ui-datatable, movie-data-table, and ui-column-title.

-main.css: This css file contains the styling all other xhtml pages, excluding index.xhtml. The
tags styled include body, nav-bar, title, nav-links, nav-links a, center-image,
receipt-total-label-ui-grid, ui-databale, theater-data-table, movie-data-table,
showtimes-data-table, and ui-column-title

-seat.css: This css file contains styling for the SelectSeat.xhtml page. The tags styled include
body, screen, seating, left-seats, middle-seats, and purchase button. The checkbox inputs are
styled into a grid structure to display architecture similar to a movie theater seating.



resources/images:
-DukeWaving.png is a reference image
-EverthingEverywhereAllAtOnce.jpeg is an image for the movie Everything Everywhere all at once
-JurassicWorldDominion.png is an image for the movie Jurassic World Dominion 
-LeagueOfSuperPets.jpeg is an image for the movie League Of Super Pets
-MinionsTheRiseOfGru.jpeg is the image for the movie Minions: The Rise of Gru
-Nope.jpeg is the image for the movie Nope
-ThorLoveAndThunder.jpeg is for the movie Thor: Love and Thunder
-TopGunMaverick.jpeg is for the movie Top Gun Maverick
-WhereTheCrawdadsSing.jpeg is for the movie WhereTheCrawdadsSing.jpeg



resources/js:
-script.js: This Javascript file contains the code to place html code into the element Id: 'nav'. 
The javascript file also contains the code to place html code into the element Id: ‘footer’



web/:
- AboutUs.xhtml: This xhtml page will display the top navigation and the footer found on all xhtml pages.

- index.xhtml: This xhtml page is the homepage and the first page the customer will view. The index page includes an input text where the customer must enter a zipcode to find appropriate theaters in their zipcode. The submit button will move the webpage to Theaters.xhtml and set the value zipcode in the theater variable in the movieTheaterBean. Below the zipcode input text, there is a graphic image, movie title, and a movie description for each of the movies in the database. This data table uses the movieTheaterBean.allMovies method to receive a list of all movies.

- Theaters.xhtml: This xhtml page outputs all of the theaters in the zipcode that the customer inputted by invoking the “showTheatersByZipcode(theater.zipcode)”. Clicking the command button next to the theater name will invoke the getMoviesByTheater in the movieTheaterBean

-Movies.xhtml: This xhtml page outputs all of the movies played at a certain theater by invoking the “showMoviesByTheater” function. The page also shows the movie image, name, and the description. Clicking the command button “Showtimes” next to a movie name will invoke the “getShowtimesByMovie()” function with the parameter of movieId for the selected movie.

-Showtimes.xhtml: This xhtml page outputs all of the shows for the corresponding movie as well as the price and the movie image. Clicking on the command button “Seating” will invoke the “getSelectSeat()” function with the parameter of showtime next to the showtime of the customer’s choosing.

-SelectSeat.xhtml: This xhtml page displays the layout of the movie theater with their seatings in a grid format and many check boxes. The first row corresponds to A, second to B and so on. The first column represents seat 1, second to seat 2, and so on. Once desired seats have been selected, the customer may click “Submit” where the “calcNumOfSeats” function is invoked and the variable seatings have been set.

-Payment.xhtml: This xhtml page displays the title of the movie, theater name, the number of chosen seats, the zipcode, the seatings, and the total cost of the seatings. The customer inserts the first name, last name, card number , expiration date, and cvv to the corresponding variables in the paymentBean. If the credit card number is not exactly 16 digits, the validator “validateCardNumber” will produce an error and not let the customer move on to the next page. The “Confirm purchase button will redirect the customer to the “Receipt.xhtml” page.

-Receipt.xhtml: This xhtml page will output the first name, last name, theater name, movie title, showtime, card number , expiration date, cvv, and the total cost of the purchase to the customer.




CDI Bean:
These files control the general workflow of purchasing a movie ticket. Each class offers data retrieval and storage as well as navigation and other UI based functionality.

-MovieTheaterBean.java - This file has all the logic pertaining to the workflow for finding a showtime. Its data objects include the ejb files for data retrieval and other basic storage for showtime information.


-PaymenBean.java - This file handles the logic, getters and setters, and the variables related to the payment logic of the application. The validateCardNumber() function takes in the “value” object from it’s parameter and converts it into a string. Then the function will call the ClientValidatorEJB.validateCreditcard() with the converted object as a parameter. If the EJB function returns true, then the function will output an error.






EJB:
Each ejb file handles the business logic of our database. Its main function is to handle the data retrieval for our website with some additional validation on user input.

-ClientValidatorEJB.java - This validates that each zipcode entered is exactly 5 digits long, and that each creditcard number is exactly 16 digits long.

-MovieEJB - This handles the data retrieval of movie entities.
-ShowtimesEJB.java - This handles the data retrieval of showtime entities.
-TheaterEJB - This handles the data retrieval of theater entities.


Entities:
Our project entities represent the table and table attributes of our database. The name of our db is “MovieDB” which was populated with theater, movie and showtime information. Local zipcodes were used for the theater locations, which consist of:

75201	75201	75201	75202	75202	75202	75203	75203	75203	75204	75204	75204	75205	75205	75205	75206	75206	75206	75207	75207	75207	75208	75208	75208	75209	75209	75209	75210	75210	75210	75211	75211	75211	75212	75212	75212	75214	75214	75214	75215	75215	75215	75216	75216	75216	75217	75217	75217	75218	75218	75218	75219	75219	75219	75220	75220	75220	75221	75221	75221	75222	75222	75222	75223	75223	75223	75224	75224	75224	75225	75225	75225	75226	75226	75226	75227	75227	75227	75228	75228	75228	75229	75229	75229	75230	75230	75230	75231	75231	75231	75232	75232	75232	75233	75233	75233	75234	75234	75234	75235	75235	75235	75236	75236	75236	75237	75237	75237	75238	75238	75238	75239	75239	75239	75240	75240	75240	75241	75241	75241	75242	75242	75242	75243	75243	75243	75244	75244	75244	75245	75245	75245	75246	75246	75246	75247	75247	75247	75248	75248	75248	75249	75249	75249	75250	75250	75250	75251	75251	75251	75252	75252	75252	75253	75253	75253	75258	75258	75258	75260	75260	75260	75261	75261	75261	75262	75262	75262	75263	75263	75263	75264	75264	75264	75265	75265	75265	75266	75266	75266	75267	75267	75267	75270	75270	75270	75275	75275	75275	75277	75277	75277	75283	75283	75283	75284	75284	75284	75285	75285	75285	75286	75286	75286	75287	75287	75287	75294	75294	75294	75295	75295	75295	75301	75301	75301	75303	75303	75303	75310	75310	75310	75312	75312	75312	75313	75313	75313	75315	75315	75315	75320	75320	75320	75323	75323	75323	75326	75326	75326	75336	75336	75336	75339	75339	75339	75342	75342	75342	75346	75346	75346	75350	75350	75350	75353	75353	75353	75354	75354	75354	75355	75355	75355	75356	75356	75356	75357	75357	75357	75359	75359	75359	75360	75360	75360	75363	75363	75363	75364	75364	75364	75367	75367	75367	75368	75368	75368	75370	75370	75370	75371	75371	75371	75372	75372	75372	75373	75373	75373	75374	75374	75374	75376	75376	75376	75378	75378	75378	75379	75379	75379	75380	75380	75380	75381	75381	75381	75382	75382	75382	75386	75386	75386	75387	75387	75387	75388	75388	75388	75389	75389	75389	75390	75390	75390	75391	75391	75391	75392	75392	75392	75393	75393	75393	75394	75394	75394	75395	75395	75395	75396	75396	75396	75397	75397	75397	75398	75398	75398

Entity Files:

-Movie.java - Represents the movie objects and attributes. Each entity has a unique id, name, description and image. Named queries were used to get all movies or find a subset of those movies based on the movie id or theater.

-MoviesAtTheater.java - Represents the many-to-many relationship table between theater and movie. It consists of a composite primary key with theaterId and movieId. Its other two attributes are a theater object and movie object which were used to model the relationship between the two tables.

-MoviesAtTheaterPK.java - This entity represents the composite primary key of  MoviesAtTheater.

-Showtimes.java - Showtimes is a weak entity that has a many-to-one relationship with MoviesAtTheater. It contains all of the individual showtimes and prices for each theater-movie combination. It has a composite primary key which consists of the same key as MoviesAtTheater with the addition of showtime to ensure uniqueness.

-ShowtimesPK.java - This entity represents the composite primary key of Showtimes.

-Theater.java - Represents the theater entity and its attributes. Each entity has a unique id, theater name and zipcode.

