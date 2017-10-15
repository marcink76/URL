import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println(UrlTest.getPageSource());

        System.out.println(UrlTest.findText(UrlTest.getPageSource()));
    }
}
