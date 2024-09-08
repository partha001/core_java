package org.partha.p4FieldModification.dto2;

import java.util.Arrays;

public class UserInterfaceConfig {

    private String titleColor;
    private String footerText;
    private short titleFontSize;
    private short footerFontSize;
    private String[] titleFonts;
    private short[] titleTextSizes;

    public String getTitleColor() {
        return titleColor;
    }

    public String getFooterText() {
        return footerText;
    }

    public short getTitleFontSize() {
        return titleFontSize;
    }

    public short getFooterFontSize() {
        return footerFontSize;
    }

    public String[] getTitleFonts() {
        return titleFonts;
    }

    public short[] getTitleTextSizes() {
        return titleTextSizes;
    }

    @Override
    public String toString() {
        return "UserInterfaceConfig{" +
                "titleColor='" + titleColor + '\'' +
                ", footerText='" + footerText + '\'' +
                ", titleFontSize=" + titleFontSize +
                ", footerFontSize=" + footerFontSize +
                ", titleFonts=" + Arrays.toString(titleFonts) +
                ", titleTextSizes=" + Arrays.toString(titleTextSizes) +
                '}';
    }
}
