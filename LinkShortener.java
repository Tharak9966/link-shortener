import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LinkShortener {
    private Map<String, String> shortToLongMap;
    private Map<String, String> longToShortMap;
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_LINK_LENGTH = 6;

    public LinkShortener() {
        shortToLongMap = new HashMap<>();
        longToShortMap = new HashMap<>();
    }

    public String shortenLink(String longLink) {
        if (longToShortMap.containsKey(longLink)) {
            return longToShortMap.get(longLink);
        }

        StringBuilder shortLink = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < SHORT_LINK_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            shortLink.append(CHARACTERS.charAt(index));
        }

        String shortLinkString = shortLink.toString();
        shortToLongMap.put(shortLinkString, longLink);
        longToShortMap.put(longLink, shortLinkString);

        return shortLinkString;
    }

    public String expandLink(String shortLink) {
        return shortToLongMap.getOrDefault(shortLink, "Link not found");
    }

    public static void main(String[] args) {
        LinkShortener shortener = new LinkShortener();

        String longLink = "https://www.example.com/very/long/url/to/a/page";
        String shortLink = shortener.shortenLink(longLink);

        System.out.println("Shortened link: " + shortLink);
        System.out.println("Expanded link: " + shortener.expandLink(shortLink));
    }
}
