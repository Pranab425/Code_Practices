char *encrypt(char *msg)
{
    int i;
    char *message = msg;
    int lowerLimit = 32;
    int upperLimit = 126;
    int num = 10;
    for(i = 0 ; i < strlen(message); i++){
        char temp = message[i];
        int asciiValue = (int) temp;
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
        message[i] = (char) asciiValue;
        num--;
        if(num == 1){
            num = 10;
       }
    }

    return (char *)message;
}

char *decrypt(char *msg)
{
    int i;
    char *message = msg;
    int lowerLimit = 32;
    int upperLimit = 126;
    int num = 10;
    for(i = 0 ; i < strlen(message); i++){
        char temp = message[i];
        int asciiValue = (int) temp;
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
        message[i] = (char) asciiValue;
        num--;
        if(num == 1){
            num = 10;
       }
    }

    return (char *)message;
}
