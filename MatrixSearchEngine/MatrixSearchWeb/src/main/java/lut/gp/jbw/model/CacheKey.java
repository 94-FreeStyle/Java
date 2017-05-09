package lut.gp.jbw.model;

import java.util.List;

/**
 *
 * @author vincent May 9, 2017 4:10:46 PM
 */
public class CacheKey {

    private List<String> words;

    public CacheKey() {
    }

    public CacheKey(List<String> words) {
        this.words = words;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    @Override
    public int hashCode() {
        int hs = 0;
        for (String word : this.words) {
            hs += word.hashCode();
        }
        return hs;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CacheKey other = (CacheKey) obj;
        if (other.words.size() != this.words.size()) {
            return false;
        } else {
            boolean flag = true;
            for (String str : other.words) {
                if (!this.words.contains(str)) {
                    flag = false;
                }
            }
            return flag;
        }
    }

    @Override
    public String toString() {
        String res = "";
        for (String w : this.words) {
            res += w + "\t";
        }
        return res;
    }
}
