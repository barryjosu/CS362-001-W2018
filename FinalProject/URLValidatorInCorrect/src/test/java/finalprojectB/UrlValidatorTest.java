package finalprojectB;

import junit.framework.TestCase;

public class UrlValidatorTest extends TestCase {

	private boolean printStatus = false;
	private boolean printIndex = false;// print index that indicates current
										// scheme,host,port,path, query test
										// were using.

	public UrlValidatorTest(String testName) {
		super(testName);
	}

	// ------------------ Manual Testing ---------------------------------------

	public void testManualTestJB() {
		System.out.println("Running Manual Tests...");

		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		
		/* Test valid scheme, valid authority, valid port EXPECT TRUE */
		System.out.println(urlVal.isValid("http://www.amazon.com/"));
		
		/* Test valid scheme, authority, port, and valid path EXPECT TRUE */
		//System.out.println(urlVal.isValid("https://www.amazon.com/index_2_4.html"));
		
		/*
		 * Test valid scheme, authority, port, path, and valid query EXPECT TRUE
		 */
		System.out.println(urlVal.isValid("http://www.amazon.com/t123?action=view"));

		/*
		 * Test valid scheme, INVALID authority, port, and valid path EXPECT
		 * FALSE
		 */
		//System.out.println(urlVal.isValid("https://www.a-.com/index_2_4.html"));
		
		/* Test INVALID scheme, valid authority, valid port EXPECT TRUE */
		//System.out.println(urlVal.isValid("hst://www.amazon.com/"));
		
		/* test file handler, EXPECT TRUE */
		//System.out.println(urlVal.isValid("file:///C:/Users/JB/Desktop/a.pdf"));
	}

	// ------------------ Partition Testing
	// ---------------------------------------

	public void testYourFirstPartitionJB() {
		System.out.println("Running First Partition Testing...");

		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		
		// invalid authority
		System.out.println(urlVal.isValid("http://gotcha.zmb"));
		System.out.println(urlVal.isValid("http://.xyz"));
		
		// valid authority
		System.out.println(urlVal.isValid("http://256.256.256.256"));
		System.out.println(urlVal.isValid("http://gotcha.zmb.xyz"));
		System.out.println(urlVal.isValid("http://0.0.0.0"));
		System.out.println(urlVal.isValid("http://www.google.com"));
		System.out.println(urlVal.isValid("http://255.255.255.255"));
	}

	public void testYourSecondPartitionJB() {
		System.out.println("Running Second Partition Testing...");

		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		
		// testing invalid ports
		if (!urlVal.isValid("http://www.google.com:-8") && !urlVal.isValid("http://www.google.com:-82")
				&& !urlVal.isValid("http://www.google.com:45d") && !urlVal.isValid("http://www.google.com:x7")) {
			System.out.println("invalid port failed as expected");
		} else {
			System.out.println("at least one invalid port passed, possible bug");
		}

		System.out.println(urlVal.isValid("http://www.google.com:88"));
		System.out.println(urlVal.isValid("http://www.google.com:12345"));
		System.out.println(urlVal.isValid("http://www.google.com:666"));
		System.out.println(urlVal.isValid("http://www.google.com:0"));

	}

	public void testYourThirdPartitionJB() {
		System.out.println("Running Third Partition Testing...");

		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		// testing invalid schemes
		System.out.println(urlVal.isValid("7ht://www.google.com"));
		System.out.println(urlVal.isValid("http:www.google.com"));
		System.out.println(urlVal.isValid("http:/www.google.com"));
		System.out.println(urlVal.isValid("htttttp/www.google.com"));
		System.out.println(urlVal.isValid(":://www.google.com"));
		
		// testing valid schemes
		/*if (urlVal.isValid("http://www.google.com") && urlVal.isValid("ftp://www.google.com")
				&& urlVal.isValid("https://www.google.com")) {
			System.out.println("valid input schemes passed as expected");
		} else {
			System.out.println("valid input schemes failed indication of a possible bug");
		}*/
	}

