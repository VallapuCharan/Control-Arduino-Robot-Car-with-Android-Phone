char command;
String string;
boolean ledon = false;
boolean bledon = false;
boolean leftion = false;
boolean rightion = false;
boolean motoron = false;
boolean parking = false;
#define led 8
#define bled 12
#define leftled 4
#define rightled 2
#define rightMotor1 9 // bo motors
#define rightMotor2 10
#define leftMotor1 5 // bo motors
#define leftMotor2 6


      void setup()
  {
    Serial.begin(9600);
    pinMode(rightMotor1, OUTPUT);
    pinMode(rightMotor2, OUTPUT);
    pinMode(leftMotor1, OUTPUT);
    pinMode(leftMotor2, OUTPUT);
    pinMode(led, OUTPUT);
    pinMode(bled, OUTPUT);
    pinMode(leftled, OUTPUT);
    pinMode(rightled, OUTPUT);
  }

  void loop()
  {
    if (Serial.available() > 0) 
    {string = "";}
    
    while(Serial.available() > 0)
    {
      command = ((byte)Serial.read());
      
      if(command == ':')
      {
        break;
      }
      
      else
      {
        string += command;
      }
      
      delay(1);
    }
     
    
    if(string == "ON")
    {
        ledOn();
        ledon = true;
           
             
    }
    
    if(string =="OFF")
    {
        ledOff();
      ledon = false;
    }

    if(string == "BON")
    {
        bledOn();
        bledon = true;
    }


if(string == "BOFF")
    {
        bledOff();
        bledon = false;
    }

     if(string == "LI")
    {
        leftledOn();
        leftion = true;
    }

     if(string == "RI")
    {
        rightledOn();
        rightion = true;
    }

     if(string == "PI")
    {
        parkingOn();
        
        
    }
     if(string == "PIOS")
    {
        parkingOff();
    }


    

    
    if(string =="DIS")
    {
    analogWrite(rightMotor1,0);
    analogWrite(rightMotor2,0);
      ledOff();
      bledOff();
      ledon = false;
      bledon = false;
      motoron=false;
      rightion=false;
      leftion=false;
    }
    
     if(string == "FOR")
    {
    analogWrite(rightMotor1,220);
    analogWrite(rightMotor2,0);
    analogWrite(leftMotor1,220);
    analogWrite(leftMotor2,0);
    motoron=true;
    delay(10);
        
    }


     if(string == "REV")
    {
    analogWrite(rightMotor1,0);
    analogWrite(rightMotor2,220);
    analogWrite(leftMotor1,0);
    analogWrite(leftMotor2,220);
    delay(10);
        
    }


    if(string == "LEFT")
    {
    analogWrite(rightMotor1,220);
    analogWrite(rightMotor2,0);
    delay(10);
    }


    if(string == "RIGHT")
    {
    analogWrite(leftMotor1,220);
    analogWrite(leftMotor2,0);
    delay(10);
    }


    
     if(string == "STOP")
    {
        analogWrite(rightMotor1,0);
    analogWrite(rightMotor2,0);
    analogWrite(leftMotor1,0);
    analogWrite(leftMotor2,0);
    
    motoron=false;
    delay(10);
        
    }

 }
 
void ledOn()
   {
      digitalWrite(led, HIGH);
      delay(10);
    }
 
 void ledOff()
 {
      digitalWrite(led, LOW);
      delay(10);
 }

 void bledOn()
   {
      digitalWrite(bled, HIGH);
      delay(10);
    }

  void bledOff()
   {
      digitalWrite(bled, LOW);
      delay(10);
    }   

  void leftledOn()
   {
      digitalWrite(leftled, HIGH);
      delay(1000);
digitalWrite(leftled, LOW);
      delay(1000);
      
    }   


     void rightledOn()
   {
      digitalWrite(rightled, HIGH);
      delay(1000);
digitalWrite(rightled, LOW);
      delay(1000);
      
    }   

     void parkingOn()
   {
      digitalWrite(rightled, HIGH);
      digitalWrite(leftled, HIGH);
      delay(1000);
      digitalWrite(leftled, LOW);
      digitalWrite(rightled, LOW);
      delay(1000);
      
    }   


     void parkingOff()
   {
      
      digitalWrite(leftled, LOW);
      digitalWrite(rightled, LOW);
      
    }   
 

    
