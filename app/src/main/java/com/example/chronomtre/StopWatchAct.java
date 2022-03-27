package com.example.chronomtre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {
    Button btnstart, btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timerHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart = findViewById(R.id.btnstart);
        btnstop = findViewById(R.id.btnsstop);
        icanchor = findViewById(R.id.icanchor);
        timerHere = findViewById(R.id.timerHere);

        //appliquer l'animation dans une variable
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        //Le btn stop en invisibilité
        btnstop.setAlpha(0);

        //démarrer l'animation de l'horloge en cliquant sur le btn débuter maintenant
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.startAnimation(roundingalone);
                //on passe le btn stop en visibilité et le btn start en invisibilité
                btnstop.animate().alpha(1).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                //démarrer le chronomèetre
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on stop l'animation de l'horloge
                icanchor.clearAnimation();
                ///on passe le btn stop en ivisibilité et le btn start en visibilité
                btnstop.animate().alpha(0).setDuration(300).start();
                btnstart.animate().alpha(1).setDuration(300).start();
                //stoper le chronomèetre
                timerHere.stop();

            }
        });

    }
}