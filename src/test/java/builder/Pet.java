package builder;

public class Pet {

	public String ConstructBody(int categoryID, String categroryName,
			String petName) {
		String body = "{ \"category\": {\n" + 
		 		"   \"id\": "+ categoryID +",\n" + 
		 		"      \"name\": \""+ categroryName +"\"\n" + 
		 		"  },\n" + 
		 		"  \"name\": \""+ petName +"\",\n" + 
		 		"  \"status\": \"available\"}";
		return body;
		
	}
}
