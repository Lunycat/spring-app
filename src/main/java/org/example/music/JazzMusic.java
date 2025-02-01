package org.example.music;

import org.springframework.stereotype.Component;

@Component
public class JazzMusic implements Music {

    @Override
    public String getSong() {
        return "jazz music";
    }
}
