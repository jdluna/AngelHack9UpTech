#include <math.h>;
#include <SoftwareSerial.h>

double E = 2.718281828459045235360287471352;
int sensor_radiacion = 0;
int sensor_amoniaco=1;
int sensor_metano=2;
int sensor_co2=3;

SoftwareSerial mySerial(3, 4);


int ledPin=10;

int radiacion;
int amoniaco;
int metano;
int co2;

String m_radiacion;
String m_amoniaco;
String m_metano;
String m_co2;

//double vrl_co2;
//double rsl_co2;
//double ppm_co2;

void setup() { 
  pinMode(ledPin, OUTPUT);
  mySerial.begin(9600);
  // put your setup code here, to run once
}

void loop() {
  // Lectura de los sensores
  radiacion= analogRead(sensor_radiacion)/4;
  amoniaco= analogRead(sensor_amoniaco)/4;
  metano= analogRead(sensor_metano)/4;
  co2= analogRead(sensor_co2)/4;
  
 //Calculo de PPM del CO2
 // vrl_co2=analogRead(sensor_amoniaco)*5/1023;
 //rsl_co2=(5-vrl_co2)/vrl_co2;
 //ppm_co2=pow(E,log(rsl_co2)/0.339)/4.79; 
  
  
  analogWrite(ledPin,radiacion);
  if (radiacion < 10){
    m_radiacion="00"+String(radiacion);
  } else{ 
    if (radiacion<100){
      m_radiacion="0"+String(radiacion);
        }else{
      m_radiacion=String(radiacion);
    }
  }
 
  
  if (amoniaco < 10){
    m_amoniaco="00"+String(amoniaco);
  } else{ 
    if (amoniaco<100){
      m_amoniaco="0"+String(amoniaco);
        }else{
      m_amoniaco=String(amoniaco);
    }
  }
  
  
  if (metano < 10){
    m_metano="00"+String(metano);
  } else{ 
    if (radiacion<100){
      m_metano="0"+String(metano);
        }else{
      m_metano=String(metano);
    }
  }
  
  
  if (co2 < 10){
    m_co2="00"+String(co2);
  } else{ 
    if (radiacion<100){
      m_co2="0"+String(co2);
        }else{
      m_co2=String(co2);
    }
  }
  
  
  mySerial.println('$'+m_radiacion+m_amoniaco+m_metano+m_co2+"#");
  delay(1);
   
}

