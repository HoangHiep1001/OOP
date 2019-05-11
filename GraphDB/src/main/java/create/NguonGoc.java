package create;

import java.sql.Date;

public class NguonGoc {
    String Link;
    String  NgayTRichRut;
    public NguonGoc() {
    }

    public NguonGoc(String Link, String NgayTRichRut) {
        this.Link = Link;
        this.NgayTRichRut = NgayTRichRut;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public String getNgayTRichRut() {
        return NgayTRichRut;
    }

    public void setNgayTRichRut(String line) {
        this.NgayTRichRut = line;
    }

    
}

