package top5v2;

import com.beust.jcommander.Parameter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

/** Code taken from <p>
 *  <a href="http://www.yelp.com/developers/documentation">Yelp Documentation</a>
 **/

public class QueryBot {
  private static final String API_HOST = "api.yelp.com";
  private static  String DEFAULT_TERM = "";
  private static  String DEFAULT_LOCATION = "";
  private static final int SEARCH_LIMIT = 5;
  private static int RADIUS_FILTER = 500;
  private static final String SEARCH_PATH = "/v2/search";
  private static final String BUSINESS_PATH = "/v2/business";
  
  
  OAuthService service;
  Token accessToken;
  
  //changes the search parameters of the query 
  public void changeSearchConditions(String term, String location, int radius) {
      this.DEFAULT_TERM = term;
      this.DEFAULT_LOCATION = location;
      this.RADIUS_FILTER = radius;
      
  }
  
  //Creates the object that holds the token to be able to access the API.
  public QueryBot(String consumerKey, String consumerSecret, String token, String tokenSecret) {
    this.service =
        new ServiceBuilder().provider(Authorization.class).apiKey(consumerKey)
            .apiSecret(consumerSecret).build();
    this.accessToken = new Token(token, tokenSecret);
  }
  
  public String searchForBusinessesByLocation(String term, String location) {
    OAuthRequest request = createOAuthRequest(SEARCH_PATH);
    request.addQuerystringParameter("term", term);
    request.addQuerystringParameter("location", location);
    request.addQuerystringParameter("limit", String.valueOf(SEARCH_LIMIT));
    request.addQuerystringParameter("radius_Filter", String.valueOf(RADIUS_FILTER));
    return sendRequestAndGetResponse(request);
  }
  
  //Queries the API and returns a JSONArray of all results
  public static JSONArray queryAPI(QueryBot yelpApi, YelpAPICLI yelpApiCli) {
    String searchResponseJSON =
        yelpApi.searchForBusinessesByLocation(yelpApiCli.term, yelpApiCli.location);

    JSONParser parser = new JSONParser();
    JSONObject response = null;
    try {
      response = (JSONObject) parser.parse(searchResponseJSON);
    } catch (ParseException pe) {
      System.out.println("Error: could not parse JSON response:");
      System.out.println(searchResponseJSON);
      System.exit(1);
    }

    JSONArray businesses = (JSONArray) response.get("businesses"); 
    return businesses;
  }
  //sends request to query API and recieves response.
  private String sendRequestAndGetResponse(OAuthRequest request) {
    this.service.signRequest(this.accessToken, request);
    Response response = request.send();
    return response.getBody();
  }
  
  //Command-line interface for the sample Yelp API runner.
  public static class YelpAPICLI {
    @Parameter(names = {"-q", "--term"}, description = "Search Query Term")
    public String term = DEFAULT_TERM;

    @Parameter(names = {"-l", "--location"}, description = "Location to be Queried")
    public String location = DEFAULT_LOCATION;
  }
  
  //Creates and returns an {@link OAuthRequest} based on the API endpoint specified.
  private OAuthRequest createOAuthRequest(String path) {
    OAuthRequest request = new OAuthRequest(Verb.GET, "http://" + API_HOST + path);
    return request;
  } 
  
}
