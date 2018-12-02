package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the listings database table.
 * 
 */
@Entity
@Table(name="listings")
@NamedQuery(name="Listing.findAll", query="SELECT l FROM Listing l")
public class Listing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int accommodates;

	@Lob
	private String amenities;

	@Column(name="availability_30")
	private int availability30;

	@Column(name="availability_365")
	private int availability365;

	@Column(name="availability_60")
	private int availability60;

	@Column(name="availability_90")
	private int availability90;

	private float bathrooms;

	@Lob
	@Column(name="bed_type")
	private String bedType;

	private int bedrooms;

	private int beds;

	@Column(name="calculated_host_listings_count")
	private int calculatedHostListingsCount;

	@Lob
	@Column(name="calendar_last_scraped")
	private String calendarLastScraped;

	@Lob
	@Column(name="calendar_updated")
	private String calendarUpdated;

	@Lob
	@Column(name="cancellation_policy")
	private String cancellationPolicy;

	@Lob
	private String city;

	@Lob
	@Column(name="cleaning_fee")
	private String cleaningFee;

	@Lob
	private String country;

	@Lob
	@Column(name="country_code")
	private String countryCode;

	@Lob
	private String description;

	@Lob
	@Column(name="experiences_offered")
	private String experiencesOffered;

	@Lob
	@Column(name="extra_people")
	private String extraPeople;

	@Lob
	@Column(name="first_review")
	private String firstReview;

	@Column(name="guests_included")
	private int guestsIncluded;

	@Lob
	@Column(name="has_availability")
	private String hasAvailability;

	@Lob
	@Column(name="host_about")
	private String hostAbout;

	@Lob
	@Column(name="host_acceptance_rate")
	private String hostAcceptanceRate;

	@Lob
	@Column(name="host_has_profile_pic")
	private String hostHasProfilePic;

	@Lob
	@Column(name="host_identity_verified")
	private String hostIdentityVerified;

	@ManyToOne
	@JoinColumn(name="host_ids")
	private User hostIds;

	@Lob
	@Column(name="host_is_superhost")
	private String hostIsSuperhost;

	@Column(name="host_listings_count")
	private int hostListingsCount;

	@Lob
	@Column(name="host_location")
	private String hostLocation;

	@Lob
	@Column(name="host_name")
	private String hostName;

	@Lob
	@Column(name="host_neighbourhood")
	private String hostNeighbourhood;

	@Lob
	@Column(name="host_picture_url")
	private String hostPictureUrl;

	@Lob
	@Column(name="host_response_rate")
	private String hostResponseRate;

	@Lob
	@Column(name="host_response_time")
	private String hostResponseTime;

	@Lob
	@Column(name="host_since")
	private String hostSince;

	@Lob
	@Column(name="host_thumbnail_url")
	private String hostThumbnailUrl;

	@Column(name="host_total_listings_count")
	private int hostTotalListingsCount;

	@Lob
	@Column(name="host_url")
	private String hostUrl;

	@Lob
	@Column(name="host_verifications")
	private String hostVerifications;

	@Lob
	@Column(name="instant_bookable")
	private String instantBookable;

	@Lob
	@Column(name="is_location_exact")
	private String isLocationExact;

	@Lob
	@Column(name="jurisdiction_names")
	private String jurisdictionNames;

	@Lob
	@Column(name="last_review")
	private String lastReview;

	@Lob
	@Column(name="last_scraped")
	private String lastScraped;

	private double latitude;

	@Lob
	private String license;

	@Lob
	@Column(name="listing_url")
	private String listingUrl;

	private double longitude;

	@Lob
	private String market;

	@Column(name="maximum_nights")
	private int maximumNights;

	@Lob
	@Column(name="medium_url")
	private String mediumUrl;

	@Column(name="minimum_nights")
	private int minimumNights;

	@Lob
	@Column(name="monthly_price")
	private String monthlyPrice;

	@Lob
	private String name;

	@Lob
	@Column(name="neighborhood_overview")
	private String neighborhoodOverview;

	@Lob
	private String neighbourhood;

	@Lob
	@Column(name="neighbourhood_cleansed")
	private String neighbourhoodCleansed;

	@Lob
	@Column(name="neighbourhood_group_cleansed")
	private String neighbourhoodGroupCleansed;

	@Lob
	private String notes;

	@Column(name="number_of_reviews")
	private int numberOfReviews;

	@Lob
	@Column(name="picture_url")
	private String pictureUrl;

	@Lob
	private String price;

	@Lob
	@Column(name="property_type")
	private String propertyType;

	@Lob
	@Column(name="require_guest_phone_verification")
	private String requireGuestPhoneVerification;

	@Lob
	@Column(name="require_guest_profile_picture")
	private String requireGuestProfilePicture;

	@Lob
	@Column(name="requires_license")
	private String requiresLicense;

	@Column(name="review_scores_accuracy")
	private int reviewScoresAccuracy;

	@Column(name="review_scores_checkin")
	private int reviewScoresCheckin;

	@Column(name="review_scores_cleanliness")
	private int reviewScoresCleanliness;

	@Column(name="review_scores_communication")
	private int reviewScoresCommunication;

	@Column(name="review_scores_location")
	private int reviewScoresLocation;

	@Column(name="review_scores_rating")
	private int reviewScoresRating;

	@Column(name="review_scores_value")
	private int reviewScoresValue;

	@Column(name="reviews_per_month")
	private double reviewsPerMonth;

	@Lob
	@Column(name="room_type")
	private String roomType;

	@Column(name="scrape_id")
	private double scrapeId;

	@Lob
	@Column(name="security_deposit")
	private String securityDeposit;

	@Lob
	private String space;

	@Lob
	@Column(name="square_feet")
	private String squareFeet;

	@Lob
	private String state;

	@Lob
	private String street;

	@Lob
	private String summary;

	@Lob
	@Column(name="thumbnail_url")
	private String thumbnailUrl;

	@Lob
	private String transit;

	@Lob
	@Column(name="weekly_price")
	private String weeklyPrice;

	@Lob
	@Column(name="xl_picture_url")
	private String xlPictureUrl;

	@Lob
	private String zipcode;
	
	private String photo1;
	
	private String photo2;
	
	private String photo3;
	
	private String photo4;

	//bi-directional many-to-one association to Calendar
	@OneToMany(mappedBy="listing")
	private Set<Calendar> calendars;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="listing")
	private Set<Reservation> reservations;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="listing")
	private Set<Review> reviews;

	public Listing() {
	}
	
	public Listing(User hostid,String price,String Country,String Neighborhood,String City, float la, float lo,String Street, String Transit,int MaxPeople,int MinNights,String Type,String ExtraCostPerPerson,String amenities,String Description,int BedsNum,float BathsNum,int BedRoomsNum) {
	this.hostIds = hostid;
	this.latitude = la;
	this.longitude = lo;
	this.street = Street;
	this.transit = Transit;
	this.guestsIncluded = MaxPeople;
	this.minimumNights = MinNights;
	this.roomType = Type;
	this.extraPeople = ExtraCostPerPerson;
	this.description = Description;
	this.bedrooms = BedRoomsNum;
	this.beds = BedsNum;
	this.bathrooms = BathsNum;
	this.city = City;
	this.country = Country;
	this.neighbourhood = Neighborhood;
	this.price = price;
	this.amenities = amenities;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccommodates() {
		return this.accommodates;
	}

	public void setAccommodates(int accommodates) {
		this.accommodates = accommodates;
	}

	public String getAmenities() {
		return this.amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public int getAvailability30() {
		return this.availability30;
	}

	public void setAvailability30(int availability30) {
		this.availability30 = availability30;
	}

	public int getAvailability365() {
		return this.availability365;
	}

	public void setAvailability365(int availability365) {
		this.availability365 = availability365;
	}

	public int getAvailability60() {
		return this.availability60;
	}

	public void setAvailability60(int availability60) {
		this.availability60 = availability60;
	}

	public int getAvailability90() {
		return this.availability90;
	}

	public void setAvailability90(int availability90) {
		this.availability90 = availability90;
	}

	public float getBathrooms() {
		return this.bathrooms;
	}

	public void setBathrooms(float bathrooms) {
		this.bathrooms = bathrooms;
	}

	public String getBedType() {
		return this.bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
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

	public int getCalculatedHostListingsCount() {
		return this.calculatedHostListingsCount;
	}

	public void setCalculatedHostListingsCount(int calculatedHostListingsCount) {
		this.calculatedHostListingsCount = calculatedHostListingsCount;
	}

	public String getCalendarLastScraped() {
		return this.calendarLastScraped;
	}

	public void setCalendarLastScraped(String calendarLastScraped) {
		this.calendarLastScraped = calendarLastScraped;
	}

	public String getCalendarUpdated() {
		return this.calendarUpdated;
	}

	public void setCalendarUpdated(String calendarUpdated) {
		this.calendarUpdated = calendarUpdated;
	}

	public String getCancellationPolicy() {
		return this.cancellationPolicy;
	}

	public void setCancellationPolicy(String cancellationPolicy) {
		this.cancellationPolicy = cancellationPolicy;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCleaningFee() {
		return this.cleaningFee;
	}

	public void setCleaningFee(String cleaningFee) {
		this.cleaningFee = cleaningFee;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExperiencesOffered() {
		return this.experiencesOffered;
	}

	public void setExperiencesOffered(String experiencesOffered) {
		this.experiencesOffered = experiencesOffered;
	}

	public String getExtraPeople() {
		return this.extraPeople;
	}

	public void setExtraPeople(String extraPeople) {
		this.extraPeople = extraPeople;
	}

	public String getFirstReview() {
		return this.firstReview;
	}

	public void setFirstReview(String firstReview) {
		this.firstReview = firstReview;
	}

	public int getGuestsIncluded() {
		return this.guestsIncluded;
	}

	public void setGuestsIncluded(int guestsIncluded) {
		this.guestsIncluded = guestsIncluded;
	}

	public String getHasAvailability() {
		return this.hasAvailability;
	}

	public void setHasAvailability(String hasAvailability) {
		this.hasAvailability = hasAvailability;
	}

	public String getHostAbout() {
		return this.hostAbout;
	}

	public void setHostAbout(String hostAbout) {
		this.hostAbout = hostAbout;
	}

	public String getHostAcceptanceRate() {
		return this.hostAcceptanceRate;
	}

	public void setHostAcceptanceRate(String hostAcceptanceRate) {
		this.hostAcceptanceRate = hostAcceptanceRate;
	}

	public String getHostHasProfilePic() {
		return this.hostHasProfilePic;
	}

	public void setHostHasProfilePic(String hostHasProfilePic) {
		this.hostHasProfilePic = hostHasProfilePic;
	}

	public String getHostIdentityVerified() {
		return this.hostIdentityVerified;
	}

	public void setHostIdentityVerified(String hostIdentityVerified) {
		this.hostIdentityVerified = hostIdentityVerified;
	}

	public User getHostIds() {
		return this.hostIds;
	}

	public void setHostIds(User hostIds) {
		this.hostIds = hostIds;
	}

	public String getHostIsSuperhost() {
		return this.hostIsSuperhost;
	}

	public void setHostIsSuperhost(String hostIsSuperhost) {
		this.hostIsSuperhost = hostIsSuperhost;
	}

	public int getHostListingsCount() {
		return this.hostListingsCount;
	}

	public void setHostListingsCount(int hostListingsCount) {
		this.hostListingsCount = hostListingsCount;
	}

	public String getHostLocation() {
		return this.hostLocation;
	}

	public void setHostLocation(String hostLocation) {
		this.hostLocation = hostLocation;
	}

	public String getHostName() {
		return this.hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostNeighbourhood() {
		return this.hostNeighbourhood;
	}

	public void setHostNeighbourhood(String hostNeighbourhood) {
		this.hostNeighbourhood = hostNeighbourhood;
	}

	public String getHostPictureUrl() {
		return this.hostPictureUrl;
	}

	public void setHostPictureUrl(String hostPictureUrl) {
		this.hostPictureUrl = hostPictureUrl;
	}

	public String getHostResponseRate() {
		return this.hostResponseRate;
	}

	public void setHostResponseRate(String hostResponseRate) {
		this.hostResponseRate = hostResponseRate;
	}

	public String getHostResponseTime() {
		return this.hostResponseTime;
	}

	public void setHostResponseTime(String hostResponseTime) {
		this.hostResponseTime = hostResponseTime;
	}

	public String getHostSince() {
		return this.hostSince;
	}

	public void setHostSince(String hostSince) {
		this.hostSince = hostSince;
	}

	public String getHostThumbnailUrl() {
		return this.hostThumbnailUrl;
	}

	public void setHostThumbnailUrl(String hostThumbnailUrl) {
		this.hostThumbnailUrl = hostThumbnailUrl;
	}

	public int getHostTotalListingsCount() {
		return this.hostTotalListingsCount;
	}

	public void setHostTotalListingsCount(int hostTotalListingsCount) {
		this.hostTotalListingsCount = hostTotalListingsCount;
	}

	public String getHostUrl() {
		return this.hostUrl;
	}

	public void setHostUrl(String hostUrl) {
		this.hostUrl = hostUrl;
	}

	public String getHostVerifications() {
		return this.hostVerifications;
	}

	public void setHostVerifications(String hostVerifications) {
		this.hostVerifications = hostVerifications;
	}

	public String getInstantBookable() {
		return this.instantBookable;
	}

	public void setInstantBookable(String instantBookable) {
		this.instantBookable = instantBookable;
	}

	public String getIsLocationExact() {
		return this.isLocationExact;
	}

	public void setIsLocationExact(String isLocationExact) {
		this.isLocationExact = isLocationExact;
	}

	public String getJurisdictionNames() {
		return this.jurisdictionNames;
	}

	public void setJurisdictionNames(String jurisdictionNames) {
		this.jurisdictionNames = jurisdictionNames;
	}

	public String getLastReview() {
		return this.lastReview;
	}

	public void setLastReview(String lastReview) {
		this.lastReview = lastReview;
	}

	public String getLastScraped() {
		return this.lastScraped;
	}

	public void setLastScraped(String lastScraped) {
		this.lastScraped = lastScraped;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getLicense() {
		return this.license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getListingUrl() {
		return this.listingUrl;
	}

	public void setListingUrl(String listingUrl) {
		this.listingUrl = listingUrl;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getMarket() {
		return this.market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public int getMaximumNights() {
		return this.maximumNights;
	}

	public void setMaximumNights(int maximumNights) {
		this.maximumNights = maximumNights;
	}

	public String getMediumUrl() {
		return this.mediumUrl;
	}

	public void setMediumUrl(String mediumUrl) {
		this.mediumUrl = mediumUrl;
	}

	public int getMinimumNights() {
		return this.minimumNights;
	}

	public void setMinimumNights(int minimumNights) {
		this.minimumNights = minimumNights;
	}

	public String getMonthlyPrice() {
		return this.monthlyPrice;
	}

	public void setMonthlyPrice(String monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNeighborhoodOverview() {
		return this.neighborhoodOverview;
	}

	public void setNeighborhoodOverview(String neighborhoodOverview) {
		this.neighborhoodOverview = neighborhoodOverview;
	}

	public String getNeighbourhood() {
		return this.neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getNeighbourhoodCleansed() {
		return this.neighbourhoodCleansed;
	}

	public void setNeighbourhoodCleansed(String neighbourhoodCleansed) {
		this.neighbourhoodCleansed = neighbourhoodCleansed;
	}

	public String getNeighbourhoodGroupCleansed() {
		return this.neighbourhoodGroupCleansed;
	}

	public void setNeighbourhoodGroupCleansed(String neighbourhoodGroupCleansed) {
		this.neighbourhoodGroupCleansed = neighbourhoodGroupCleansed;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getNumberOfReviews() {
		return this.numberOfReviews;
	}

	public void setNumberOfReviews(int numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}

	public String getPictureUrl() {
		return this.pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPropertyType() {
		return this.propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getRequireGuestPhoneVerification() {
		return this.requireGuestPhoneVerification;
	}

	public void setRequireGuestPhoneVerification(String requireGuestPhoneVerification) {
		this.requireGuestPhoneVerification = requireGuestPhoneVerification;
	}

	public String getRequireGuestProfilePicture() {
		return this.requireGuestProfilePicture;
	}

	public void setRequireGuestProfilePicture(String requireGuestProfilePicture) {
		this.requireGuestProfilePicture = requireGuestProfilePicture;
	}

	public String getRequiresLicense() {
		return this.requiresLicense;
	}

	public void setRequiresLicense(String requiresLicense) {
		this.requiresLicense = requiresLicense;
	}

	public int getReviewScoresAccuracy() {
		return this.reviewScoresAccuracy;
	}

	public void setReviewScoresAccuracy(int reviewScoresAccuracy) {
		this.reviewScoresAccuracy = reviewScoresAccuracy;
	}

	public int getReviewScoresCheckin() {
		return this.reviewScoresCheckin;
	}

	public void setReviewScoresCheckin(int reviewScoresCheckin) {
		this.reviewScoresCheckin = reviewScoresCheckin;
	}

	public int getReviewScoresCleanliness() {
		return this.reviewScoresCleanliness;
	}

	public void setReviewScoresCleanliness(int reviewScoresCleanliness) {
		this.reviewScoresCleanliness = reviewScoresCleanliness;
	}

	public int getReviewScoresCommunication() {
		return this.reviewScoresCommunication;
	}

	public void setReviewScoresCommunication(int reviewScoresCommunication) {
		this.reviewScoresCommunication = reviewScoresCommunication;
	}

	public int getReviewScoresLocation() {
		return this.reviewScoresLocation;
	}

	public void setReviewScoresLocation(int reviewScoresLocation) {
		this.reviewScoresLocation = reviewScoresLocation;
	}

	public int getReviewScoresRating() {
		return this.reviewScoresRating;
	}

	public void setReviewScoresRating(int reviewScoresRating) {
		this.reviewScoresRating = reviewScoresRating;
	}

	public int getReviewScoresValue() {
		return this.reviewScoresValue;
	}

	public void setReviewScoresValue(int reviewScoresValue) {
		this.reviewScoresValue = reviewScoresValue;
	}

	public double getReviewsPerMonth() {
		return this.reviewsPerMonth;
	}

	public void setReviewsPerMonth(double reviewsPerMonth) {
		this.reviewsPerMonth = reviewsPerMonth;
	}

	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getScrapeId() {
		return this.scrapeId;
	}

	public void setScrapeId(double scrapeId) {
		this.scrapeId = scrapeId;
	}

	public String getSecurityDeposit() {
		return this.securityDeposit;
	}

	public void setSecurityDeposit(String securityDeposit) {
		this.securityDeposit = securityDeposit;
	}

	public String getSpace() {
		return this.space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	public String getSquareFeet() {
		return this.squareFeet;
	}

	public void setSquareFeet(String squareFeet) {
		this.squareFeet = squareFeet;
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

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getThumbnailUrl() {
		return this.thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getTransit() {
		return this.transit;
	}

	public void setTransit(String transit) {
		this.transit = transit;
	}

	public String getWeeklyPrice() {
		return this.weeklyPrice;
	}

	public void setWeeklyPrice(String weeklyPrice) {
		this.weeklyPrice = weeklyPrice;
	}

	public String getXlPictureUrl() {
		return this.xlPictureUrl;
	}

	public void setXlPictureUrl(String xlPictureUrl) {
		this.xlPictureUrl = xlPictureUrl;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Set<Calendar> getCalendars() {
		return this.calendars;
	}

	public void setCalendars(Set<Calendar> calendars) {
		this.calendars = calendars;
	}

	public Calendar addCalendar(Calendar calendar) {
		getCalendars().add(calendar);
		calendar.setListing(this);

		return calendar;
	}

	public Calendar removeCalendar(Calendar calendar) {
		getCalendars().remove(calendar);
		calendar.setListing(null);

		return calendar;
	}

	public Set<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setListing(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setListing(null);

		return reservation;
	}

	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setListing(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setListing(null);

		return review;
	}
	
	public String getphoto1() {
		return this.photo1;
	}
	
	public void setphoto1(String photo1) {
		this.photo1 = photo1;
	}
	
	public String getphoto2() {
		return this.photo2;
	}

	public void setphoto2(String photo2) {
		this.photo2 = photo2;
	}
	
	public String getphoto3() {
		return this.photo3;
	}

	public void setphoto3(String photo3) {
		this.photo3 = photo3;
	}
	
	public String getphoto4() {
		return this.photo4;
	}

	public void setphoto4(String photo4) {
		this.photo4 = photo4;
	}

}