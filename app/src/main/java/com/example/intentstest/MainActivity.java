package com.example.intentstest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {
    private Spinner intentSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentSpinner = findViewById(R.id.intentSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.intent_choices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        intentSpinner.setAdapter(adapter);
    }

    public void startIntent(View view) {
        int selectedPosition = intentSpinner.getSelectedItemPosition();
        switch (selectedPosition) {
            case 0: // Ouvrir le navigateur
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.example.com"));
                startActivity(browserIntent);
                break;
            case 1: // Composer un numéro de téléphone
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567890"));
                startActivity(dialIntent);
                break;
            case 2: // Afficher la carte
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=latitude,longitude"));
                startActivity(mapIntent);
                break;
            case 3: // Prendre une photo
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cameraIntent);
                break;
            case 4: // Afficher les contacts
                Intent contactsIntent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
                startActivity(contactsIntent);
                break;
            case 5: // Éditer le premier contact
                Intent editContactIntent = new Intent(Intent.ACTION_EDIT, ContactsContract.Contacts.CONTENT_URI);
                startActivity(editContactIntent);
                break;
        }
    }
}
