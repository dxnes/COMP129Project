import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

	public class LeaderboardScores extends GraphicsPane{

		private ArrayList<Record> records;

		public LeaderboardScores(MainApplication app) {
			super();
			try{
   
	   String filename = "src/Scores.txt";
   
	   Scanner sc = new Scanner(new File(filename));

	   records = new ArrayList<Record>();
	   String line, name;
	   int value;

	   while(sc.hasNextLine()){
		   line = sc.nextLine();
		   name = line.split(" ")[0];
		   value = Integer.parseInt(line.split(" ")[1]);

		   records.add(new Record(name, value));
	   }

	   for(int i = 0; i < records.size() - 1; i++){
		   for(int j = i + 1; j < records.size(); j++){
			   Record record1 = records.get(i);
			   Record record2 = records.get(j);
			   if(record1.compareTo(record2) > 0){
				   swap(records, i, j);
			   }
		   }
	   }
  

	   System.out.println("Name\tScore");
	   for(int i = 0; i < records.size(); i++){
		   records.get(i).print();
	   }
   }
   catch(Exception e){
	   e.printStackTrace();
   }
}
  

   private static void swap(ArrayList<Record> records, int i, int j){
   Record record1 = records.get(i);
   Record record2 = records.get(j);
   records.remove(j);
   records.remove(i);
   records.add(i, record2);
   records.add(j, record1);
   }


   @Override
	public void showContents() {
	   // TODO Auto-generated method stub
	
   }


   @Override
   public void hideContents() {
	   // TODO Auto-generated method stub
	
   }

   public ArrayList <Record> getScores() {
	   return records;
	
   }

	}
