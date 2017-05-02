package lut.gp.jbw.spider.util;


@FunctionalInterface
public interface LinkFilter {

    public boolean accept(String url);
}
