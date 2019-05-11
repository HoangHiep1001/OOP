package create;

public abstract class ThucThe {
    protected String DinhDanh;
    protected String NhanHienThi;
    protected String MoTa;
    protected NguonGoc NguonGoc;

    public ThucThe() {
    }

    public ThucThe(String DinhDanh, String NhanHienThi, String MoTa, NguonGoc NguonGoc) {
        this.DinhDanh = DinhDanh;
        this.NhanHienThi = NhanHienThi;
        this.MoTa = MoTa;
        this.NguonGoc = NguonGoc;
    }

    public String getDinhDanh() {
        return DinhDanh;
    }

    public void setDinhDanh(String DinhDanh) {
        this.DinhDanh = DinhDanh;
    }

    public String getNhanHienThi() {
        return NhanHienThi;
    }

    public void setNhanHienThi(String NhanHienThi) {
        this.NhanHienThi = NhanHienThi;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public void setNguonGoc(NguonGoc nguonGoc) {
		NguonGoc = nguonGoc;
	}

	public NguonGoc getNguonGoc() {
        return NguonGoc;
    }

    public abstract void ThemVaoDB();
    
}
