public static String encrypt(String message){
 int lowerLimit = 32;
 int upperLimit = 126;
 int num = 10;
 for(int i = 0 ; i < message.length(); i++){
     char temp = message.charAt(i);
     int asciiValue = (int) temp;
     //System.out.print(temp + " " + asciiValue);
     if(num%2==0){
         asciiValue = asciiValue + num;
         if(asciiValue > upperLimit){
             asciiValue = lowerLimit + (asciiValue - upperLimit);
         }
     }
     else{
         asciiValue = asciiValue - num;
         if(asciiValue <= lowerLimit){
             asciiValue = upperLimit - (lowerLimit - asciiValue);
         }
     }
     //System.out.println(" " + asciiValue + " " + (char)asciiValue);
     message = message.substring(0, i) +  (char) asciiValue + message.substring(i+1);
     num--;
     if(num == 1){
         num = 10;
     }
 }
 return message;
}

public static String decrypt(String message){
 int lowerLimit = 32;
 int upperLimit = 126;
 int num = 10;
 for(int i = 0 ; i < message.length(); i++){
     char temp = message.charAt(i);
     int asciiValue = (int) temp;
     //System.out.print(temp + " " + asciiValue);
     if(num%2==0){
         asciiValue = asciiValue - num;
         if(asciiValue < lowerLimit){
             asciiValue = upperLimit - (lowerLimit - asciiValue);
         }
     }
     else{
         asciiValue = asciiValue + num;
         if(asciiValue >= upperLimit){
             asciiValue = lowerLimit + (asciiValue - upperLimit);
         }
     }
     //System.out.println(" " + asciiValue + " " + (char)asciiValue);
     message = message.substring(0, i) +  (char) asciiValue + message.substring(i+1);
     num--;
     if(num == 1){
         num = 10;
     }
 }
 return message;
}