	public void testYourFourthPartitionJB() {
		System.out.println("Running Fourth Partition Testing...");
		
	    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		   
	   //testing invalid Path
	   if (!urlVal.isValid("http://www.google.com/....") &&
		   !urlVal.isValid("http://www.google.com/..") &&
		   !urlVal.isValid("http://www.google.com//..//"))
	   {
		   System.out.println("invalid path failed as expected");
	   }
	   else
	   {
		   System.out.println("at least one invalid path passed, possible bug");
	   }
	 
		 if (urlVal.isValid("http://www.google.com/index") &&
		   urlVal.isValid("http://www.google.com/index/foo") &&
		   urlVal.isValid("http://www.google.com/") &&
		   urlVal.isValid("http://www.google.com/.") ) 
	   {
		   System.out.println("valid path passed as expected");
	   }
	   else
	   {
		   System.out.println("valid path failed possible bug");
	   }

	}

	/**
	 * Create set of tests by taking the testUrlXXX arrays and running through
	 * all possible permutations of their combinations.
	 *
	 * @param testObjects
	 *            Used to create a url.
	 */
	// ----------------- Programming Based Testing -------------
	// Schema I am testing: scheme+authority+port+path+query
	// <scheme>://<authority><path>?<query>

	// Loop though different scheme and authorities
	public void testProgrammicSchemeAuthorityJB() {

		System.out.println("Running programming based testing for scheme+authority...");
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		String url;
		Boolean urlValid;
		for (ResultPair i : testUrlScheme) {

			for (ResultPair j : testUrlAuthority) {
				url = i.item + j.item;
				urlValid = urlVal.isValid(url);
				if ((i.valid && j.valid && urlValid) || ((!i.valid || !j.valid) && !urlValid)) {
					// Tests pass if both components are valid and the url is
					// valid
					// OR
					// if either of the components are invalid and the url is
					// invalid
					System.out.println("Passed: URL -> <" + url + ">... Expected: " + (i.valid && j.valid)
							+ ". Actual: " + urlValid);
				} else {
					System.out.println("Failed: URL -> <" + url + ">. Expected: " + (i.valid && j.valid) + ". Actual: "
							+ urlValid);
				}
			}
		}
	}

	// Loop though different different ports with the rest of the url being
	// valid
	public void testProgrammicPortJB() {

		System.out.println("Running programming based testing for port...");
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		String baseUrl = "http://www.google.com";
		String url;
		Boolean urlValid;

		for (ResultPair j : testUrlPort) {
			url = baseUrl + j.item;
			urlValid = urlVal.isValid(url);
			if ((j.valid && urlValid) || (!j.valid && !urlValid)) {
				// Tests pass if port is valid and the url is valid
				// OR
				// if port is invalid and the url is invalid
				System.out.println("Passed: URL -> <" + url + ">... Expected: " + j.valid + ". Actual: " + urlValid);
			} else {
				System.out.println("Failed: URL -> <" + url + ">... Expected: " + j.valid + ". Actual: " + urlValid);
			}
		}
	}

	// Loop though different paths with the rest of the url being valid
	public void testProgrammicPathJB() {

		System.out.println("Running programming based testing for path...");
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		String baseUrl = "http://www.google.com:80";
		String url;
		Boolean urlValid;

		for (ResultPair j : testUrlPath) {
			url = baseUrl + j.item;
			urlValid = urlVal.isValid(url);
			if ((j.valid && urlValid) || (!j.valid && !urlValid)) {
				// Tests pass if port is valid and the url is valid
				// OR
				// if port is invalid and the url is invalid
				System.out.println("Passed: URL -> <" + url + ">... Expected: " + j.valid + ". Actual: " + urlValid);
			} else {
				System.out.println("Failed: URL -> <" + url + ">... Expected: " + j.valid + ". Actual: " + urlValid);
			}
		}
	}

