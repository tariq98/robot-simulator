package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Position {
    private int x;
    private int y;

    public boolean isValid() {
        return !(x > 4 || x < 0 || y > 4 || y < 0);
    }
}
