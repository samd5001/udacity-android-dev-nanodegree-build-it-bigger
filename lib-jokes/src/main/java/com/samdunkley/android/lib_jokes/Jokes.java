package com.samdunkleyt.android.lib_jokes;

import java.util.Random;

public class Jokes {

    private static String[] jokes = {
            "A man walks into a bar and says-- \"ouch that's hot\", It was a BARbeque.",
            "How do you keep your nose from running? Teach it to WALK!",
            "Two penguins are sitting in a bathtub. The first one asks the second one to pass him the soap. The second one says, \"What do you think I am, a typewriter?\"",
            "What do you call a fish with three eyes? Fiiish.",
            "Well, you see, there are basically three kinds of people in the world. Those who can count and those that can't.",
            "A man rushes into the doctors and says \"Doctor doctor you've got to hep me I think I'm a pair of curtains\". The doctor replies \"Oh pull yourself together\".",
            "Two parrots sitting on a perch. One says to the other, \"Can you smell fish?\"",
            "What was born to succeed? A budgie with a blunt beak.",
            "What is green and if it were to fall from a tree would kill you? A snooker table",
            "Where does a King keep his armies? In his sleevies"
    };

    private static Random random = new Random();

    public static String getJoke() {
        return jokes[random.nextInt(jokes.length)];
    }

}
