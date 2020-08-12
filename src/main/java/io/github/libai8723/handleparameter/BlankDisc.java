package io.github.libai8723.handleparameter;

import java.util.*;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private Map<Integer, String> tracks;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(Map<Integer, String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public void play() {
        Set<Integer> trackNumbers = this.tracks.keySet();
        int[] nums = new int[trackNumbers.size()];

        int idx = 0;
        for (Integer integer: trackNumbers
             ) {
            nums[idx] = integer;
            idx++;
        }

        Arrays.sort(nums);

        for (int i: nums
             ) {
            playTrack(i);
        }

    }

    @Override
    public void playTrack(int track) {
        System.out.println("Track " + track + " : " + this.tracks.get(track) + "is playing");
    }

    @Override
    public List<Integer> getTracks() {
        Set<Integer> set = this.tracks.keySet();
        List<Integer> list = new ArrayList<>();

        list.addAll(set);
        Collections.sort(list);
        return list;
    }
}
