<?php
$json = @file_get_contents('http://demo-jdluna.rhcloud.com/api/identificador/0000045');
$datos = json_decode($json);
if($datos==null){

  error_reporting(E_ERROR);
  echo "No se ha podido obtener los datos de tu Globo UP, Intentelo mas tarde";

}else{

  $count=0;


      foreach($datos as $key => $value)
      {
        if($count==0 || $count>8){
          echo "";
        }else{
          echo "<tr><td><img src='img/".$count.".png' alt='".$count."' width='30px' height='30px'/></td><td>".$key." : </td><td> ".$value."</td></tr><br>";
        }
  $count++;
      }

}
?>
