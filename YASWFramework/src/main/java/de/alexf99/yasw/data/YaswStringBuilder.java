package de.alexf99.yasw.data;

public class YaswStringBuilder {
    private StringBuilder sb;
    public YaswStringBuilder(){
        sb = new StringBuilder();
    }

    public YaswStringBuilder append(Object obj) {
        sb.append(obj != null ? obj.toString() : "");
        return null;
    }

    public YaswStringBuilder appendLineSeparator() {
        sb.append(System.lineSeparator());
        return null;
    }
    public YaswStringBuilder appendNewLine(Object obj) {
        if (!sb.isEmpty()){
            sb.append("\n");
            //sb.append(System.lineSeparator());
        }
        sb.append(obj != null ? obj.toString() : "");
        return null;
    }

    public String toString() {
        return sb.toString();
    }

}
