package models;

import java.util.ArrayList;

/**
 * Created by val on 06/12/17.
 */
public final class Term {
    private String token;
    private ArrayList<Integer> positions;

    public Term(String token) {
        this.token = token;
        this.positions = new ArrayList<Integer>();
    }

    public Term(String token, ArrayList<Integer> positions) {
        this.token = token;
        this.positions = positions;
    }

    public void addPosition(Integer position) {
        this.positions.add(position);
    }

    public String getToken() {
        return token;
    }

    public String getPositions() {
        return token;
    }
}
