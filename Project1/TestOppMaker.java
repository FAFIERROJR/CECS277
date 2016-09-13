import java.Util.Scanner

public class TestOppMaker{
	public static void main(String[] args){
		int hp;
		String name;
		String atkSpeech;
		String winSpeech;
		String lossSpeech;
		
		try{
			String filename = "OpponentList.txt";
			Scanner oppReader = new Scanner(new File(filename);
			int iterator = 0;
		
			while(oppReader.hasnext()){
				name = reader.getNext();
				hp = reader.getNextInt();
				atkSpeech = reader.getNextLine();
				lossSpeech = reader.getNextLine();
				
				