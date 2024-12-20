package main;

public class Main{
	// Global Variables
	public static int keys = 0;
	public static int notes = 0;
	public static int phones = 0;
	public static int hands = 0;
	public static int knifes = 0;
	public static boolean isNote1Taken = false;
	public static boolean isNote1Found = false;
	public static boolean isPhone1Found = false;
	public static boolean isPhone1Taken = false;
	public static boolean isHand1Found = false;
	public static boolean isHand1Taken = false;
	public static boolean isKey1Taken = false;
	public static boolean isKey1Found = false;
	public static boolean isKnife1Found = false;
	public static boolean isKnife1Taken = false;
	public static void main(String[] args) {
		
		pn("DANGER IN ROOM 227");
		pn("You enter a room with a couch, a bed and a bloody knife on the ground....");
		gameLoop();
	}
	
	public static void gameLoop() {
		while(true) {
			String input = Input.inputString("What do you want to do?:");
			input = input.toLowerCase();
			boolean b = processCommand(input);
			if(b)
				break;
		}
		pn("Thanks for playing!");
	}
	
	
	public static boolean processCommand(String input) {
		switch(input) {
		case "search room":
			if(!isKey1Taken) {
				pn("The room is searched and you find a key.");
				isKey1Found = true;
			}
			else
				pn("You find nothing else of interest.");
			break;
		case "take key":
			if(!isKey1Found)
					pn("Key.. what key?");
			else if(!isKey1Taken){
					pn("You take the key!");
					keys++;
					isKey1Taken = true;
				}else{
					pn("The key was already taken");
				}
			break;
			
		case "inventory":
			pn("You have " + keys +  " keys in inventory");
			pn("You have " + notes +  " notes in inventory");
			pn("You have " + phones +  " phones in inventory");
			pn("You have " + hands +  " hands in inventory");
			pn("You have " + knifes + " knifes in inventory");
			break;
		
		case "quit":
		case "exit":
			return true;
		case "search next room":
			if(isKey1Found & isKey1Taken) {
				pn("Danger IN ROOM 228");
				pn("To the next room you go, you see nothing but a sweater");
			}else {
				pn("You are not done with this room, look around!");
		
			}
			
			
			break;
		case "search sweater":
			if(!isNote1Taken) {
				pn("You find a note in the sweater");
				isNote1Found = true;
			}
			break;
		case "take note":
			if(!isNote1Found) {
				pn("What note.. has the room made you insane");
			}
			else if(!isNote1Taken && isKey1Taken && isNote1Found) {
				pn("You take the note, it reads there are two more rooms you are close to the truth");
				notes++;
				isNote1Taken = true;
			}else{
				pn("You already have the note");
			}
		
		break;
	case "another room": 
		if((isKey1Found & isKey1Taken) && (isNote1Taken & isNote1Found)) {
			pn("FRIEND RELATED DANGER IN ROOM 229");
			pn("You venture to another room, you see a phone and you know your buddy is in here with you..");
			isPhone1Found = true;
			}
		break;
	case "grab phone":
		if((isKey1Found & isKey1Taken) && (isNote1Taken & isNote1Found)){
			phones++;
			isPhone1Taken = true;
			pn("you take the phone and make a call to your buddy Jerry");
			pn("Dialing....");
			pn("Jerry: HELP ME AHHHHHHHHHHHHH");
			pn("I should go help Jerry but he must be in a different room");
		
			
		}else{
			pn("Huh?? Are the rooms driving you mad");
		}
		break;
	case "find jerry":
		if(isPhone1Found & isPhone1Taken){
			pn("EXTREME DANGER IN ROOM 230");
			pn("You stumble into a dark room.. you know your friend was in there at a certain point in time");
			pn("There is a eery feeling in the room.. something bad happened and you can feel it");
			pn("Try to locate.. your friend");
			
		}else{
			pn("Who is that...");
		}
		break;
	case "locate jerry" :
		if(isPhone1Found & isPhone1Taken){
			pn("You find a bit of Jerry.. HIS HAND.. still holding the phone he called you with... ");
			pn("Near him you see a knife.. you feel a presence in the room with you");
			pn("You might want some defense...");
			isKnife1Found = true;
			hands++;
		}
		
	break;
	case "grab knife":
		if(!isKnife1Found) {
			pn("What?!");
		}else {
			pn("You grab the knife");
			knifes++;
			isKnife1Taken = true;
			pn("This is your last shot out, fight now");
		}
		break;
	case "fight":
		if(isKnife1Found && isKnife1Taken) {
			pn("You fight the mysterious figure and win, it fades into the darkness");
			pn("WINNER!");
			return true;
		}else {
			pn("Nuh uh");
		}
	break;
	
		
		
		default:
			pn("Sorry I don't understand your command.");
			}
		
			return false;
		}
		
		
	
	
	public static <E> void p(E item){
		System.out.print(item);
	}
	
	public static <E> void pn(E item){
		System.out.println(item);
	}
}