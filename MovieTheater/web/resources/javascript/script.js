/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const nav = document.getElementById("nav")
        .innerHTML='<nav class="nav-bar"><div class="title">Welcome to Javango</div><div class="nav-links"><a href="index.xhtml">Home</a><a href="Theaters.xhtml">Theaters</a><a href="Movies.xhtml">Movies</a><a href="AboutUs.xhtml">About Us</a></div></nav>';

const footer = document.getElementById("footer")
        .innerHTML='<div style="text-align: center">Advanced Java CS4336 Final Project<br />By Nathan Williams and Akito Minosoko</div>';

function movieTitle(theMovieTitle) {
                document.getElementById("output-movie-title").innerHTML= theMovieTitle
}

