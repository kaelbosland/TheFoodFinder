import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.HashSet;

//import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
public class JsonParser {

	public static void main(String [] args) throws org.json.simple.parser.ParseException {
	    ArrayList<JSONObject> json=new ArrayList<JSONObject>();
	   // HashSet productId = new HashSet();
	    ArrayList prodId= new ArrayList();
	    ArrayList overall= new ArrayList();
	    ArrayList reviewText= new ArrayList();

	    JSONObject obj;
	    // The name of the file to open.
	    String fileName = "Data//Grocery_and_Gourmet_Food_5.json";

	    // This will reference one line at a time
	    String line = null;

	    try {
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = new FileReader(fileName);

	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        while((line = bufferedReader.readLine()) != null) {
	            obj = (JSONObject) new JSONParser().parse(line);
	            json.add(obj);
	            //Adds each object in JSON 
	            //if (!prodId.contains((String)obj.get("asin")))
        		prodId.add((String)obj.get("asin"));
        		overall.add((Double)obj.get("overall"));
        		reviewText.add((String)obj.get("reviewText"));

//	            System.out.println("asin " + (String)obj.get("asin"));
	        }
	        System.out.println(prodId.size());
	        // Always close files.
	        bufferedReader.close();         
	    }
	    catch(FileNotFoundException ex) {
	        System.out.println("Unable to open file '" + fileName + "'");                
	    }
	    catch(IOException ex) {
	        System.out.println("Error reading file '" + fileName + "'");                  
	        // Or we could just do this: 
	        // ex.printStackTrace();
	    } catch (ParseException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
}
