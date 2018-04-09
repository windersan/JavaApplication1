import java.io.*;
import java.util.Scanner;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

public class JavaApp {	

	public static void main(String[] args) throws Exception {

		String currency;           
        Scanner scan = new Scanner(System.in);
        currency = scan.next();
                            
        try{
            String url = "https://api.coinmarketcap.com/v1/ticker/";
            url = url + currency;
            URL obj = new URL(url.trim());
            HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
            int responseCode = conn.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) response.append(inputLine);

            in.close();

            String[] s = response.toString().split("[,]");

            for(int i = 0 ; i<s.length ; i++){
                if(s[i].contains("price_usd")){
                    String[] price = s[i].split("\"");
                    System.out.println("Price: " + price[3]);
                }
                else if(s[i].contains("market_cap_usd")){
                    String[] market_cap = s[i].split("\"");
                    System.out.println("Market cap: " + market_cap[3]);
                }
            }                                                  
        }
        catch (IOException e) {
            System.out.println("Rerun the program and enter a valid currency name.  If you are unsure about what "
                    + "names are valid, go to https://api.coinmarketcap.com/v1/ticker/ and look at each id.  "
                    + "Examples are bitcoin, ethereum, and ripple.");
        }       
    }	
}














