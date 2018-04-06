package javaapplication1;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class JavaApplication1 {
    public static void main(String[] args) throws Exception {
	String currency;                 
        Scanner scan = new Scanner(System.in);
        currency = scan.next();
        try{
            String url = "https://api.coinmarketcap.com/v1/ticker/";
            url = url + currency;
            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String[] s = response.toString().split("[,]");
            for(int i = 0 ; i<s.length ; i++){
                if(s[i].contains("price_usd")){
                    String[] price = s[i].split("\"");
                    System.out.println(price[3]);
                }
                if(s[i].contains("market_cap_usd")){
                    String[] market_cap = s[i].split("\"");
                    System.out.println(market_cap[3]);
                }
            }                                                  
        }
        catch (IOException e) {
            System.out.println("Rerun the program and enter a valid currency name.  If you are unsure about what names are valid, "
                + "go to https://apis.coinmarketcap.com/v1/ticker/ and look at each id.  "
                + "Examples are bitcoin, ethereum, and ripple.");
        }       
    }	
}














