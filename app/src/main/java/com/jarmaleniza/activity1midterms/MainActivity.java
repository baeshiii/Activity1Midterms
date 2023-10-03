package com.jarmaleniza.activity1midterms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView Items;
    MediaPlayer mediaPlayer; // Maintain a reference to the MediaPlayer
    Integer[] ICON = {R.drawable.anti_mage_persona, R.drawable.axe, R.drawable.brew_master, R.drawable.drow_ranger,
            R.drawable.mirana, R.drawable.puck, R.drawable.queen_of_pain, R.drawable.roshan, R.drawable.shadow_fiend, R.drawable.ursa, R.drawable.monggi, R.drawable.clickbait};
//    Integer[] AUDIO_RESOURCES = {
//            R.raw.amclip, R.raw.axeclip, R.raw.brewmasterclip, R.raw.drowrangerclip,
//            R.raw.miranaclip, R.raw.puckclip, R.raw.qopclip, R.raw.roshanclip,
//            R.raw.sfclip, R.raw.ursaclip, R.raw.monggibria, R.raw.clickbait};

    Integer[] AUDIO_RESOURCES = {
            R.raw.amclip, R.raw.axeclip, R.raw.brewmasterclip, R.raw.drowrangerclip,
            R.raw.miranaclip, R.raw.puckclip, R.raw.qopclip, R.raw.roshanclip,
            R.raw.sfclip, R.raw.ursaclip, R.raw.monggibria, R.raw.clickbait
    };

    String[] NAMES = {"AntiMage", "Axe", "Brew Master", "Drow Ranger", "Mirana", "Puck", "Queen Of Pain", "Roshan", "Shadow Fiend", "Ursa", "Haring Monggi", "Do not click!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomAdapter adapter = new CustomAdapter();
        Items = findViewById(R.id.customListView);
        Items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, NAMES[i], Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, CharacterExpandView.class);
                intent.putExtra("CharacterImage", ICON[i]);
                startActivity(intent);

                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }

                mediaPlayer = MediaPlayer.create(MainActivity.this, AUDIO_RESOURCES[i]);
                mediaPlayer.start();
            }
        });
        Items.setAdapter(adapter);
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return ICON.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View v, ViewGroup vg) {
            v = getLayoutInflater().inflate(R.layout.activity_custom_list, null);
            TextView dispName = v.findViewById(R.id.DispName);
            ImageView dispImg = v.findViewById(R.id.DispImg);
            dispName.setText(NAMES[i]);
            dispImg.setImageResource(ICON[i]);
            return v;
        }
    }
}