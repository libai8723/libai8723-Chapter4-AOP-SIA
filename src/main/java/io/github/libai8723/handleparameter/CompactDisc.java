package io.github.libai8723.handleparameter;

import java.util.List;

public interface CompactDisc {
    /**
     * play all the tracks in this disc
     */
    void play();

    /**
     * play a certain track with track number
     * @param track the track number
     */
    void playTrack(int track);

    /**
     * get all the track numbers in this disc
     * @return a ordered list of track numbers
     */
    List<Integer> getTracks();
}
