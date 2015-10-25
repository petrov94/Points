import java.io.File;
import java.io.FileNotFoundException;
		import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
		import org.json.simple.JSONArray;
		import org.json.simple.JSONObject;
		import org.json.simple.parser.JSONParser;
		import org.json.simple.parser.ParseException;
public class JSON_example {

	public static void main(String[] args) {
				JSONObject obj_new = new JSONObject();
				JSONArray list = new JSONArray();
				list.add("jQuery");
				list.add("underscore");
		
				obj_new.put("backbone", list);
				
				
				obj_new.put("jQuery", "queryJ");
				obj_new.put("underscore", "lodash");
				obj_new.put("queryJ","");
				obj_new.put("lodash","");
				
				JSONObject obj_new1 = new JSONObject();

				obj_new1.put("projectName", "Test0000");
				obj_new1.put("dependencies", "backbone");
				
				
				
				try {
					File f1 = new File("d:\\all_packages.json");
					File f2 = new File("d:\\dependencies.json");
					FileWriter file = new FileWriter(f1);
					file.write(obj_new.toJSONString());
					file.flush();
					file.close();
					FileWriter file1 = new FileWriter(f2);
					file1.write(obj_new1.toJSONString());
					file1.flush();
					file1.close();
		
				} catch (IOException e) {
					e.printStackTrace();
				}
		

		     
		
		
			JSONParser parser = new JSONParser();

			try {

				Object obj = parser.parse(new FileReader("d:\\dependencies.json"));
				Object obj1 = parser.parse(new FileReader("d:\\all_packages.json"));
				JSONObject jsonObject = (JSONObject) obj;
				JSONObject jsonObject1 = (JSONObject) obj1;
				
			   
				String name = (String) jsonObject.get("dependencies");
				System.out.println("Installing " + name + " .");
					
				JSONArray msg = (JSONArray) jsonObject1.get(name);
				Iterator<String> iterator = msg.iterator();
				ArrayList<String> arr= new ArrayList<String>();
				while (iterator.hasNext()) {
					arr.add(iterator.next());
				}
				String num1=arr.get(0);
				String num2=arr.get(1);
				System.out.println("In order to install" + name + ", we need " + num1 +" and  "+ num2 + " .");
				String name2 = (String) jsonObject1.get(num1);
				System.out.println("Installing"+num1 + " .");
				System.out.println("In order to install" + num1 +" we need " + name2 + " .");
				String name3 = (String) jsonObject1.get(name2);
				System.out.println("Installing " + name2 + " .");
				if (name3.isEmpty()) {System.out.println("Installing " + num2+ " .");}
				String name4 = (String) jsonObject1.get(num2);
				String name5 = (String) jsonObject1.get(name4);
				if (!name5.isEmpty()) {System.out.println(name5);}
				System.out.println("In order to install "+ num2 + ", we need " + name4+" .");
				if(name5.isEmpty()){System.out.println(name4+" is already installed. \n" + "All done.");}
				
								
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		     }

		

	}


