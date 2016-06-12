/*
* Parametros a utilizar
*/
  var seconds = 2; // el tiempo en que se refresca
	var divid = "contenido"; // div a actualizar
	var url = "json.php"; // pongo el archivo que ira en el div

	function refreshdiv(){

		// utilizo el objeto : XMLHttpRequest de Microsoft

		var xmlHttp;
		try{
			xmlHttp=new XMLHttpRequest(); // Firefox, Opera 8.0+, Safari, Chrome
		}
		catch (e){
			try{
				xmlHttp=new ActiveXObject("Msxml2.XMLHTTP"); //Para Internet Explorer
			}
			catch (e){
				try{
					xmlHttp=new ActiveXObject("Microsoft.XMLHTTP"); // tambien para IE
				}
				catch (e){
					alert("Tu explorador no soporta AJAX.");
					return false;
				}
			}
		}

		// Timestamp para prevenir que los navegadores cacheen la peticion GET,
    // de esta forma hacemos que la informacion cambie constantenmente
		var timestamp = parseInt(new Date().getTime().toString().substring(0, 10));
		var nocacheurl = url+"?t="+timestamp;

		// Codeando ...

		xmlHttp.onreadystatechange=function(){ //almaceno el nombre de la funcion con este evento
			if(xmlHttp.readyState== 4 && xmlHttp.readyState != null){ //usamos la propiedad readyState para tener
                                                                //el estado del XMLHttpRequest 0-4
				document.getElementById(divid).innerHTML=xmlHttp.responseText;// colocamos el resultado en el navegador
				setTimeout('refreshdiv()',seconds*1000);
			}
		}
    // para enviar la informacion al servidor
		xmlHttp.open("GET",nocacheurl,true); // metodo open de XMLHttpRequest ,
		xmlHttp.send(null);                  // metodo open de XMLHttpRequest cuando enviamos por metodo get
	}

	// Empieza la función de refrescar

	window.onload = function(){
		refreshdiv(); // corremos inmediatamente la funcion
	}
