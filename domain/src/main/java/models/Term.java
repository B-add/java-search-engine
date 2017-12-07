package models;

import java.util.ArrayList;

/**
 * Created by val on 06/12/17.
 */
public final class Term {
    public final String token;
    public final ArrayList<Integer> positions;

    public Term(String token, ArrayList<Integer> positions) {
        this.token = token;
        this.positions = positions;
    }

}
