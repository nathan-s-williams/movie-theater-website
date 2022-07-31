/*
Bean used for all workflow activities related to choosing a showtime.

By Nathan Williams and Akito Minosoko
 */
package bean;

//imports
import ejb.ClientValidatorEJB;
import ejb.MovieEJB;
import ejb.ShowtimesEJB;
import ejb.TheaterEJB;
import entity.Movie;
import entity.Showtimes;
import entity.Theater;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

//Session scoped bean
@Named(value = "movieTheaterBean")
@SessionScoped
public class MovieTheaterBean implements Serializable {

    //EJB references used for retrieving information.
    @EJB
    private TheaterEJB theaterEJB;
    @EJB
    private ShowtimesEJB showtimesEJB;
    @EJB
    private MovieEJB movieEJB;
    @EJB
    //Data members and objects used for storing input data.
    private ClientValidatorEJB clientValidatorEJB;
    private Theater theater = new Theater();
    private Movie movie = new Movie();
    private Showtimes showtimes = new Showtimes();
    List<String> Listseatings;
    String[] seatings = new String[8];
    String stringSeatings;
    String tempString = "";
    int numOfChosenSeats;
    
    //Constructor
    public MovieTheaterBean() { }

    //Retrieve theater ejb
    public TheaterEJB getTheaterEJB() {
        return theaterEJB;
    }

    //Set theater ejb
    public void setTheaterEJB(TheaterEJB theaterEJB) {
        this.theaterEJB = theaterEJB;
    }

    //Retrieve showtime ejb
    public ShowtimesEJB getShowtimesEJB() {
        return showtimesEJB;
    }

    //Set showtime ejb
    public void setShowtimesEJB(ShowtimesEJB showtimesEJB) {
        this.showtimesEJB = showtimesEJB;
    }

    //Retrieve movie ejb
    public MovieEJB getMovieEJB() {
        return movieEJB;
    }

    //Set movie ejb
    public void setMovieEJB(MovieEJB movieEJB) {
        this.movieEJB = movieEJB;
    }

    //Retrieve client validator ejb
    public ClientValidatorEJB getClientValidatorEJB() {
        return clientValidatorEJB;
    }

    //set client validator ejb
    public void setClientValidatorEJB(ClientValidatorEJB clientValidatorEJB) {
        this.clientValidatorEJB = clientValidatorEJB;
    }

    //Get theater
    public Theater getTheater() {
        return theater;
    }

    //Set theater
    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    //Get movie
    public Movie getMovie() {
        return movie;
    }

    //Set movie
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    //Get showtimes
    public Showtimes getShowtimes() {
        return showtimes;
    }

    //Set showtimes
    public void setShowtimes(Showtimes showtimes) {
        this.showtimes = showtimes;
    }

    //Get list of seatings
    public List<String> getListseatings() {
        return Listseatings;
    }

    //Set list of seatings
    public void setListseatings(List<String> Listseatings) {
        this.Listseatings = Listseatings;
    }

    //Get tempstring
    public String getTempString() {
        return tempString;
    }

    //Set tempstring
    public void setTempString(String tempString) {
        this.tempString = tempString;
    }
    
    //Get array of seatings
    public String[] getSeatings () {
        return seatings;
    }
    
    //Set array of seatings
    public void setSeatings(String[] seatings) {
        //Loop through seatings and append to tempString
        for(int i = 0; i < seatings.length; i++) {
            tempString = tempString + seatings[i] + " ";
        }
        this.seatings = seatings;
        //Set temp to stringSeatings
        stringSeatings = tempString;
    }
    
    //Get string seatings
    public String getStringSeatings() {
        return stringSeatings; 
    }
    
    //Set string seatings
    public void setStringSeatings(String stringSeatings) {
        this.stringSeatings = stringSeatings;
    }

    //Get number of chosen seats
    public int getNumOfChosenSeats() {
        return numOfChosenSeats;
    }

    //Set number of chosen seats
    public void setNumOfChosenSeats(int numOfChosenSeats) {
        this.numOfChosenSeats = numOfChosenSeats;
    }
    
    //Validate zip
    public void validateZipcode(FacesContext fc, UIComponent uic, Object o) {
        //Caste to input to string
        String zipcode = (String)o;
        //If zip validator fails, output error. Otherwise do nothing.
        if(!ClientValidatorEJB.validateZipcode(zipcode))
            ((UIInput) uic).setValid(false);
            FacesMessage message = new FacesMessage
                ("Zipcode must be exactly 5 digits.");
            fc.addMessage(uic.getClientId(fc), message);
    }
    
    /**************
    Index.xhtml
    **************/
    //Get all movies
    public List<Movie> getAllMovies() {
        //Query to return all movies
        return movieEJB.findAllMovies();
    }
    
    /**************
    Theaters.xhtml
    **************/
    //Show all theaters by zip
    public List<Theater> showTheatersByZipcode(String zipcode) {
        //Query to return all theaters by zip
        return theaterEJB.findByTheaterZipcode(zipcode);
    }
    
    //Store chosen theater in theater object
    //Move to Movies.xhtml
    public String getMoviesByTheater(String theaterId) {
        this.theater = theaterEJB.findByTheaterId(theaterId);
        return "Movies.xhtml";
    } 
    
    /**************
    Movies.xhtml
    **************/
    
    //Show all movies by theater
    public List<Movie> showMoviesByTheater() {
        //Query to return all movies by theater
        return movieEJB.findMoviesByTheater(this.theater.getTheaterId());
    }
    
    //Store chosen movie in movie object
    //Move to Showtimes.xhtml
    public String getShowtimesByMovie(String movieId) {
        this.movie = movieEJB.findByMovieId(movieId);
        return "Showtimes.xhtml";
    }
    
    /**************
    Showtimes.xhtml
    **************/
    
    //Show showtimes by theater and movie id.
    public List<Showtimes> showShowtimesByMovie() {
        //Query to return showtimes
        return showtimesEJB.findShowtimes(theater.getTheaterId(), movie.getMovieId());
    }
    
    //Store showtime in showtime object
    //Move to SelectSeat.xhtml
    public String getSelectSeat(java.util.Date date) {
        this.showtimes = showtimesEJB.
                findShowtimesWithDate(theater.getTheaterId(), movie.getMovieId(), date);
        return "SelectSeat.xhtml";
    }
    
    /**************
    SelectSeats.xhtml
    **************/
    
    //Calculate number of seats
    public String calcNumOfSeats() {
        //Call set number of seats with the original lenth minus the length with spaces
        setNumOfChosenSeats(
                this.stringSeatings.length() - this.stringSeatings.replaceAll(" ", "").length()
        );
        return "Payment.xhtml";
    }
    
    //Calc total
    public int calcTotal() {
        return numOfChosenSeats * 10;
    }
    
    //Close session bean
    public void closeBean() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().invalidateSession();
    }
    
}
