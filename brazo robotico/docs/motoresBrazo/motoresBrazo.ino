
int pin = 13;
int secuencia = 0;

void setup(){
  Serial.begin(9600);
  pinMode(pin, OUTPUT);
}

void loop(){
    if (Serial.available() > 0) {
      //int n = Serial.parseInt();
      int n2 = Serial.read();
      secuencia = n2;
      //Serial.println(n);
      Serial.println(secuencia);
      Serial.println("Imprimio desde arduino.");
    }
    if(secuencia == 1) {
      digitalWrite(pin, HIGH);   // turn the LED on (HIGH is the voltage level)
    } else {
      digitalWrite(pin, LOW);    // turn the LED off by making the voltage LOW
    }
}


void led1() {
  digitalWrite(pin, HIGH);   // turn the LED on (HIGH is the voltage level)
}

void led2() {
  Serial.println("Led 2");
}

void led3() {
  Serial.println("Led 3");
}
