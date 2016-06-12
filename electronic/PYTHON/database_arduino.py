import sqlite3
import numpy as np
import time
import serial
import thread
import requests
import json
url = 'http://demo-jdluna.rhcloud.com/api/'
headers = {'content-type': 'application/json'}

ser = serial.Serial('COM36', 9600)

conn = sqlite3.connect('database.db')
c = conn.cursor()

def create_table():
    c.execute("CREATE TABLE IF NOT EXISTS muestra(fecha TEXT, radiacion REAL, amoniaco REAL, metano REAL,  co2 REAL)")

def data_entry():
    c.execute("INSERT INTO muestra VALUES('2016-01-11 13:53:39',0,0,0,0)")
    conn.commit()

def data_entry_values(radiacion,amoniaco,metano,co2):
    c.execute("INSERT INTO muestra VALUES('2016-01-11 13:53:39',"+str(radiacion)+","+str(amoniaco)+","+str(metano)+","+str(co2)+")")
    conn.commit()

create_table()
data_entry()


while 1:
    time.sleep(1)
    read_serial=ser.readline()
    sensores = str(read_serial)
    if len(sensores)>12:
        if sensores[0]=='$':
            if sensores[13]=='#':
                radiacion=int(sensores[1:4])
                amoniaco=int(sensores[4:7])
                metano=int(sensores[7:10])
                co2=int(sensores[10:13])
                data_entry_values(radiacion,amoniaco,metano,co2)

                medi={'id':'0', 'identificador':'0000045','indicadorMetano':str(metano),'indicadorAmoniaco':str(amoniaco),'indicadorTemperatura':'2.5','indicadorHumedad':'5.2','indicadorCrecimiento':'2.2','indicadorCo2':str(co2),'indicadorLuz':str(radiacion),'longitud':'-77.08030029999999','latitud':'-12.08030029999999', 'fechaRegistro': '2014-01-01 23:28:56.782Z'}



                r = requests.post(url,data=json.dumps(medi),headers=headers)
                
                
                print "Radiacion : " + str(radiacion)
                print "Amoniaco : " + str(amoniaco)
                print "Metano : " + str(metano)
                print "CO2 : " + str(co2)
                print "--------------"
                print "--------------"
                
            else:   
                print "nada"
        else:
            print "nada"
    else:
        print "nada"    


