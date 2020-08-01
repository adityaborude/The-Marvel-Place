package com.example.themarvelplace;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textview.MaterialTextView;

public class HomeFragment extends Fragment {

    MaterialTextView materialTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        materialTextView = view.findViewById(R.id.home_text);
        String text = "Marvel was started in 1939 by Martin Goodman under a number of corporations and imprints but now known as Timely Comics, and by 1951 had generally become known as Atlas Comics. The Marvel era began in 1961, the year that the company launched " +
                "The Fantastic Four and other superhero titles created by Stan Lee, Jack Kirby, Steve Ditko and many others." +
                " The Marvel brand, which had been used over the years, was solidified as the company's primary brand.\n\n" +
                "Marvel counts among its characters such well-known superheroes as Spider-Man, Iron Man, the Hulk, Thor, Captain America, Ant-Man, the Wasp, Black Widow," +
                " Wolverine, Captain Marvel, Black Panther, Doctor Strange, Ghost Rider, Blade, Daredevil, the Punisher and Deadpool." +
                " Superhero teams exist such as the Avengers, the X-Men, the Fantastic Four and the Guardians of the Galaxy as well as supervillains including " +
                "Doctor Doom, Magneto, Thanos, Loki, Green Goblin, Kingpin, Red Skull, Ultron, the Mandarin, MODOK, Doctor Octopus, Kang, Dormammu, Annihilus and Galactus." +
                " Most of Marvel's fictional characters operate in a single reality known as the Marvel Universe, with most locations mirroring real-life places; " +
                "many major characters are based in New York City.";
        materialTextView.setText(text);
        return view;
    }
}
