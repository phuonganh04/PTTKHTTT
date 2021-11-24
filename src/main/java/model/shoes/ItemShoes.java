
package model.shoes;

public class ItemShoes {
    protected int id;
    protected float price;
    protected String saleoff, barcode;

    public ItemShoes(int id, float price, String saleoff, String barcode) {
        this.id = id;
        this.price = price;
        this.saleoff = saleoff;
        this.barcode = barcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSaleoff() {
        return saleoff;
    }

    public void setSaleoff(String saleoff) {
        this.saleoff = saleoff;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
}
