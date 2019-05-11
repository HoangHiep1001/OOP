package create;

public class Country extends ThucThe {
    private String thuDo;
    public Country() {
    }

    public Country(String thuDo, String DinhDanh, String NhanHienThi, String MoTa, NguonGoc NguonGoc) {
        super(DinhDanh, NhanHienThi, MoTa, NguonGoc);
        this.thuDo = thuDo;
    }


    public String getThuDo() {
        return thuDo;
    }

    public void setThuDo(String thuDo) {
        this.thuDo = thuDo;
    }

    @Override
    public void ThemVaoDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}