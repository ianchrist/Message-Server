This is a server that was created during my Objected Oriented Programming with Java Course (CS-230). The main function of this server is to communicated to other serves within the network through the client. In addition, you can also type things such as magicEightBall or magicPirateBall to send a predefined message accross to another user's server. Lastly, you may add other users IP addresses and connect them to a name, allowing you to contact that server by entering the name rather than the IP address, similar to contacts in a phone.

In order to run the server, you must follow these steps:

  1. Run the driver file
  2. Run the server file
  3. Run the client file
  
After this, you should be able to send any message to other users who followed the same steps and are on the same network.  To do this, you specify the IP address of who your message will send to, your IP address, and then the message.  
For example: 198.44.243.95 206.20.214.117 Hello

The files included and their functions are as follows: 

ActionMessage: Used to send and print messages.

ActionUpdateMessage: Used to update the IP address directory.

Advice: Allows us to use solicited and unsolicited advice files.

Client: Where messages are to be sent from.

Directory: Contains a list of users along with the IP addresses associated with them.

Driver: Creates objects that will display various pieces of advice.

FortuneCookie: Allows us to create an object with will give us random fortune cookie messages.

GetAdviceAction: Connects to ActionMessage.

MagicEightBall: Gives us a random message from a magic eight ball.

MagicPirateBall: Gives us a MagicEightBall message, but in pirate language.

ParentalAdvice: Gives us a random peace of parental advice.

Server: Allows us to send message from the client and allows the client to receive messages.

SolicitedAdvice: Allows the MagicEightBall and MagicPirateBall to function

UnsolisitedAdvice: Allows the ParentalAdvice and FortuneCookie to function

For a more detailed explanation, each of the files have documentations.  This documentations includes the function of the classes, methods, and variables in much more detail.
