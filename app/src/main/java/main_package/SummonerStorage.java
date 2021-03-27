package main_package;

public class SummonerStorage {
    private SummonerObject[] summArr;

    public SummonerObject[] get() {
        return summArr;
    }
    public void set(SummonerObject[] in) {
        this.summArr = in;
    }

    private static final SummonerStorage holder = new SummonerStorage();

    public static SummonerStorage getInstance() {
        return holder;
    }
}

// https://stackoverflow.com/a/4878259