	// Loop though different queries with the rest of the url being valid
	public void testProgrammicQueryJB() {

		System.out.println("Running programming based testing for query...");
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		String baseUrl = "http://www.google.com:80/blah";
		String url;
		Boolean urlValid;

		for (ResultPair j : testUrlQuery) {
			url = baseUrl + j.item;
			urlValid = urlVal.isValid(url);
			if ((j.valid && urlValid) || (!j.valid && !urlValid)) {
				// Tests pass if port is valid and the url is valid
				// OR
				// if port is invalid and the url is invalid
				System.out.println("Passed: URL -> <" + url + ">... Expected: " + j.valid + ". Actual: " + urlValid);
			} else {
				System.out.println("Failed: URL -> <" + url + ">... Expected: " + j.valid + ". Actual: " + urlValid);
			}
		}
	}

	ResultPair[] testUrlScheme = { new ResultPair("http://", true), new ResultPair("https://", true),
			new ResultPair("ftp://", true), new ResultPair("blah://", true), new ResultPair("://", false),
			new ResultPair("/", false), new ResultPair(":", false), new ResultPair("123", false),
			new ResultPair("!!", false), new ResultPair("http:", false), };

	ResultPair[] testUrlAuthority = { new ResultPair("www.google.com", true), new ResultPair("google.com", true),
			new ResultPair("192.168.0.0", true), new ResultPair("1000.1000.1000.1000", false), new ResultPair("1.1.1.256", false),
			new ResultPair("1000.10.10.10", false), new ResultPair("....", false), new ResultPair("abc", false),
			new ResultPair("123", false), new ResultPair(".a.b.a.", false) };

	ResultPair[] testUrlPort = { new ResultPair("", true), new ResultPair(":80", true), new ResultPair(":8080", true),
			new ResultPair(":80808", true), new ResultPair(":808080", false), new ResultPair(":8a", false),
			new ResultPair(":8A", false), new ResultPair(":88A8", false), new ResultPair(":8AAAAA", false),
			new ResultPair(":!@#", false), new ResultPair(":-100", false) };

	ResultPair[] testUrlPath = { new ResultPair("", true), new ResultPair("/blah", true), new ResultPair("/.", true),
			new ResultPair("/..", false), new ResultPair("/...", false), new ResultPair("/?", true),
			new ResultPair("/??", true), new ResultPair("/blah/foo", true), new ResultPair("/blah/foo/bar", true) };

	ResultPair[] testUrlQuery = { new ResultPair("", true), new ResultPair("?key==value", true),
			new ResultPair("?key===value", true), new ResultPair("?key=?value", true),
			new ResultPair("?key=??value", true) };
/**********************
below are Matthew's tests
**********************/
   public void testManualTest01()
   {
	   /*Commented out code can be run once the following bugs have been fixed:
	    * Bug 1 (Found and resolved here): regexs != null --> regexs == null [line 120 RegexValidator.java]
	    * Bug 2 (Found and resolved here): regexs.length-1; --> regexs.length; [line 125 RegexValidator.java]
	    * Bug 3 (Found and resolved here): return null; --> return VALIDATOR; [line 68 InetAddressValidator.java]
	    */
	   System.out.println("Test All Schemes:");
	   UrlValidator urlValidator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println("http://www.google.com/" + "   Expected: true   Actual: " + urlValidator.isValid("http://www.google.com/"));
	   //System.out.println("https://www.google.com/" + "   Expected: true   Actual: " + urlValidator.isValid("https://www.google.com/")); //Error
	   //System.out.println("ftp://www.google.com/" + "   Expected: true   Actual: " + urlValidator.isValid("ftp://www.google.com/")); //Error
	   //3 Bugs found after extensive debugging!
	   System.out.println("www.google.com/" + "   Expected: false   Actual: " + urlValidator.isValid("www.google.com/"));
	   System.out.println();
	   //Error: only http or no url scheme is allowed for ALLOW_ALL_SCHEMES
	   //Bugs found so far(3): RegexValidator.java(lines 120 and 125), InetAddressValidator.java(line 68)
	   //Changes were made in the code for future tests
   }
   
