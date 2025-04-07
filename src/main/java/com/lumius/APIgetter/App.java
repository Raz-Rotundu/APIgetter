package com.lumius.APIgetter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * Sends GET to API at https://jsonplaceholder.typicode.com/users, deserializes response to list of users
 * Uses HttpClient implementation (Java 11)
 * @author Razvan Rotundu
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.printf("%n Listing users:%n");
        
        // Http client and the request going through it (factory and builder patterns)
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(APIgetterUtils.USER_API)).GET().build();
        
        try {
        	// Send request and get the response back (specifying we want the body as inputstream)
        	HttpResponse<InputStream> response  = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        	
        	// Access statusCode field of response
        	int statusCode = response.statusCode();
        	System.out.printf("Status Code: %d%n", statusCode);
        	
        	// Access body field of response
        	System.out.println("Users returned in request:");
        	List<User> users = APIgetterUtils.toList(response.body());
        	users.stream().forEach(System.out::println);
        	
        	System.out.println("Headers:");
        	response.headers().map()
        		.forEach((header, value) -> System.out.println(header + " " + String.join(", ", value)));
        }
        catch(IOException | InterruptedException e){
        	throw new RuntimeException(e);
        }
    }
}
