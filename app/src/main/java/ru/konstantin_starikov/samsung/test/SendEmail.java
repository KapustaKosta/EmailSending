package ru.konstantin_starikov.samsung.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SendEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
    }

    private String getUserLastNameNameMiddleName()
    {
        //Todo: получение ФИО пользователя
        return "Бычковский" + " " + "Иван" + " " + "Андреевич";
    }

    private String getUserEmail()
    {
        //Todo: получение почты пользователя
        return "k.starikov@lenta.ru";
    }

    public void sendMessage(View v)
    {
        TextInputEditText labelText = findViewById(R.id.labelEditText);
        TextInputEditText textEdit = findViewById(R.id.editText);
        String label = labelText.getText().toString();
        String text = textEdit.getText().toString();
        String userLastNameNameMiddleName = getUserLastNameNameMiddleName();
        String date = new SimpleDateFormat("dd MM yyyy", Locale.forLanguageTag("ru")).format(new Date());
        String userEmail = getUserEmail();
        try {
            // Todo: вместо your_email@gmail.com поставь свою почту, она должна быть от гугла и здесь https://www.google.com/settings/security/lesssecureapps добавь разрешение на пользование аккаунта недоверенными приложениями
                GMailSender sender = new GMailSender("your_email@gmail.com",
                        "password");
                // Todo: вместо password поставь свой пароль
                // Todo: снизу поменяй последнее поле sender
                sender.sendMail("Письмо от пользователя " + userLastNameNameMiddleName, date + " Поступило письмо от пользователя " + userLastNameNameMiddleName + "\n" + "На тему “" + label + "”\n" + "Письмо: " + text, "konstantin.starikon@gmail.com", userEmail);
        } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
        }

        // Todo: тут куда-то ещё переходишь
    }
}