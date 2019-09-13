package tt;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestTelegram {
    private final String TELEGRAM_TOKEN = "850824662:AAHvBfsJNyL0wIhHKUbQxuNteH4eHRBa5PY";
//    private final String CHAT_ID = "356071239";
    private final String CHAT_ID = "-321193089";
    private final String TEXT = "ooooooooooooo";

    public static void main(String[] args) throws Exception {
        TestTelegram telegram = new TestTelegram();
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "https://api.telegram.org/bot" + telegram.TELEGRAM_TOKEN +
                                "/sendMessage")
                )
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("chat_id=" + telegram.CHAT_ID + "&text=" + telegram.TEXT))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }
}
