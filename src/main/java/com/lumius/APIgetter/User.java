package com.lumius.APIgetter;

/**
 * User -- A record containing information about users
 * @author Razvan
 */
public record User(
		int id,
		String name,
		String userName,
		String email,
		Address address,
		String phone,
		String website,
		Company company
		) {
	/**
	 * Address -- A record containing user address information, nested within User
	 */
	public record Address(
			String street,
			String suite,
			String city,
			String zipcode,
			Geo geo) {
		/**
		 * Geo -- A record containing user latitude and longitude, nested within address
		 */
		public record Geo(
				String lat,
				String lng) {
			
		}
	}
	/**
	 * Address -- A record containing a user's company information, nested within user
	 */
	public record Company (
			String name,
			String catchPhrase,
			String bs) {
		
	}
}
