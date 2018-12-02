load data local infile 'C:/Users/turbox/Desktop/listing_large.csv'
into table listings
fields 
    terminated by ','
    enclosed by '"'
lines terminated by '\n'
(id,listing_url,@scrape_id,last_scraped,name,summary,space,description,experiences_offered,neighborhood_overview,notes,transit,thumbnail_url,medium_url,picture_url,xl_picture_url,host_ids,host_url,host_name,host_since,host_location,host_about,host_response_time,host_response_rate,host_acceptance_rate,host_is_superhost,host_thumbnail_url,host_picture_url,host_neighbourhood,@host_listings_count,@host_total_listings_count,host_verifications,host_has_profile_pic,host_identity_verified,street,neighbourhood,neighbourhood_cleansed,neighbourhood_group_cleansed,city,state,zipcode,market,country_code,country,@latitude,@longitude,is_location_exact,property_type,room_type,@accommodates,@bathrooms,@bedrooms,@beds,bed_type,amenities,square_feet,price,weekly_price,monthly_price,security_deposit,cleaning_fee,@guests_included,extra_people,@minimum_nights,@maximum_nights,calendar_updated,has_availability,@availability_30,@availability_60,@availability_90,@availability_365,calendar_last_scraped,@number_of_reviews,first_review,last_review,@review_scores_rating,@review_scores_accuracy,@review_scores_cleanliness,@review_scores_checkin,@review_scores_communication,@review_scores_location,@review_scores_value,requires_license,license,jurisdiction_names,instant_bookable,cancellation_policy,require_guest_profile_picture,require_guest_phone_verification,@calculated_host_listings_count,reviews_per_month)
set 
review_scores_rating= nullif(@review_scores_rating,''),
bathrooms = nullif(@bathrooms,''),
review_scores_accuracy= nullif(@review_scores_accuracy,''),
review_scores_cleanliness= nullif(@review_scores_cleanliness,''),
review_scores_checkin= nullif(@review_scores_checkin,''),
review_scores_communication= nullif(@review_scores_communication,''),
review_scores_location= nullif(@review_scores_location,''),
review_scores_value= nullif(@review_scores_value,''),
scrape_id= nullif(@scrape_id,''),
host_listings_count= nullif(@host_listings_count,''),
host_total_listings_count= nullif(@host_total_listings_count,''),
latitude=nullif(@latitude,''),
longitude=nullif(@longitude,''),
accommodates= nullif(@accommodates,''),
bedrooms= nullif(@bedrooms,''),
beds= nullif(@beds,''),
guests_included= nullif(@guests_included,''),
minimum_nights= nullif(@minimum_nights,''),
maximum_nights= nullif(@maximum_nights,''),
availability_30= nullif(@availability_30,''),
availability_60= nullif(@availability_60,''),
availability_90= nullif(@availability_90,''),
availability_365= nullif(@availability_365,''),
number_of_reviews= nullif(@number_of_reviews,''),
calculated_host_listings_count= nullif(@calculated_host_listings_count,'');