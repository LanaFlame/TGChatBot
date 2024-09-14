package dogs.javaschool.tgchatbot;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main extends TelegramLongPollingCommandBot {
    @Override
    public String getBotUsername() {
        return "BodyWayDancesBot";
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        Message message = update.getMessage();
        User user = message.getFrom();
        String username = user.getUserName();
        SendMessage ourMessage = new SendMessage();
        ourMessage.setText("Hi, " + username);
        ourMessage.setChatId(message.getChatId());
        try {
            execute(ourMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotToken() {
        return "6588710310:AAFdwDKbFFEKJPyWy-d9oTh4O5eiZWJk4Pk";
    }
}
