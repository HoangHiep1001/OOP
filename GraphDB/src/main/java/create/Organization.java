package create;

public class Organization extends ThucThe {
    private String truSo;

    public Organization() {
        
    }

    public Organization(String truSo, String DinhDanh, String NhanHienThi, String MoTa, NguonGoc NguonGoc) {
        super(DinhDanh, NhanHienThi, MoTa, NguonGoc);
        this.setTruSo(truSo);
    }    


	@Override
    public void ThemVaoDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public String getTruSo() {
		return truSo;
	}

	public void setTruSo(String truSo) {
		this.truSo = truSo;
	}
    
    
}

