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
    ArrayList<JSONObject> json=new ArrayList<JSONObject>();
   // HashSet productId = new HashSet();
    ArrayList prodId= new ArrayList();
    ArrayList overall= new ArrayList();
    ArrayList reviewText= new ArrayList();
    JSONObject obj;
    // The name of the file to open.
    String fileName = "Data//Grocery_and_Gourmet_Food_5.json";
    
    public ArrayList getProdId() { 
    	return this.prodId;
    }
    public ArrayList getOverall() { 
    	return this.overall;
    }
    public ArrayList getReviewText() { 
    	return this.reviewText;
    }
	public void read() throws org.json.simple.parser.ParseException { 
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
        		this.prodId.add((String)this.obj.get("asin"));
        		this.overall.add((Double)this.obj.get("overall"));
        		this.reviewText.add((String)this.obj.get("reviewText"));
	        }
	        // close files.
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
	        // Auto-generated catch block
	        e.printStackTrace();
	    }
	}
}
