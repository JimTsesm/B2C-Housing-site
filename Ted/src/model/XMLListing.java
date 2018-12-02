package model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="listing")
@XmlAccessorType (XmlAccessType.FIELD)
public class XMLListing {
	
	private int id;

	private int accommodates;

	private String amenities;

	private double bathrooms;

	private String bedType;

	private int bedrooms;

	private int beds;

	private int calculatedHostListingsCount;

	private String calendarLastScraped;

	private String calendarUpdated;

	private String cancellationPolicy;

	private String city;

	private String cleaningFee;

	private String country;

	private String countryCode;

	private String description;

	private String experiencesOffered;

	private String extraPeople;

	private String firstReview;

	private int guestsIncluded;

	private String hasAvailability;

	private String hostAbout;

	private String hostAcceptanceRate;

	private String hostHasProfilePic;

	private String hostIdentityVerified;

	private String hostIsSuperhost;

	private int hostListingsCount;

	private String hostLocation;

	private String hostName;

	private String hostNeighbourhood;

	private String hostPictureUrl;

	private String hostResponseRate;

	private String hostResponseTime;

	private String hostSince;

	private String hostThumbnailUrl;

	private int hostTotalListingsCount;

	private String hostUrl;

	private String hostVerifications;

	private String instantBookable;

	private String isLocationExact;

	private String jurisdictionNames;

	private String lastReview;

	private String lastScraped;

	private double latitude;

	private String license;

	private String listingUrl;

	private double longitude;

	private String market;

	private int maximumNights;

	private String mediumUrl;

	private int minimumNights;

	private String monthlyPrice;

	private String name;

	private String neighborhoodOverview;

	private String neighbourhood;

	private String neighbourhoodCleansed;

	private String neighbourhoodGroupCleansed;

	private String notes;

	private int numberOfReviews;

	private String pictureUrl;

	private String price;

	private String propertyType;

	private String requireGuestPhoneVerification;

	private String requireGuestProfilePicture;

	private String requiresLicense;

	private int reviewScoresAccuracy;

	private int reviewScoresCheckin;

	private int reviewScoresCleanliness;

	private int reviewScoresCommunication;

	private int reviewScoresLocation;

	private int reviewScoresRating;

	private int reviewScoresValue;

	private double reviewsPerMonth;

	private String roomType;

	private double scrapeId;

	private String securityDeposit;

	private String space;

	private String squareFeet;

	private String state;

	private String street;

	private String summary;

	private String thumbnailUrl;

	private String transit;

	private String weeklyPrice;

	private String xlPictureUrl;

	private String zipcode;
	
	private ListingReview reviews;
	
	public XMLListing() {
	}
	
	public XMLListing(int id,String Country,String Neighborhood,String City, double la, double lo,String Street, String Transit,int MaxPeople,int MinNights,String Type,String ExtraCostPerPerson,String Description,int BedsNum,double BathsNum,int BedRoomsNum) {
	this.setId(id);
	this.setLatitude(la);
	this.setLongitude(lo);
	this.setStreet(Street); 
	this.setTransit(Transit); 
	this.setGuestsIncluded(MaxPeople); 
	this.setMinimumNights(MinNights);
	this.setRoomType(Type);
	this.setExtraPeople(ExtraCostPerPerson); 
	this.setDescription(Description);
	this.setBedrooms(BedRoomsNum); 
	this.setBeds(BedsNum);
	this.setBathrooms(BathsNum); 
	this.setCity(City);
	this.setCountry(Country);
	this.setNeighbourhood(Neighborhood); 
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setListing(ListingReview reviews){
		this.reviews = reviews;
	}
	
	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public String getExtraPeople() {
		return this.extraPeople;
	}

	public void setExtraPeople(String extraPeople) {
		this.extraPeople = extraPeople;
	}
	
	public double getBathrooms() {
		return this.bathrooms;
	}

	public void setBathrooms(double bathrooms) {
		this.bathrooms = bathrooms;
	}
	
	public int getBedrooms() {
		return this.bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public int getBeds() {
		return this.beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}
	
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNeighbourhood() {
		return this.neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}
	
	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public int getMinimumNights() {
		return this.minimumNights;
	}

	public void setMinimumNights(int minimumNights) {
		this.minimumNights = minimumNights;
	}
	
	public int getGuestsIncluded() {
		return this.guestsIncluded;
	}

	public void setGuestsIncluded(int guestsIncluded) {
		this.guestsIncluded = guestsIncluded;
	}
	
	public String getTransit() {
		return this.transit;
	}

	public void setTransit(String transit) {
		this.transit = transit;
	}
	
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
