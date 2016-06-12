<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="description" content="Servicio que te ayudara a monitorear en tiempo real tu globo UP , el cual ayudara a limpiar el aire contaminado de tu ciudad">
    <title>Location of your baloon</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Quicksand" />
    <script src="http://maps.googleapis.com/maps/api/js"></script>
    <script src="js/maps.js"></script>
    <script src="js/ajax2.js"></script>
  </head>
  <body>
    <div class="wrapper">
      <div class="contenedor">
        <header>
            <div class="logo_up">
                            <a href="index.html"><img src="img/logo.png" alt="logo UP" width="80px" height="80px" class="logo_img"/></a>
            </div>
            <nav>
              <ul>
              <li><a class="active" href="index.html">HOME</a></li>
              <li><a href="index.html#img1">HOW IT WORKS</a></li>
              <li><a href="index.html#img2">WHAT IS UP</a></li>
              <li><a href="#about">EXPLORE</a></li>
            </ul>
            </nav>
	      <div class="socials">
              <a href="https://www.facebook.com/uptechaerialplant/"><img src="img/fb.png" alt="fb" class="fb"/></a>
              <a href="https://twitter.com/uppollclean"><img src="img/twt.png" alt="twt" class="twt"/></a>
              <a href="https://www.youtube.com/channel/UCbMuA50uHX9LNUmWoCtdfYA"><img src="img/you.png" alt="you" class="you"/></a>
            </div>
        </header>
        <section>
            <div class="datos_globo">
              <h5> Informacion sobre mi Globo Up : </h5>
              <table id="mitabla" width="70%">

                <div id="contenido"><div>
              

            </table>
            </div>
            <div class="mapa_globo">
                <div id="googleMap" class="googleMap" style="width:100%;height:inherit;"></div>
            </div>
        </section>
        <footer>
          <div class="footer_informacion">
            <div class="nav_links">
              <ul>
              <li><a class="active" href="index.html">HOME</a></li>
              <li><a href="index.html#img1">HOW IT WORKS</a></li>
              <li><a href="index.html#img2">WHAT IS UP</a></li>
              <li><a href="index.php">EXPLORE</a></li>
            </ul>
            </div>
            <div class="copyright">
                Copyright © 2016 - 2017 UP, All Rights Reserved
            </div>
          </div>
        </footer>
      </div>
    </div>
  </body>
</html>
