package com.lumius.APIgetter;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * APIgetterUtils -- A Facade on the jackson.databind class. Using it to serialize and deserialize users
 * @author Razvan Rotundu
 */
public class APIgetterUtils {
	
	private APIgetterUtils() {};
	
	public static final String USER_API = "https://jsonplaceholder.typicode.com/users";
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	/**
	 * Deserialize incoming reply from JSON to list User objects
	 * @param inStream -- The incoming text stream of JSON
	 * @return A list of User objects
	 */
	public static List<User> toList(InputStream inStream){
		try {
			return OBJECT_MAPPER.readValue(inStream, new TypeReference<>() {});
		}
		catch (IOException x) {
			throw new UncheckedIOException(x);
		}
	}
	
	/**
	 * Deserialize a single JSON representation of a User object
	 * @param inStream -- JSON input
	 * @return a User class instance 
	 */
	public static User toObject(InputStream inStream) {
		try {
			return OBJECT_MAPPER.readValue(inStream, User.class);
		}
		catch (IOException x){
			throw new UncheckedIOException(x);
		}
	}
	
	/**
	 * Serialize a single User object to JSON format
	 * @param user -- the user object to be serialized
	 * @return JSON representation of the provided User class
	 */
	public static String toJson (User user) {
		try {
			return OBJECT_MAPPER.writeValueAsString(user);
		}
		catch(JsonProcessingException x) {
			throw new UncheckedIOException(x);
		}
	}
}
