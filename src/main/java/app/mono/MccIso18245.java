package app.mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MccIso18245 {

  static {
    Map<String, String> temp = new HashMap<>();
    temp.put("0742", "Veterinary services");
    temp.put("0743", "Wine producers");
    temp.put("0744", "Champagne producers");
    temp.put("0763", "Agricultural co-operatives");
    temp.put("0780", "Landscaping and horticultural services");
    temp.put("1520", "General contractors — residential and commercial");
    temp.put("1711", "Heating, plumbing and air-conditioning contractors");
    temp.put("1731", "Electrical contractors");
    temp.put("1740", "Masonry, stonework, tile setting, plastering and insulation contractors");
    temp.put("1750", "Carpentry contractors");
    temp.put("1761", "Roofing, siding and sheet metal work contractors");
    temp.put("1771", "Concrete work contractors");
    temp.put("1799", "Special trade contractors — not elsewhere classified");
    temp.put("2741", "Miscellaneous publishing and printing services");
    temp.put("2791", "Typesetting, platemaking and related services");
    temp.put("2842", "Speciality cleaning, polishing and sanitation preparations");
    temp.put("4011", "Railroads");
    temp.put("4111", "Local and suburban commuter passenger transportation, including ferries");
    temp.put("4112", "Passenger railways");
    temp.put("4119", "Ambulance services");
    temp.put("4121", "Taxi-cabs and limousines");
    temp.put("4131", "Bus lines");
    temp.put(
            "4214",
            "Motor freight carriers and trucking — local and long distance, moving and storage companies and local delivery");
    temp.put("4215", "Courier services — air and ground and freight forwarders");
    temp.put(
            "4225",
            "Public warehousing and storage — farm products, refrigerated goods and household goods");
    temp.put("4411", "Steamships and cruise lines");
    temp.put("4457", "Boat rentals and leasing");
    temp.put("4468", "Marinas, marine service and supplies");
    temp.put("4511", "Airlines and air carriers");
    temp.put("4582", "Airports, flying fields and airport terminals");
    temp.put("4722", "Travel agencies and tour operators");
    temp.put("4784", "Tolls and bridge fees");
    temp.put("4789", "Transportation services — not elsewhere classified");
    temp.put("4812", "Telecommunication equipment and telephone sales");
    temp.put(
            "4814",
            "Telecommunication services, including local and long distance calls, credit card calls, calls through use of magnetic stripe reading telephones and faxes");
    temp.put("4815", "Monthly summary telephone charges");
    temp.put("4816", "Computer network/information services");
    temp.put("4821", "Telegraph services");
    temp.put("4829", "Wire transfers and money orders");
    temp.put("4899", "Cable and other pay television services");
    temp.put("4900", "Utilities — electric, gas, water and sanitary");
    temp.put("5013", "Motor vehicle supplies and new parts");
    temp.put("5021", "Office and commercial furniture");
    temp.put("5039", "Construction materials — not elsewhere classified");
    temp.put("5044", "Office, photographic, photocopy and microfilm equipment");
    temp.put("5045", "Computers, computer peripheral equipment — not elsewhere classified");
    temp.put("5046", "Commercial equipment — not elsewhere classified");
    temp.put("5047", "Dental/laboratory/medical/ophthalmic hospital equipment and supplies");
    temp.put("5051", "Metal service centres and offices");
    temp.put("5065", "Electrical parts and equipment");
    temp.put("5072", "Hardware equipment and supplies");
    temp.put("5074", "Plumbing and heating equipment and supplies");
    temp.put("5085", "Industrial supplies — not elsewhere classified");
    temp.put("5094", "Precious stones and metals, watches and jewellery");
    temp.put("5099", "Durable goods — not elsewhere classified");
    temp.put("5111", "Stationery, office supplies and printing and writing paper");
    temp.put("5122", "Drugs, drug proprietors");
    temp.put("5131", "Piece goods, notions and other dry goods");
    temp.put("5137", "Men’s, women’s and children’s uniforms and commercial clothing");
    temp.put("5139", "Commercial footwear");
    temp.put("5169", "Chemicals and allied products — not elsewhere classified");
    temp.put("5172", "Petroleum and petroleum products");
    temp.put("5192", "Books, periodicals and newspapers");
    temp.put("5193", "Florists’ supplies, nursery stock and flowers");
    temp.put("5198", "Paints, varnishes and supplies");
    temp.put("5199", "Non-durable goods — not elsewhere classified");
    temp.put("5200", "Home supply warehouse outlets");
    temp.put("5211", "Lumber and building materials outlets");
    temp.put("5231", "Glass, paint and wallpaper shops");
    temp.put("5251", "Hardware shops");
    temp.put("5261", "Lawn and garden supply outlets, including nurseries");
    temp.put("5271", "Mobile home dealers");
    temp.put("5300", "Wholesale clubs");
    temp.put("5309", "Duty-free shops");
    temp.put("5310", "Discount shops");
    temp.put("5311", "Department stores");
    temp.put("5331", "Variety stores");
    temp.put("5399", "Miscellaneous general merchandise");
    temp.put("5411", "Groceries and supermarkets");
    temp.put("5422", "Freezer and locker meat provisioners");
    temp.put("5441", "Candy, nut and confectionery shops");
    temp.put("5451", "Dairies");
    temp.put("5462", "Bakeries");
    temp.put("5499", "Miscellaneous food shops — convenience and speciality retail outlets");
    temp.put(
            "5511", "Car and truck dealers (new and used) sales, services, repairs, parts and leasing");
    temp.put(
            "5521", "Car and truck dealers (used only) sales, service, repairs, parts and leasing");
    temp.put("5531", "Auto and home supply outlets");
    temp.put("5532", "Automotive tyre outlets");
    temp.put("5533", "Automotive parts and accessories outlets");
    temp.put("5541", "Service stations (with or without ancillary services)");
    temp.put("5542", "Automated fuel dispensers");
    temp.put("5551", "Boat dealers");
    temp.put("5561", "Camper, recreational and utility trailer dealers");
    temp.put("5571", "Motorcycle shops and dealers");
    temp.put("5592", "Motor home dealers");
    temp.put("5598", "Snowmobile dealers");
    temp.put(
            "5599",
            "Miscellaneous automotive, aircraft and farm equipment dealers — not elsewhere classified");
    temp.put("5611", "Men’s and boys’ clothing and accessory shops");
    temp.put("5621", "Women’s ready-to-wear shops");
    temp.put("5631", "Women’s accessory and speciality shops");
    temp.put("5641", "Children’s and infants’ wear shops");
    temp.put("5651", "Family clothing shops");
    temp.put("5655", "Sports and riding apparel shops");
    temp.put("5661", "Shoe shops");
    temp.put("5681", "Furriers and fur shops");
    temp.put("5691", "Men’s and women’s clothing shops");
    temp.put("5697", "Tailors, seamstresses, mending and alterations");
    temp.put("5698", "Wig and toupee shops");
    temp.put("5699", "Miscellaneous apparel and accessory shops");
    temp.put(
            "5712",
            "Furniture, home furnishings and equipment shops and manufacturers, except appliances");
    temp.put("5713", "Floor covering services");
    temp.put("5714", "Drapery, window covering and upholstery shops");
    temp.put("5715", "Alcoholic beverage wholesalers");
    temp.put("5718", "Fireplaces, fireplace screens and accessories shops");
    temp.put("5719", "Miscellaneous home furnishing speciality shops");
    temp.put("5722", "Household appliance shops");
    temp.put("5732", "Electronics shops");
    temp.put("5733", "Music shops — musical instruments, pianos and sheet music");
    temp.put("5734", "Computer software outlets");
    temp.put("5735", "Record shops");
    temp.put("5811", "Caterers");
    temp.put("5812", "Eating places and restaurants");
    temp.put(
            "5813",
            "Drinking places (alcoholic beverages) — bars, taverns, night-clubs, cocktail lounges and discothèques");
    temp.put("5814", "Fast food restaurants");
    temp.put("5912", "Drug stores and pharmacies");
    temp.put("5921", "Package shops — beer, wine and liquor");
    temp.put("5931", "Used merchandise and second-hand shops");
    temp.put("5932", "Antique shops — sales, repairs and restoration services");
    temp.put("5933", "Pawn shops");
    temp.put("5935", "Wrecking and salvage yards");
    temp.put("5937", "Antique reproduction shops");
    temp.put("5940", "Bicycle shops — sales and service");
    temp.put("5941", "Sporting goods shops");
    temp.put("5942", "Bookshops");
    temp.put("5943", "Stationery, office and school supply shops");
    temp.put("5944", "Jewellery, watch, clock and silverware shops");
    temp.put("5945", "Hobby, toy and game shops");
    temp.put("5946", "Camera and photographic supply shops");
    temp.put("5947", "Gift, card, novelty and souvenir shops");
    temp.put("5948", "Luggage and leather goods shops");
    temp.put("5949", "Sewing, needlework, fabric and piece goods shops");
    temp.put("5950", "Glassware and crystal shops");
    temp.put("5960", "Direct marketing — insurance services");
    temp.put("5962", "Telemarketing — travel-related arrangement services");
    temp.put("5963", "Door-to-door sales");
    temp.put("5964", "Direct marketing — catalogue merchants");
    temp.put("5965", "Direct marketing — combination catalogue and retail merchants");
    temp.put("5966", "Direct marketing — outbound telemarketing merchants");
    temp.put("5967", "Direct marketing — inbound telemarketing merchants");
    temp.put("5968", "Direct marketing — continuity/subscription merchants");
    temp.put("5969", "Direct marketing/direct marketers — not elsewhere classified");
    temp.put("5970", "Artist supply and craft shops");
    temp.put("5971", "Art dealers and galleries");
    temp.put("5972", "Stamp and coin shops");
    temp.put("5973", "Religious goods and shops");
    temp.put("5975", "Hearing aids — sales, service and supplies");
    temp.put("5976", "Orthopaedic goods and prosthetic devices");
    temp.put("5978", "Typewriter outlets — sales, service and rentals");
    temp.put("5983", "Fuel dealers — fuel oil, wood, coal and liquefied petroleum");
    temp.put("5992", "Florists");
    temp.put("5993", "Cigar shops and stands");
    temp.put("5994", "Newsagents and news-stands");
    temp.put("5995", "Pet shops, pet food and supplies");
    temp.put("5996", "Swimming pools — sales, supplies and services");
    temp.put("5997", "Electric razor outlets — sales and service");
    temp.put("5998", "Tent and awning shops");
    temp.put("5999", "Miscellaneous and speciality retail outlets");
    temp.put("6010", "Financial institutions — manual cash disbursements");
    temp.put("6011", "Financial institutions — automated cash disbursements");
    temp.put("6012", "Financial institutions — merchandise and services");
    temp.put(
            "6051",
            "Non-financial institutions — foreign currency, money orders (not wire transfer), scrip and travellers’ checks");
    temp.put("6211", "Securities — brokers and dealers");
    temp.put("6300", "Insurance sales, underwriting and premiums");
    temp.put("7011", "Lodging — hotels, motels and resorts");
    temp.put("7012", "Timeshares");
    temp.put("7032", "Sporting and recreational camps");
    temp.put("7033", "Trailer parks and camp-sites");
    temp.put("7210", "Laundry, cleaning and garment services");
    temp.put("7211", "Laundry services — family and commercial");
    temp.put("7216", "Dry cleaners");
    temp.put("7217", "Carpet and upholstery cleaning");
    temp.put("7221", "Photographic studios");
    temp.put("7230", "Beauty and barber shops");
    temp.put("7251", "Shoe repair shops, shoe shine parlours and hat cleaning shops");
    temp.put("7261", "Funeral services and crematoriums");
    temp.put("7273", "Dating and escort services");
    temp.put("7276", "Tax preparation services");
    temp.put("7277", "Counselling services — debt, marriage and personal");
    temp.put("7278", "Buying and shopping services and clubs");
    temp.put("7296", "Clothing rentals — costumes, uniforms and formal wear");
    temp.put("7297", "Massage parlours");
    temp.put("7298", "Health and beauty spas");
    temp.put("7299", "Miscellaneous personal services — not elsewhere classified");
    temp.put("7311", "Advertising services");
    temp.put("7321", "Consumer credit reporting agencies");
    temp.put("7322", "Debt collection agencies");
    temp.put("7333", "Commercial photography, art and graphics");
    temp.put("7338", "Quick copy, reproduction and blueprinting services");
    temp.put("7339", "Stenographic and secretarial support services");
    temp.put("7342", "Exterminating and disinfecting services");
    temp.put("7349", "Cleaning, maintenance and janitorial services");
    temp.put("7361", "Employment agencies and temporary help services");
    temp.put(
            "7372", "Computer programming, data processing and integrated systems design services");
    temp.put("7375", "Information retrieval services");
    temp.put("7379", "Computer maintenance and repair services — not elsewhere classified");
    temp.put("7392", "Management, consulting and public relations services");
    temp.put(
            "7393",
            "Detective agencies, protective agencies and security services, including armoured cars and guard dogs");
    temp.put("7394", "Equipment, tool, furniture and appliance rentals and leasing");
    temp.put("7395", "Photofinishing laboratories and photo developing");
    temp.put("7399", "Business services — not elsewhere classified");
    temp.put("7512", "Automobile rentals");
    temp.put("7513", "Truck and utility trailer rentals");
    temp.put("7519", "Motor home and recreational vehicle rentals");
    temp.put("7523", "Parking lots and garages");
    temp.put("7531", "Automotive body repair shops");
    temp.put("7534", "Tyre retreading and repair shops");
    temp.put("7535", "Automotive paint shops");
    temp.put("7538", "Automotive service shops (non-dealer)");
    temp.put("7542", "Car washes");
    temp.put("7549", "Towing services");
    temp.put("7622", "Electronics repair shops");
    temp.put("7623", "Air conditioning and refrigeration repair shops");
    temp.put("7629", "Electrical and small appliance repair shops");
    temp.put("7631", "Watch, clock and jewellery repair shops");
    temp.put("7641", "Furniture reupholstery, repair and refinishing");
    temp.put("7692", "Welding services");
    temp.put("7699", "Miscellaneous repair shops and related services");
    temp.put("7829", "Motion picture and video tape production and distribution");
    temp.put("7832", "Motion picture theatres");
    temp.put("7841", "Video tape rentals");
    temp.put("7911", "Dance halls, studios and schools");
    temp.put("7922", "Theatrical producers (except motion pictures) and ticket agencies");
    temp.put("7929", "Bands, orchestras and miscellaneous entertainers — not elsewhere classified");
    temp.put("7932", "Billiard and pool establishments");
    temp.put("7933", "Bowling alleys");
    temp.put(
            "7941",
            "Commercial sports, professional sports clubs, athletic fields and sports promoters");
    temp.put("7991", "Tourist attractions and exhibits");
    temp.put("7992", "Public golf courses");
    temp.put("7993", "Video amusement game supplies");
    temp.put("7994", "Video game arcades and establishments");
    temp.put(
            "7995",
            "Betting, including lottery tickets, casino gaming chips, off-track betting and wagers at race tracks");
    temp.put("7996", "Amusement parks, circuses, carnivals and fortune tellers");
    temp.put(
            "7997",
            "Membership clubs (sports, recreation, athletic), country clubs and private golf courses");
    temp.put("7998", "Aquariums, seaquariums and dolphinariums");
    temp.put("7999", "Recreation services — not elsewhere classified");
    temp.put("8011", "Doctors and physicians — not elsewhere classified");
    temp.put("8021", "Dentists and orthodontists");
    temp.put("8031", "Osteopaths");
    temp.put("8041", "Chiropractors");
    temp.put("8042", "Optometrists and ophthalmologists");
    temp.put("8043", "Opticians, optical goods and eyeglasses");
    temp.put("8049", "Podiatrists and chiropodists");
    temp.put("8050", "Nursing and personal care facilities");
    temp.put("8062", "Hospitals");
    temp.put("8071", "Medical and dental laboratories");
    temp.put("8099", "Medical services and health practitioners — not elsewhere classified");
    temp.put("8111", "Legal services and attorneys");
    temp.put("8211", "Elementary and secondary schools");
    temp.put("8220", "Colleges, universities, professional schools and junior colleges");
    temp.put("8241", "Correspondence schools");
    temp.put("8244", "Business and secretarial schools");
    temp.put("8249", "Trade and vocational schools");
    temp.put("8299", "Schools and educational services — not elsewhere classified");
    temp.put("8351", "Child care services");
    temp.put("8398", "Charitable and social service organizations");
    temp.put("8641", "Civic, social and fraternal associations");
    temp.put("8651", "Political organizations");
    temp.put("8661", "Religious organizations");
    temp.put("8675", "Automobile associations");
    temp.put("8699", "Membership organization — not elsewhere classified");
    temp.put("8734", "Testing laboratories (non-medical)");
    temp.put("8911", "Architectural, engineering and surveying services");
    temp.put("8931", "Accounting, auditing and bookkeeping services");
    temp.put("8999", "Professional services — not elsewhere classified");
    temp.put("9211", "Court costs, including alimony and child support");
    temp.put("9222", "Fines");
    temp.put("9223", "Bail and bond payments");
    temp.put("9311", "Tax payments");
    temp.put("9399", "Government services — not elsewhere classified");
    temp.put("9402", "Postal services — government only");
    mapping = Collections.unmodifiableMap(temp);
  }

  private static final Map<String, String> mapping;

  private MccIso18245(){}

  public static String getDescByCode(String code){
    return mapping.get(code);
  }



}