   public void testManualTest02()
   {
	   /*Commented out code can be run once the following bugs have been fixed:
	    * Bug 1 (Found and resolved in testManualTest01()): regexs != null --> regexs == null [line 120 RegexValidator.java]
	    * Bug 2 (Found and resolved in testManualTest01()): regexs.length-1; --> regexs.length; [line 125 RegexValidator.java]
	    * Bug 3 (Found and resolved in testManualTest01()): return null; --> return VALIDATOR; [line 68 InetAddressValidator.java]
	    * Bug 4: schemes[i].toUpperCase --> schemes[i].toLowerCase [line 282 UrlValidator.java]
	    * Bug 5 (Found and resolved here): return !isValidTld(groups[0]); --> return isValidTld(groups[0]); [line 166 DomainValidator.java]
	    */
	   System.out.println("Test Default Schemes:");
	   UrlValidator urlDefault = new UrlValidator();
	   System.out.println("http://www.google.com/" + "   Expected: true   Actual: " + urlDefault.isValid("http://www.google.com/")); //returned false
	   //Bug: Default Schemes do not return true
	   //Partner resolved bug in UrlValidator.java(line 282)
	   System.out.println("http://www.google.com/" + "   Expected: true   Actual: " + urlDefault.isValid("http://www.google.com/")); //returned true after change
	   //System.out.println("ftp://www.google.com/" + "   Expected: true   Actual: " + urlDefault.isValid("ftp://www.google.com/")); //Error
	   //Bug found and corrected: DomainValidator.java(line 166)
	   //System.out.println("ftp://www.google.com/" + "   Expected: true   Actual: " + urlDefault.isValid("ftp://www.google.com/")); //returned true after change
   }
   
   
   public void testAuthorityPartition()
   {
	   /*In order to run this test, these bugs must be changed in the code(bugs were discovered from manual testing):
	    * Bug 1 (Found and resolved in testManualTest01()): regexs != null --> regexs == null [line 120 RegexValidator.java]
	    * Bug 2 (Found and resolved in testManualTest01()): regexs.length-1; --> regexs.length; [line 125 RegexValidator.java]
	    * Bug 3 (Found and resolved in testManualTest01()): return null; --> return VALIDATOR; [line 68 InetAddressValidator.java]
	    * Bug 4: schemes[i].toUpperCase --> schemes[i].toLowerCase [line 282 UrlValidator.java]
	    * Bug 5 (Found and resolved in testManualTest02()): return !isValidTld(groups[0]); --> return isValidTld(groups[0]); [line 166 DomainValidator.java]
	    */
	   
	   String[] authorityUrlString = {"www.google.com", 
	              "go.com", 
	              "go.au", 
	              "0.0.0.0", 
	              "255.255.255.255", 
	              "256.256.256.256", 
	              "255.com", 
	              "1.2.3.4.5", 
	              "1.2.3.4.", 
	              "1.2.3", 
	              ".1.2.3.4", 
	              "go.a", 
	              "go.a1a", 
	              "go.1aa", 
	              "aaa.", 
	              ".aaa", 
	              "aaa", 
	              ""}; 
	   System.out.println("\nTesting Authority Partition:");
	   UrlValidator urlAuthority = new UrlValidator(authorityUrlString, 0);
	   for (int i = 0; i < authorityUrlString.length; i++) {
		      String curAuthority = authorityUrlString[i];
		      System.out.println(curAuthority + " " + urlAuthority.isValidAuthority(curAuthority)); //Bug found!
	   }
	   //Bug 6 (Found and resolved here): if (groups != null) --> if (groups == null) [line 88 InetAddressValidator.java]
	   //Implementing this change will prevent any errors from occurring when running the test
   }

   
   public void testIsValidOptions()
   {
	   /*In order to run this test, these bugs must be changed in the code(bugs were discovered from manual and partition testing):
	    * Bug 1 (Found and resolved in testManualTest01()): regexs != null --> regexs == null [line 120 RegexValidator.java]
	    * Bug 2 (Found and resolved in testManualTest01()): regexs.length-1; --> regexs.length; [line 125 RegexValidator.java]
	    * Bug 3 (Found and resolved in testManualTest01()): return null; --> return VALIDATOR; [line 68 InetAddressValidator.java]
	    * Bug 4: schemes[i].toUpperCase --> schemes[i].toLowerCase [line 282 UrlValidator.java]
	    * Bug 5 (Found and resolved in testManualTest02()): return !isValidTld(groups[0]); --> return isValidTld(groups[0]); [line 166 DomainValidator.java]
	    * Bug 6 (Found and resolved in testAuthorityPartition()): if (groups != null) --> if (groups == null) [line 88 InetAddressValidator.java]
	    */
	   
	   String[] schemeUrlString = {"http://",
			 "ftp://",
	         "h3t://",
	         "3ht://",
	         "http:/",
	         "http:",
	         "http/",
	         "://",
	         ""};

	   String[] authorityUrlString = {"www.google.com",
			"go.com",
			"go.au",
	        "0.0.0.0",
	        "255.255.255.255",
	        "256.256.256.256",
	        "255.com",
	        "1.2.3.4.5",
	        "1.2.3.4.",
	        "1.2.3",
	        ".1.2.3.4",
	        ""};

	   String[] portUrlString = {":80",
	        ":65535",
	        ":0",
	        "",
	        ":-1",
	        ":65636",
	        ":65a"};

	   String[] pathUrlString = {"/test1",
			"/t123",
			"/$23",
			"/..",
			"/../",
			"/test1/",
			"",
			"/test1/file",
			"/..//file",
	   		"/test1//file"};

	   //Test allow2slash, noFragment
	   String[] pathOptionsUrlString = {"/test1",
	        "/t123",
	        "/$23",
	        "/..",
	        "/../", 
	        "/test1/",
	        "/#", 
	        "", 
	        "/test1/file", 
	        "/t123/file", 
	        "/$23/file", 
	        "/../file", 
	        "/..//file", 
	        "/test1//file", 
	        "/#/file"};
	   
	   String[] queryUrlString = {"?action=view",
	        "?action=edit&mode=up",
	        ""};
	   
	   System.out.println("\nProgramming Testing: ");
	   int validCount = 0;
	   int invalidCount = 0;
	   int runs = 1000;
	   for(int i = 0; i < runs; i++) {
		   int schemeInt = (int)(Math.random() * schemeUrlString.length);
		   int authorityInt = (int)(Math.random() * authorityUrlString.length);
		   int portInt = (int)(Math.random() * portUrlString.length);
		   int pathInt = (int)(Math.random() * pathUrlString.length);
		   int optionsInt = (int)(Math.random() * pathOptionsUrlString.length);
		   int queriesInt = (int)(Math.random() * queryUrlString.length);
		   String url = schemeUrlString[schemeInt] + authorityUrlString[authorityInt] + portUrlString[portInt] + pathUrlString[pathInt] 
				   + pathOptionsUrlString[optionsInt] + queryUrlString[queriesInt];
		   UrlValidator validator = new UrlValidator(UrlValidator.ALLOW_2_SLASHES + UrlValidator.ALLOW_ALL_SCHEMES + UrlValidator.NO_FRAGMENTS);
		   
		   boolean valid = validator.isValid(url);
		   if(valid == true) {
			   //System.out.println("+++Valid+++:  " + url);
		       validCount++;
		   } 
		   else {
			   //System.out.println("---Invalid---:  " + url);
			   invalidCount++;
		   }
	   }
	   System.out.println("Number of Valids: " + validCount);
	   System.out.println("Number of Invalids: " + invalidCount);
   }
   
   

}