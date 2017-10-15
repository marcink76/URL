import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlTest {
    private static final String URL_ADRESS = "http://testy.coni.pl/java.html";
    private static final String PATTERN_TEXT = "<strong id=\"tekst\">(.*?)</strong>";

    public static String getPageSource() throws IOException {
        URL url = new URL(URL_ADRESS);
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));

        String nextLine;
        StringBuilder source = new StringBuilder();
        while ((nextLine = in.readLine()) != null) {
            source.append(nextLine);
        }
        in.close();
        return source.toString();
    }

    public static String findText(String source) {
        Pattern pattern = Pattern.compile(PATTERN_TEXT);
        Matcher matcher = pattern.matcher(source);
        matcher.find();
        System.out.println(matcher.groupCount());
        String resultOf = matcher.group(0);

        String resultOf1 = resultOf.substring(resultOf.indexOf(">") + 1, resultOf.lastIndexOf("<"));
        return resultOf1;
    }

}

