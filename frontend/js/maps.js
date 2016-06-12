
var myCenter=new google.maps.LatLng(-12.0722841,-77.08030029999999);

function initialize()
{
var mapProp = {
center:myCenter,
zoom:7,
mapTypeId:google.maps.MapTypeId.ROADMAP /*tipo de mapa a usar 2d*/
};

var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);

var marker=new google.maps.Marker({
position:myCenter,
icon:'img/globo.png',
animation:google.maps.Animation.BOUNCE
});

marker.setMap(map);
}

google.maps.event.addDomListener(window, 'load', initialize);
