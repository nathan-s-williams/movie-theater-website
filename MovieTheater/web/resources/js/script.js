/* 
    Javascript used for header and footer sections on all pages except the index.xhtml page.
    Inserts the additional html code at end of render.

    By Nathan Williams and Akito Minosoko
 */
//Insert nav bar
const nav = document.getElementById("nav")
        .innerHTML='<nav class="nav-bar"><div class="title">Welcome to Javango</div><div class="nav-links"><a href="index.xhtml">Home</a><a href="AboutUs.xhtml">About Us</a></div></nav>';
//Insert footer
const footer = document.getElementById("footer")
        .innerHTML='<br/><br/><br/><br/><br/><hr/><div style="text-align: center">Advanced Java CS4336 Final Project<br />By Nathan Williams and Akito Minosoko</div>';



