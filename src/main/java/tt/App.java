package tt;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


// https://api.telegram.org/bot{token}/getMe
// 一定要 https
public class App extends TelegramLongPollingBot {
    @Override
    public String getBotToken() {
        return "850824662:AAHvBfsJNyL0wIhHKUbQxuNteH4eHRBa5PY";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("onUpdateReceived");
        if (update.hasMessage() && update.getMessage().hasText()) {
            try {
                execute(new SendMessage()
                        .setChatId(update.getMessage().getChatId())
                        .setText("abcdef"));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "fsadBot";
    }

    public static void main(String[] args) {
        System.out.println("start");
        ApiContextInitializer.init();
        System.out.println("already init");
        try {
            new TelegramBotsApi().registerBot(new App());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
